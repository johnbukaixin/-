package com.ptl.rbac.vo;

import java.io.Serializable;

public class DataBean implements Serializable{

		// "productid":"FI-SW-01",
		private String productid;
		// "productname":"Koi",
		private String productname;
		// "unitcost":10.00,
		private double unitcost;
		// "status":"P",
		private String status;
		// "listprice":36.50,
		private double listprice;
		// "attr1":"Large",
		private String attr1;
		// "itemid":"EST-1"
		private String itemid;

		public String getProductid() {
			return productid;
		}

		public void setProductid(String productid) {
			this.productid = productid;
		}

		public String getProductname() {
			return productname;
		}

		public void setProductname(String productname) {
			this.productname = productname;
		}

		public double getUnitcost() {
			return unitcost;
		}

		public void setUnitcost(double unitcost) {
			this.unitcost = unitcost;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public double getListprice() {
			return listprice;
		}

		public void setListprice(double listprice) {
			this.listprice = listprice;
		}

		public String getAttr1() {
			return attr1;
		}

		public void setAttr1(String attr1) {
			this.attr1 = attr1;
		}

		public String getItemid() {
			return itemid;
		}

		public void setItemid(String itemid) {
			this.itemid = itemid;
		}

		@Override
		public String toString() {
			return "DataGriad [productid=" + productid + ", productname=" + productname + ", unitcost=" + unitcost
					+ ", status=" + status + ", listprice=" + listprice + ", attr1=" + attr1 + ", itemid=" + itemid
					+ "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((attr1 == null) ? 0 : attr1.hashCode());
			result = prime * result + ((itemid == null) ? 0 : itemid.hashCode());
			long temp;
			temp = Double.doubleToLongBits(listprice);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((productid == null) ? 0 : productid.hashCode());
			result = prime * result + ((productname == null) ? 0 : productname.hashCode());
			result = prime * result + ((status == null) ? 0 : status.hashCode());
			temp = Double.doubleToLongBits(unitcost);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			DataBean other = (DataBean) obj;
			if (attr1 == null) {
				if (other.attr1 != null)
					return false;
			} else if (!attr1.equals(other.attr1))
				return false;
			if (itemid == null) {
				if (other.itemid != null)
					return false;
			} else if (!itemid.equals(other.itemid))
				return false;
			if (Double.doubleToLongBits(listprice) != Double.doubleToLongBits(other.listprice))
				return false;
			if (productid == null) {
				if (other.productid != null)
					return false;
			} else if (!productid.equals(other.productid))
				return false;
			if (productname == null) {
				if (other.productname != null)
					return false;
			} else if (!productname.equals(other.productname))
				return false;
			if (status == null) {
				if (other.status != null)
					return false;
			} else if (!status.equals(other.status))
				return false;
			if (Double.doubleToLongBits(unitcost) != Double.doubleToLongBits(other.unitcost))
				return false;
			return true;
		}
		
		
		
}
