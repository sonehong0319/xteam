package kr.spring.game.vo;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

public class GameVO {
	private int gam_num; //게임 번호
	@NotEmpty
	private String gam_name; //게임 이름
	@NotEmpty
	private int gam_price; //게임 가격
	private Date gam_date; //게임 출시일
	private int gam_hit; //게임 판매 수
	private String gam_detail; //게임 정보
	private byte[] gam_uploadfile; //게임 이미지
	private int cate_num;//카테고리 번호
	
	//이미지 업로드 파일 처리
	public void setUpload(MultipartFile upload)throws IOException{
		//MultipartFile -> byte[] 반환
		setGam_uploadfile(upload.getBytes());
		
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



	public int getGam_price() {
		return gam_price;
	}



	public void setGam_price(int gam_price) {
		this.gam_price = gam_price;
	}



	public Date getGam_date() {
		return gam_date;
	}



	public void setGam_date(Date gam_date) {
		this.gam_date = gam_date;
	}



	public int getGam_hit() {
		return gam_hit;
	}



	public void setGam_hit(int gam_hit) {
		this.gam_hit = gam_hit;
	}



	public String getGam_detail() {
		return gam_detail;
	}



	public void setGam_detail(String gam_detail) {
		this.gam_detail = gam_detail;
	}



	public byte[] getGam_uploadfile() {
		return gam_uploadfile;
	}



	public void setGam_uploadfile(byte[] gam_uploadfile) {
		this.gam_uploadfile = gam_uploadfile;
	}



	public int getCate_num() {
		return cate_num;
	}



	public void setCate_num(int cate_num) {
		this.cate_num = cate_num;
	}



	@Override
	public String toString() {
		return "GameVO [gam_num=" + gam_num + ", gam_name=" + gam_name + ", gam_price=" + gam_price + ", gam_date="
				+ gam_date + ", gam_hit=" + gam_hit + ", gam_detail=" + gam_detail + ", gam_uploadfile="
				+ Arrays.toString(gam_uploadfile) + ", cate_num=" + cate_num + "]";
	}
	
	
}
	
	


