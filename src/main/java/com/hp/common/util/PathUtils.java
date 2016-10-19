package com.hp.common.util;

import java.io.File;

public final class PathUtils {
	private PathUtils() {
	}

	public static char SEPARATOR = '/';
	public static String normalize(String filename) {
		return doNormalize(filename, SEPARATOR);
	}
	private static String doNormalize(String filename, char separator) {
		if (filename == null || filename.length()==0||DEFAULT_PATH.equals(filename)) {
			return DEFAULT_PATH;
		}
		int size = filename.length();
		char[] array = new char[size+2];
		int arrstart=0;
		if(filename.indexOf(SEPARATOR)!=0){
			array[0] = separator;
			size++;
			arrstart=1;
		}
		filename.getChars(0, filename.length(), array, arrstart);
		if (array[size - 1] != separator) {
			array[size++] = separator;
		}
		for (int i = 1; i < size; i++) {
			if (array[i] == separator && array[i - 1] == separator) {
				// 转// 为 /
				System.arraycopy(array, i, array, i - 1, size - i);
				size--;
				i--;
			} else if (i > 1 && array[i] == separator && array[i - 1] == '.'
					&& array[i - 2] == separator) {
				// 转 /./ 为 /
				System.arraycopy(array, i + 1, array, i - 1, size - i);
				size -= 2;
				i--;
			} else if (i > 2 && array[i] == separator && array[i - 1] == '.'
					&& array[i - 2] == '.' && array[i - 3] == separator) {
				// 转 /b/a/../ 为 /b
				if (i - 4 > 0) {
					/*
					 * 非根部分出现 /../ 如： /a/b/../c ---> /a/c
					 */
					for (int j = i - 4; j >= 0; j--) {
						if (array[j] == separator) {
							System.arraycopy(array, i + 1, array, j + 1, size
									- i);
							size -= i - j;
							i = j + 1;
							break;
						}
					}
				} else {
					/*
					 * 根部分出现 /../ 如： /../a/b/ ---> /a/b
					 */
					System.arraycopy(array, i + 1, array, 1, size - i);
					size -= 3;
					i = 1;
				}
			}
		}
		return new String(array, 0, size - 1);
	}

	private static final String DEFAULT_NAME = ""+SEPARATOR;
	public static String name(String path) {
		if (path == null) {
			return DEFAULT_NAME;
		} else if (path.length() == 0) {
			return DEFAULT_NAME;
		} else if (DEFAULT_NAME.equals(path)) {
			return DEFAULT_NAME;
		} else {
			int lastPos = path.lastIndexOf(SEPARATOR);
			return path.substring(lastPos + 1);
		}
	}
	private static final String DEFAULT_PATH = ""+SEPARATOR;
	public static String parent(String path) {
		if (path == null) {
			return DEFAULT_PATH;
		} else if (path.length() == 0) {
			return DEFAULT_PATH;
		} else if (DEFAULT_PATH.equals(path)) {
			return DEFAULT_PATH;
		} else {
			int lastPos = path.lastIndexOf(SEPARATOR);
			if (lastPos > 0) {
				return path.substring(0, lastPos);
			}
			return DEFAULT_PATH;
		}
	}
	public static String path2Hash(String path) {
		if (File.separatorChar != PathUtils.SEPARATOR) {
			path = path.replace(File.separatorChar, PathUtils.SEPARATOR);
		}
		return PathUtils.name(PathUtils.parent(path)) + PathUtils.name(path);
	}
	public static String hashTopath(String basePath,String hash) {
		String pre = basePath + File.separator + hash.substring(0, 2);
		File f = new File(pre);
		if (!f.exists()) {
			f.mkdirs();
		}
		return pre + File.separator + hash.substring(2);
	}
	public static String fileExtension(String fileName){
		if(fileName==null){
			return "";
		}
		if(fileName.lastIndexOf(".")!=-1&&fileName.lastIndexOf(".")!=0){
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		} else{
			return "";
		}
	}
}
