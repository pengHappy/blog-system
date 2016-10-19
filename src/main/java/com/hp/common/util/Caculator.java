package com.hp.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Caculator {
	public long eval(String exp) {
		List<String> list = infixExpToPostExp(exp);// 转化成后缀表达式
		return doEval(list);// 真正求值
	}
	// 遇到操作符压栈，遇到表达式从后缀表达式中弹出两个数，计算出结果，压入堆栈
	private long doEval(List<String> list) {
		Stack<String> stack = new Stack<String>();
		String element;
		long n1, n2, result;
		try {
			for (int i = 0; i < list.size(); i++) {
				element = list.get(i);
				if (isOperator(element)) {
					n1 = Long.parseLong(stack.pop());
					n2 = Long.parseLong(stack.pop());
					result = doOperate(n1, n2, element);
					stack.push(new Long(result).toString());
				} else {
					stack.push(element);
				}
			}
			return Long.parseLong(stack.pop());
		} catch (RuntimeException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	private long doOperate(long n1, long n2, String operator) {
		if (operator.equals("+"))
			return n1 + n2;
		else if (operator.equals("-"))
			return n1 - n2;
		else if (operator.equals("*"))
			return n1 * n2;
		else
			return n1 / n2;
	}

	private boolean isOperator(String str) {
		return str.equals("+") || str.equals("-") || str.equals("*")
				|| str.equals("/");
	}

	private List<String> infixExpToPostExp(String exp) {// 将中缀表达式转化成为后缀表达式
		exp+="#";
		List<String> postExp = new ArrayList<String>();// 存放转化的后缀表达式的链表
		StringBuffer numBuffer = new StringBuffer();// 用来保存一个数的
		Stack<Character> opStack = new Stack<Character>();// 操作符栈
		char ch, preChar;
		opStack.push('#');
		try {
			for (int i = 0; i < exp.length();) {
				ch = exp.charAt(i);
				switch (ch) {
				case '+':
				case '-':
				case '*':
				case '/':
					preChar = opStack.peek();
					// 如果栈里面的操作符优先级比当前的大，则把栈中优先级大的都添加到后缀表达式列表中
					while (priority(preChar) >= priority(ch)) {
						postExp.add("" + preChar);
						opStack.pop();
						preChar = opStack.peek();
					}
					opStack.push(ch);
					i++;
					break;
				case '(':
					// 左括号直接压栈
					opStack.push(ch);
					i++;
					break;
				case ')':
					// 右括号则直接把栈中左括号前面的弹出，并加入后缀表达式链表中
					char c = opStack.pop();
					while (c != '(') {
						postExp.add("" + c);
						c = opStack.pop();
					}
					i++;
					break;
				// #号，代表表达式结束，可以直接把操作符栈中剩余的操作符全部弹出，并加入后缀表达式链表中
				case '#':
					char c1;
					while (!opStack.isEmpty()) {
						c1 = opStack.pop();
						if (c1 != '#')
							postExp.add("" + c1);
					}
					i++;
					break;
				// 过滤空白符
				case ' ':
				case '\t':
					i++;
					break;
				// 数字则凑成一个整数，加入后缀表达式链表中
				default:
					if (Character.isDigit(ch)) {
						while (Character.isDigit(ch)) {
							numBuffer.append(ch);
							ch = exp.charAt(++i);
						}
						postExp.add(numBuffer.toString());
						numBuffer = new StringBuffer();
					} else {
						throw new IllegalArgumentException("illegal operator");
					}
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new IllegalArgumentException(e.getMessage());
		}
		return postExp;
	}

	private int priority(char op) {// 定义优先级
		switch (op) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '(':
		case '#':
			return 0;
		}
		throw new IllegalArgumentException("Illegal operator");
	}

	public static long caculate(String exp) {
		return  new Caculator().eval(exp);
	}

}
