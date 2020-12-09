package kr.spring.member.vo;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class MemberVO {
	private int mem_num;
	@Size(min=4,max=10)
	private String mem_id;
	private int mem_auth;
	@NotEmpty
	private String mem_name;
	@Size(min=4,max=10)
	private String mem_passwd;
	@NotEmpty
	private String mem_phone;
	@Email
	@NotEmpty
	private String mem_email;
	private byte[] mem_photo;
	private String mem_photoname;
	private Date reg_date;
	//비밀번호 변경시 현재 비밀번호를 저장하는 용도로 사용
	@Size(min=4,max=10)
	private String now_passwd;

	//==============비밀번호 일치 여부 체크============//
	public boolean isCheckedPasswd(String userPasswd) {
		if(mem_auth > 1 && mem_passwd.equals(userPasswd)) {
			return true;
		}
		return false;
	}
	
	//=======이미지 BLOB 처리 =========//
	public void setUpload(MultipartFile upload)
			                  throws IOException{
		//MultipartFile -> byte[]
		setMem_photo(upload.getBytes());
		//파일 이름
		setMem_photoname(upload.getOriginalFilename());
	}

	public int getMem_num() {
		return mem_num;
	}

	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public int getMem_auth() {
		return mem_auth;
	}

	public void setMem_auth(int mem_auth) {
		this.mem_auth = mem_auth;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_passwd() {
		return mem_passwd;
	}

	public void setMem_passwd(String mem_passwd) {
		this.mem_passwd = mem_passwd;
	}

	public String getMem_phone() {
		return mem_phone;
	}

	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public byte[] getMem_photo() {
		return mem_photo;
	}

	public void setMem_photo(byte[] mem_photo) {
		this.mem_photo = mem_photo;
	}

	public String getMem_photoname() {
		return mem_photoname;
	}

	public void setMem_photoname(String mem_photoname) {
		this.mem_photoname = mem_photoname;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public String getNow_passwd() {
		return now_passwd;
	}

	public void setNow_passwd(String now_passwd) {
		this.now_passwd = now_passwd;
	}

	@Override
	public String toString() {
		return "MemberVO [mem_num=" + mem_num + ", mem_id=" + mem_id + ", mem_auth=" + mem_auth + ", mem_name=" + mem_name
				+ ", mem_passwd=" + mem_passwd + ", mem_phone=" + mem_phone + ", mem_email=" + mem_email
				+ ", mem_photo=" + Arrays.toString(mem_photo) + ", mem_photoname=" + mem_photoname + ", reg_date="
				+ reg_date + ", now_passwd=" + now_passwd + "]";
	}
}

	
	





