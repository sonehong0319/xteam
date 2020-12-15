package kr.spring.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.member.service.MemberService;
import kr.spring.member.vo.MemberVO;

@Controller
public class MemberAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	@RequestMapping("/member/confirmId.do")
	@ResponseBody
	public Map<String,String> process(
			             @RequestParam("mem_id") String mem_id){
		if(log.isDebugEnabled()) {
			log.debug("<<아이디 중복 체크>> : " + mem_id);
		}
		
		Map<String,String> map =
				new HashMap<String,String>();
		
		MemberVO member = memberService.selectCheckMember(mem_id);
		if(member!=null) {
			//아이디 중복
			map.put("result", "idDuplicated");
		}else {
			//아이디 미중복
			map.put("result", "idNotFound");
		}
		
		return map;
	}
	
	//프로필 사진 업데이트
	@RequestMapping("/member/updateMyPhoto.do")
	@ResponseBody
	public Map<String,String> processProfile(MemberVO memberVO,
			              HttpSession session){
		Map<String,String> map = new HashMap<String,String>();
		
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user==null) {
			//로그인 되지 않은 경우
			map.put("result", "logout");
		}else {
			//로그인 된 경우
			memberVO.setMem_num(user.getMem_num());
			memberService.updateProfile(memberVO);
			
			//이미지를 업로드한 후 세션에 저장된 회원 정보의 이미지 이름 교체
			user.setMem_photoname(memberVO.getMem_photoname());
			
			map.put("result", "success");
		}
		
		return map;
	}
	
}










