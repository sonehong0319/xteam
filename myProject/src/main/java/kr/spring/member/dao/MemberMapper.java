package kr.spring.member.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.member.vo.MemberVO;

public interface MemberMapper {
	@Select("SELECT member_seq.nextval FROM dual")
	public int selectMem_num();
	@Insert("INSERT INTO member (mem_num,mem_id) VALUES (#{mem_num},#{mem_id})")
	public void insertMember(MemberVO member);
	@Insert("INSERT INTO member_detail (mem_num,mem_name,mem_passwd,mem_phone,mem_email) VALUES (#{mem_num},#{mem_name},#{mem_passwd},#{mem_phone},#{mem_email})")
	public void insertMember_detail(MemberVO member);
	@Select("SELECT m.mem_num,m.mem_id,m.mem_auth,d.mem_passwd,d.mem_photoname,d.mem_email FROM member m LEFT OUTER JOIN member_detail d ON m.mem_num=d.mem_num WHERE m.mem_id=#{mem_id}")
	public MemberVO selectCheckMember(String mem_id);
	@Select("SELECT * FROM member m JOIN member_detail d ON m.mem_num=d.mem_num WHERE m.mem_num=#{mem_num}")
	public MemberVO selectMember(Integer mem_num);
	@Update("UPDATE member_detail SET mem_name=#{mem_name},mem_phone=#{mem_phone},mem_email=#{mem_email},modify_date=SYSDATE WHERE mem_num=#{mem_num}")
	public void updateMember(MemberVO member);
	@Update("UPDATE member_detail SET mem_passwd=#{mem_passwd} WHERE mem_num=#{mem_num}")
	public void updatePassword(MemberVO member);
	@Update("UPDATE member SET auth=0 WHERE mem_num=#{mem_num}")
	public void deleteMember(Integer mem_num);
	@Delete("DELETE FROM member_detail WHERE mem_num=#{mem_num}")
	public void deleteMember_detail(Integer mem_num);
	//프로필 이미지 업데이트
	@Update("UPDATE member_detail SET mem_photo=#{mem_photo},mem_photoname=#{mem_photoname} WHERE mem_num=#{mem_num}")
	public void updateProfile(MemberVO member);
}







