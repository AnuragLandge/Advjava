package com.demo.beans;

public class CartItem {
	private int pid;
	private String pname;
	private int ordQty;
	private Double price;

	// private String status;
	// private String comment;
	public CartItem() {
		super();
	}

	public CartItem(int pid, String pname, int ordQty, Double price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.ordQty = ordQty;
		this.price = price;
	}

	@Override
	public String toString() {
		return "CartItem [pid=" + pid + ", pname=" + pname + ", ordQty=" + ordQty + ", price=" + price + "]";
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getOrdQty() {
		return ordQty;
	}

	public void setOrdQty(int ordQty) {
		this.ordQty = ordQty;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
