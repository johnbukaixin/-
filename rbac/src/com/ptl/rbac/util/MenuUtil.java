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
		//��һ���˵�����map��  
		for(Permission p:list){
			if(p.getPid()==0){
				map.put(p.getId(), p);
				continue;
			}
			//�����ݿ��� �Ѿ�����pid������������� ���Ե��ߵ�breakʱ��˵������һ���˵��Ѿ�����map��
			break;
		}
		//��������˵�---�������˵������Ӧ��һ���˵���
		for(Permission p:list){
			if(p.getPid()==0){
				continue;
			}
//			if(pm==null){//pmΪnullʱ  ��p��һ���˵�
//				continue;
//			}
			Permission pm=map.get(p.getPid());
			pm.getChildren().add(p);
		}
		//������ map���Ѿ����Ӹ�����ϵ��
		//��map�еĲ˵� ת��ΪList��
		List<Permission> menu = new ArrayList<Permission>();
		for(Iterator<Integer> iter=map.keySet().iterator();iter.hasNext();){
			menu.add(map.get(iter.next()));
		}
		//��menu�������Ѿ����Ӹ�����ϵ��List
		
		//����
		for(Permission p:menu){
			//���Ӳ˵�����
			Collections.sort(p.getChildren());
		}
		//����һ���˵�
		Collections.sort(menu);
		return menu;
	}
}
