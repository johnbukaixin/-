package com.ptl.rbac.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ptl.rbac.vo.Node;

@Controller
public class TreeController {

	@RequestMapping(value="node",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Node> getTreeNodes(@RequestParam(value="id",required=false,defaultValue="0")int id){
		List<Node> nodes=new ArrayList<>();
		Node node=null;
		
		for(int i=0;i<5;i++){
			node=new Node();
			node.setId(i);
			node.setText("node-" + id + "-" + i);
			if(id!=0){
				node.setState("open");
			}else{
				node.setState("closed");
			}
			nodes.add(node);
		}
		return nodes;
	}
}
