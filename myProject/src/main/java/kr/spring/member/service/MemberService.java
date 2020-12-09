package kr.spring.member.service;

import kr.spring.member.vo.MemberVO;

public interface MemberService {
	public void insertMember(MemberVO member);
	public MemberVO selectCheckMember(String mem_id);
	public MemberVO selectMember(Integer mem_num);
	public void updateMember(MemberVO member);
	public void updatePassword(MemberVO member);
	public void deleteMember(Integer mem_num);
	public void updateProfile(MemberVO member);
}







