package kr.spring.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.board.service.BoardService;
import kr.spring.board.vo.BoardVO;
import kr.spring.member.vo.MemberVO;
import kr.spring.util.PagingUtil;

@Controller
public class BoardController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	BoardService boardService;
	
	//자바빈(VO) 초기화
	@ModelAttribute
	public BoardVO initCommand() {
		return new BoardVO();
	}
	
	//게시판 목록
	@RequestMapping("/board/list.do")
	public ModelAndView process(
			@RequestParam(value="pageNum",defaultValue="1")
			int currentPage,
			@RequestParam(value="keyfield",defaultValue="")
			String keyfield,
			@RequestParam(value="keyword",defaultValue="")
			String keyword) {
		
		Map<String,Object> map = 
				new HashMap<String,Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		
		//총 글의 갯수 또는 검색된 글의 갯수
		int count = boardService.selectRowCount(map);
		
		if(log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}
		
		PagingUtil page = new PagingUtil(keyfield,keyword,
				              currentPage,count,10,10,"list.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<BoardVO> list = null;
		if(count > 0) {
			list = boardService.selectList(map);
			
			if(log.isDebugEnabled()) {
				log.debug("<<글 목록>> : " + list);
			}
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("boardList");
		mav.addObject("count",count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml", page.getPagingHtml());
		
		return mav;
	}
	
	//글 등록 폼
	@RequestMapping(value="/board/write.do",method=RequestMethod.GET)
	public String form() {
		return "boardWrite";
	}
	
	//글 등록 처리
	@RequestMapping(value="/board/write.do",method=RequestMethod.POST)
	public String submit(@Valid BoardVO boardVO,
			             BindingResult result,
			             HttpServletRequest request,
			             HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<게시판 글 저장>> : " + boardVO);
		}
		
		//유효성 체크 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return "boardWrite";
		}
		
		//회원 번호 셋팅
		MemberVO vo = (MemberVO)session.getAttribute("user");
		boardVO.setMem_num(vo.getMem_num());
		//글쓰기
		boardService.insertBoard(boardVO);
		
		return "redirect:/board/list.do";
	}
	//글 상세
	@RequestMapping("/board/detail.do")
	public ModelAndView process(@RequestParam int board_num) {
		if(log.isDebugEnabled()) {
			log.debug("<<글 상세>> : " + board_num);
		}
		//해당 글의 조회수 증가
		boardService.updateHit(board_num);
		
		BoardVO board = boardService.selectBoard(board_num);
		
		return new ModelAndView("boardView","board",board);
	}
	
	//이미지 출력
	@RequestMapping("/board/imageView.do")
	public ModelAndView viewImage(@RequestParam int board_num) {
		
		BoardVO board = boardService.selectBoard(board_num);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		                            //byte[]타입의 데이터
		mav.addObject("imageFile", board.getBoard_uploadfile());
		mav.addObject("filename", board.getBoard_filename());
		
		return mav;
	}
	
	//수정 폼 호출
	@RequestMapping(value="/board/update.do",
			        method=RequestMethod.GET)
	public String form(@RequestParam int board_num,
			           Model model) {
		
		BoardVO boardVO = boardService.selectBoard(board_num);
		
		model.addAttribute("boardVO", boardVO);
		
		return "boardModify";
	}
	
	//글 수정 처리
	@RequestMapping(value="/board/update.do",
			        method=RequestMethod.POST)
	public String submitUpdate(@Valid BoardVO boardVO,
			             BindingResult result,
			             HttpServletRequest request,
			             HttpSession session,
			             Model model) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<글 정보 수정>> : " + boardVO);
		}
		//유효성 체크 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return "boardModify";
		}
		
		//회원 번호 셋팅
		MemberVO user = (MemberVO)session.getAttribute("user");
		boardVO.setMem_num(user.getMem_num());

		//글 수정
		boardService.updateBoard(boardVO);
		
		//View에 표시할 메시지
		model.addAttribute("message", "글 수정 완료!!");
		model.addAttribute("url", 
				request.getContextPath()+"/board/list.do");
		
		//타일스 설정에 아래 뷰이름이 없으면 단독으로 JSP 호출
		return "common/result";
	}
	
	//글 삭제 처리
	@RequestMapping("/board/delete.do")
	public String submitDelete(@RequestParam int board_num,
			                   Model model,
			                   HttpServletRequest request) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<게시판 글 삭제>> : " + board_num);
		}
		
		//글 삭제
		boardService.deleteBoard(board_num);
		
		model.addAttribute("message", "글 삭제 완료!!");
		model.addAttribute("url", 
				request.getContextPath()+"/board/list.do");
		
		return "common/result";
	}
	
	
	
	
}







