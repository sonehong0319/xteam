package kr.spring.board.vo;

import java.io.IOException;
import java.sql.Date;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	private int board_num; //게시판 번호
	@NotEmpty
	private String board_title; //제목
	@NotEmpty
	private String board_content; //내용
	private int board_hit; //조회수
	private Date board_reg_date; //등록일
	private Date board_modify_date; //수정일
	private byte[] board_uploadfile;//이미지 파일
	private String board_filename;//파일명
	private int mem_num;//회원 번호
	private String id;//회원 아이디
	
	//이미지 업로드 파일 처리
	public void setUpload(MultipartFile upload)throws IOException{
		//MultipartFile -> byte[] 반환
		setboard_Uploadfile(upload.getBytes());
		//파일명 구하기
		setboard_Filename(upload.getOriginalFilename());
	}
	
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getboard_Title() {
		return board_title;
	}
	public void setboard_Title(String board_title) {
		this.board_title = board_title;
	}
	public String getboard_Content() {
		return board_content;
	}
	public void setboard_Content(String board_content) {
		this.board_content = board_content;
	}
	public int getboard_Hit() {
		return board_hit;
	}
	public void setboard_Hit(int board_hit) {
		this.board_hit = board_hit;
	}
	public Date getboard_Reg_date() {
		return board_reg_date;
	}
	public void setboard_Reg_date(Date board_reg_date) {
		this.board_reg_date = board_reg_date;
	}
	public Date getboard_Modify_date() {
		return board_modify_date;
	}
	public void setboard_Modify_date(Date board_modify_date) {
		this.board_modify_date = board_modify_date;
	}
	public byte[] getboard_Uploadfile() {
		return board_uploadfile;
	}
	public void setboard_Uploadfile(byte[] board_uploadfile) {
		this.board_uploadfile = board_uploadfile;
	}
	public String getboard_Filename() {
		return board_filename;
	}
	public void setboard_Filename(String board_filename) {
		this.board_filename = board_filename;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "BoardVO [board_num=" + board_num + ", board_title=" + board_title + ", board_content=" + board_content + ", board_hit=" + board_hit
				+ ", board_reg_date=" + board_reg_date + ", board_modify_date=" + board_modify_date + ", board_filename=" + board_filename + ", mem_num=" + mem_num + ", id=" + id + "]";
	}

}





