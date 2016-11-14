package com.prj.api.common.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class convertCollection {

	public static Map<String, String> getParameter(Map<String, String[]> paramMap) {

		Set<String> keySet = paramMap.keySet();
		Iterator<String> it = keySet.iterator();

		Map<String, String> map = new HashMap<String, String>();

		while (it.hasNext()) {
			String key = it.next();
			String value = (String) paramMap.get(key)[0];
			map.put(key, value);
		}

		return map;
	}

	public static Map<String, String[]> getParameterArray(Map<String, String[]> paramMap) {

		Set<String> keySet = paramMap.keySet();
		Iterator<String> it = keySet.iterator();

		Map<String, String[]> map = new HashMap<String, String[]>();

		while (it.hasNext()) {
			String key = it.next();
			String[] value = (String[]) paramMap.get(key);

			map.put(key, value);
		}
		return map;
	}

	public static String getCurrentMethod() {
		Exception e = new Exception();
		StackTraceElement[] ste = e.getStackTrace();
		String message = ste[1].getMethodName();
		// for(int i=0; i < 20 && i < ste.length; i++)
		// message += ste[i].getClassName() + "(" + ste[i].getFileName() +":" +
		// ste[i].getLineNumber() + ")\n";
		return message;
	}

	public static String getCurrentClass() {
		Exception e = new Exception();
		StackTraceElement[] ste = e.getStackTrace();
		String message = ste[1].getClassName();
		// for(int i=0; i < 20 && i < ste.length; i++)
		// message += ste[i].getClassName() + "(" + ste[i].getFileName() +":" +
		// ste[i].getLineNumber() + ")\n";
		return message;
	}

	public static StackTraceElement getCurrentSTE() {
		Exception e = new Exception();
		StackTraceElement[] ste = e.getStackTrace();
		return ste[1];
	}
}
