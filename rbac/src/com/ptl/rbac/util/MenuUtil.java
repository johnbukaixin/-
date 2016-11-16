package com.ptl.rbac.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ptl.rbac.vo.Permission;

public class MenuUtil {
	public static List<Permission> listToMenu(List<Permission> list){
		Map<Integer,Permission> map = new HashMap<Integer,Permission>();
		//将一级菜单放入map中  
		for(Permission p:list){
			if(p.getPid()==0){
				map.put(p.getId(), p);
				continue;
			}
			//在数据库中 已经按照pid进行升序的排序 所以当走到break时，说明所有一级菜单已经放入map中
			break;
		}
		//处理二级菜单---将二级菜单放入对应的一级菜单中
		for(Permission p:list){
			if(p.getPid()==0){
				continue;
			}
//			if(pm==null){//pm为null时  该p是一级菜单
//				continue;
//			}
			Permission pm=map.get(p.getPid());
			pm.getChildren().add(p);
		}
		//到这里 map中已经是子父级关系。
		//将map中的菜单 转换为List中
		List<Permission> menu = new ArrayList<Permission>();
		for(Iterator<Integer> iter=map.keySet().iterator();iter.hasNext();){
			menu.add(map.get(iter.next()));
		}
		//在menu中数据已经是子父级关系的List
		
		//排序
		for(Permission p:menu){
			//将子菜单排序
			Collections.sort(p.getChildren());
		}
		//排序一级菜单
		Collections.sort(menu);
		return menu;
	}
}
