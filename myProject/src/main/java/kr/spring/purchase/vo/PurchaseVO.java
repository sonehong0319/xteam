package kr.spring.purchase.vo;

import java.sql.Date;

public class PurchaseVO {
	private int pur_num;
	private int mem_num;
	private int gam_num;
	private String gam_name;
	private Date pur_date;
	private byte[] gam_uploadfile;
	
	public int getPur_num() {
		return pur_num;
	}
	public void setPur_num(int pur_num) {
		this.pur_num = pur_num;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public int getGam_num() {
		return gam_num;
	}
	public void setGam_num(int gam_num) {
		this.gam_num = gam_num;
	}
	public String getGam_name() {
		return gam_name;
	}
	public void setGam_name(String gam_name) {
		this.gam_name = gam_name;
	}
	public Date getPur_date() {
		return pur_date;
	}
	public void setPur_date(Date pur_date) {
		this.pur_date = pur_date;
	}
	public byte[] getGam_uploadfile() {
		return gam_uploadfile;
	}
	public void setGam_uploadfile(byte[] gam_uploadfile) {
		this.gam_uploadfile = gam_uploadfile;
	}
	
	@Override
	public String toString() {
		return "PurchaseVO [pur_num=" + pur_num + ", mem_num=" + mem_num + ", gam_num=" + gam_num + ", gam_name="
				+ gam_name + ", pur_date=" + pur_date + "]";
	}
	
	
}
