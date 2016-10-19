package com.hp.common.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.activation.MimetypesFileTypeMap;

public class MimeTypeUtil {
	private MimetypesFileTypeMap mimeType;
	private static MimeTypeUtil uniqueInstance = null;
	public static MimeTypeUtil getSignInstance(){
		if(uniqueInstance!=null){
			return uniqueInstance;
		}else{
			try {
				return new MimeTypeUtil(new MimetypesFileTypeMap(new FileInputStream(MimeTypeUtil.class.getResource("/").getPath()+"mime.types")));
			} catch (FileNotFoundException e) {
				return new MimeTypeUtil(new MimetypesFileTypeMap());
			}
		}
	}
	
	public MimeTypeUtil(MimetypesFileTypeMap mimeType) {
		this.mimeType = mimeType;
	}

	
	public int getFileTypeCode(String filename){
		try {
			MimetypesFileTypeMap mm=getSignInstance().mimeType;
			String type = mm.getContentType(filename);
			if((type != null && type.contains("image"))){
				return 1;
			}
		} catch (Exception e) {
			return 0;
		}
		return 0;
	}
	public String getFileTypeStr(String filename){
		try {
			MimetypesFileTypeMap mm=getSignInstance().mimeType;
			String type = mm.getContentType(filename);
			return type;
		} catch (Exception e) {
			return null;
		}
	}
}
