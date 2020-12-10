package kr.spring.game.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.board.vo.BoardVO;
import kr.spring.game.service.GameService;
import kr.spring.game.vo.GameVO;
import kr.spring.member.vo.MemberVO;
import kr.spring.util.PagingUtil;

@Controller
public class GameController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private GameService gameService;
	
	//자바빈(VO) 초기화
	@ModelAttribute
	public GameVO initCommand() {
		return new GameVO();
	}
	
	@RequestMapping("/game/gameList.do")
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
		//int count = boardService.selectRowCount(map);
		
		if(log.isDebugEnabled()) {
		//	log.debug("<<count>> : " + count);
		}
		
		//PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,10,10,"list.do");
		//map.put("start", page.getStartCount());
		//map.put("end", page.getEndCount());
		
		List<BoardVO> list = null;
		//if(count > 0) {
		//	list = boardService.selectList(map);
			
		//	if(log.isDebugEnabled()) {
		//		log.debug("<<글 목록>> : " + list);
		//	}
		//}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("gameList");
		//mav.addObject("count",count);
		//mav.addObject("list", list);
		//mav.addObject("pagingHtml", page.getPagingHtml());
		
		return mav;
	}
	
	//회원가입 폼 
	@RequestMapping(value="/game/write.do",method=RequestMethod.GET)
	public String form() {
		return "gameWrite";
	}
	
	@RequestMapping(value="/game/write.do",method=RequestMethod.POST)
	public String submit(@Valid GameVO gameVO,
			             BindingResult result,
			             HttpServletRequest request,
			             HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<게시판 글 저장>> : " + gameVO);
		}
		
		//유효성 체크 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return "gameWrite";
		}
		
		//글쓰기
		gameService.insertGame(gameVO);
		
		return "redirect:/board/list.do";
	}
	
}




