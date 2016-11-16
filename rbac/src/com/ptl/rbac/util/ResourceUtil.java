package com.ptl.rbac.util;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class ResourceUtil {
	private static Properties props =null;
	public static Set<String> getPropertis(String filename){
		props = new Properties();
		try {
			props.load(ResourceUtil.class.getClassLoader().getResourceAsStream(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Set<String> set=new HashSet<String>();
		for(Iterator<Object> iter = props.keySet().iterator();iter.hasNext();){
			set.add(iter.next()+"");
		}
		return set;
	}
}
