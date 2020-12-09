package kr.spring.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.member.service.MemberService;
import kr.spring.member.vo.MemberVO;
import kr.spring.util.LoginCheckException;

@Controller
public class MemberController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	//자바빈(VO) 초기화
	@ModelAttribute
	public MemberVO initCommand() {
		return new MemberVO();
	}
	
	//회원가입 폼 
	@RequestMapping(value="/member/registerUser.do",
			                      method=RequestMethod.GET)
	public String form() {
		return "memberRegister";
	}
	
	//회원가입 처리
	@RequestMapping(value="/member/registerUser.do",
			            method=RequestMethod.POST)
	public String submit(@Valid MemberVO memberVO,
			       BindingResult result) {
		if(log.isDebugEnabled()) {
			log.debug("<<회원 가입>> : " + memberVO);
		}
		
		//유효성 체크 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return form();
		}
		
		//회원 가입
		memberService.insertMember(memberVO);
		
		return "redirect:/main/main.do";
	}
	
	//로그인 폼
	@RequestMapping(value="/member/login.do",
			        method=RequestMethod.GET)
	public String formLogin() {
		return "memberLogin";
	}
	
	//로그인 처리
	@RequestMapping(value="/member/login.do",
			        method=RequestMethod.POST)
	public String submitLogin(@Valid MemberVO memberVO,
			                     BindingResult result,
			                     HttpSession session) {
		if(log.isDebugEnabled()) {
			log.debug("<<MemberVO>> : " + memberVO);
		}
		
		//id와 passwd 필드만 체크
		if(result.hasFieldErrors("mem_id") || 
				 result.hasFieldErrors("mem_passwd")) {
			return formLogin();
		}
		
		//로그인 체크(id와 비밀번호 일치 여부 체크)
		try {
			MemberVO member = 
					memberService.selectCheckMember(memberVO.getMem_id());
			boolean check = false;
			
			if(member!=null) {
				//비밀번호 일치 여부 체크
				check = member.isCheckedPasswd(memberVO.getMem_passwd());
			}
			
			if(check) {
				//인증 성공, 로그인 처리
				session.setAttribute("user", member);
				
				return "redirect:/main/main.do";
			}else {
				//인증 실패
				throw new LoginCheckException();
			}
			
		}catch(LoginCheckException e) {
			//인증 실패로 로그인폼 호출
			result.reject("invalidIdOrPassword");
			
			return formLogin();
		}
	}
	//로그아웃
	@RequestMapping("/member/logout.do")
	public String processLogout(HttpSession session) {
		//로그아웃
		session.invalidate();
		
		return "redirect:/main/main.do";
	}
	
	//회원 상세 정보
	@RequestMapping("/member/myPage.do")
	public String process(HttpSession session,
			              Model model) {
		//회원번호를 얻기위해 세션에 저장된 회원 정보를 반환
		MemberVO vo = (MemberVO)session.getAttribute("user");
		
		MemberVO member = 
				memberService.selectMember(vo.getMem_num());
		
		if(log.isDebugEnabled()) {
			log.debug("<<회원 상세 정보>> : " + member);
		}
		
		model.addAttribute("member", member);
		
		return "memberView";
	}
	
	//회원 정보 수정 폼
	@RequestMapping(value="/member/update.do", method=RequestMethod.GET)
	public String formUpdate(HttpSession session,
			                                  Model model) {
		//회원 번호를 구하기 위해 세션에 저장된 회원 정보 반환
		MemberVO vo = (MemberVO)session.getAttribute("user");
		
		MemberVO memberVO = 
				memberService.selectMember(vo.getMem_num());
		
		model.addAttribute("memberVO", memberVO);
		
		return "memberModify";
	}
	
	//회원 정보 수정 처리
	@RequestMapping(value="/member/update.do",method=RequestMethod.POST)
	public String submitUpdate(@Valid MemberVO memberVO,
			           BindingResult result,
			           HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<회원 정보 수정 처리>> : " + memberVO);
		}
		
		//유효성 체크 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return "memberModify";
		}
		
		//회원 번호를 얻기 위해 세션에 저장된 회원 정보 반환
		MemberVO vo = (MemberVO)session.getAttribute("user");
		//전송된 데이터가 저장된 자바빈에 회원 번호를 저장
		memberVO.setMem_num(vo.getMem_num());
		
		//회원 정보 수정
		memberService.updateMember(memberVO);
		
		return "redirect:/member/myPage.do";
	}
	
	//비밀번호 변경 폼
	@RequestMapping(value="/member/changePassword.do",
			             method=RequestMethod.GET)
	public String formChangePassword() {
		return "memberChangePassword";
	}
	//비밀번호 변경 처리
	@RequestMapping(value="/member/changePassword.do",
			             method=RequestMethod.POST)
	public String submitChangePassword(@Valid MemberVO memberVO,
			             BindingResult result,
			             HttpSession session) {
		if(log.isDebugEnabled()) {
			log.debug("<<비밀번호 변경 처리>> : " + memberVO);
		}
		
		//현재 비밀번호와 변경할 비밀번호가 전송됐는지 여부를 체크
		if(result.hasFieldErrors("now_passwd") || 
				result.hasFieldErrors("passwd")) {
			return "memberChangePassword";
		}
		
		//회원 번호를 얻기 위해서 세션에 저장된 회원 정보 반환
		MemberVO vo = (MemberVO)session.getAttribute("user");
		//현재 비밀번호와 변경할 비밀번호가 저장된 자바빈에 회원 번호 저장
		memberVO.setMem_num(vo.getMem_num());
		
		//회원 번호를 통해서 회원 정보를 DB로부터 읽어와서 입력한 현재 비밀번호와
		//DB에서 읽어온 현재 비밀번호가 일치하는지 여부 체크
		MemberVO member = memberService.selectMember(
				                  memberVO.getMem_num());
		if(!member.getMem_passwd().equals(memberVO.getNow_passwd())) {
			result.rejectValue("now_passwd","invalidPassword");
			return "memberChangePassword";
		}
		
		//비밀번호 수정 처리
		memberService.updatePassword(memberVO);
		
		return "redirect:/member/myPage.do";
	}
	
	//회원 탈퇴 폼
	@RequestMapping(value="/member/delete.do",
			                       method=RequestMethod.GET)
	public String formDelete() {
		return "memberDelete";
	}
	
	//회원 탈퇴 처리
	@RequestMapping(value="/member/delete.do",
			                       method=RequestMethod.POST)
	public String submitDelete(@Valid MemberVO memberVO,
			              BindingResult result,
			              HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<회원 탈퇴>> : " + memberVO);
		}
		
		//id,passwd 필드의 에러만 체크
		if(result.hasFieldErrors("id") || 
				result.hasFieldErrors("passwd")) {
			return "memberDelete";
		}
		
		//회원 번호를 얻기 위해 세션에 저장된 회원 정보 반환
		MemberVO vo = (MemberVO)session.getAttribute("user");
		memberVO.setMem_num(vo.getMem_num());
		
		//비밀번호 일치 여부 체크
		//회원 번호를 이용해서 회원 정보를 읽기
		MemberVO member = memberService.selectMember(
				                   memberVO.getMem_num());
		boolean check = false;
		if(member!=null && memberVO.getMem_id().equals(vo.getMem_id())) {
			//비밀번호 일치 여부 체크
			check = member.isCheckedPasswd(memberVO.getMem_passwd());
		}
		if(check) {
			//인증 성공, 회원정보 삭제
			memberService.deleteMember(memberVO.getMem_num());
			//로그아웃
			session.invalidate();
			
			return "redirect:/main/main.do";
		}else {
			//인증 실패
			result.reject("invalidIdOrPassword");
			
			return "memberDelete";
		}
	}
	
	//이미지 출력
	@RequestMapping("/member/photoView.do")
	public ModelAndView viewImage(HttpSession session) {
		
		MemberVO user = (MemberVO)session.getAttribute("user");
		MemberVO memberVO = memberService.selectMember(
				                           user.getMem_num());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("imageFile", memberVO.getMem_photo());
		mav.addObject("filename", memberVO.getMem_photoname());
		
		return mav;
	}
	
}













