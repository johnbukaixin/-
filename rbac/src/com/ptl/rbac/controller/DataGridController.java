package com.ptl.rbac.controller;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ptl.rbac.vo.DataBean;
import com.ptl.rbac.vo.DataGridBean;

@Controller
public class DataGridController {

	@RequestMapping(value = "datagrid", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public DataGridBean getGridData(
			@RequestParam(value = "rows", required = false, defaultValue = "10") long rows,
			@RequestParam(value = "page", required = false, defaultValue = "1") long page) {
		DataGridBean bean = new DataGridBean();
		
		System.out.println("rows = " + rows);
		System.out.println("page = " + page);
		
		bean.setTotal(32);

		for (int i = 0; i < 6; i++) {
			DataBean db = new DataBean();
			db.setAttr1("attr1" + i + "page = " + page + "row=" + rows);
			db.setItemid("itemid" + i);
			db.setListprice(i + 10.5);
			db.setProductid("productid" + i);
			db.setProductname("productname" + i);
			db.setStatus("status" + i);
			db.setUnitcost(21.5 + i);
			bean.getRows().add(db);
		}
		return bean;
	}

}