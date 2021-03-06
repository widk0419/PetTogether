package com.pet.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pet.command.StarBoardReplyVO;
import com.pet.command.StarBoardVO;
import com.pet.common.util.Criteria;
import com.pet.freeboard.service.FreeBoardService;
import com.pet.starboard.service.StarBoardService;

@Controller
@RequestMapping("/starBoard")
public class StarBoardController {
	
	@Autowired
	@Qualifier("starBoardService")
	private StarBoardService starBoardService;
	
	
	@RequestMapping("/freeList")
	public String freeList(Model model) {
		
		ArrayList<StarBoardVO> list = starBoardService.getList();
		System.out.println(list.toString());
		
		model.addAttribute("list",list );
		return "freeBoard/freeList";
	}
	
	@RequestMapping("/freeDetail")
	public String freeDetail(@RequestParam("bno") int bno, Model model) {
		
		StarBoardVO vo = starBoardService.getBoardDetail(bno);
		
		model.addAttribute("vo" , vo);
		
		
		return "freeBoard/freeDetail";
	}
	
	// 게시판에 댓글 달기 ===============================================================
	@ResponseBody
	@PostMapping("starBoardReplyInsert")
	public int starBoardReplyInsert(@RequestBody StarBoardReplyVO vo) {
		int result = starBoardService.starReplyInsert(vo);
		return result; 
	}
	
	
	// 게시판 댓글 불러오기 ======================================
	@ResponseBody
	@GetMapping("getStarReply/{bno}/{pageNum}")
	public ArrayList<StarBoardReplyVO> getStarReply(@PathVariable("bno") int bno,
													@PathVariable("pageNum") int pageNum) {
		
		Criteria cri = new Criteria(pageNum , 8);
		ArrayList<StarBoardReplyVO> list = starBoardService.getStarReply(bno , cri);
		System.out.println(list.toString());
		System.out.println(pageNum);
		
		
		
		return list;
	}
	
	
	@ResponseBody
	@PostMapping("/starReplyUpdate")
	public int starReplyUpdate(@RequestBody StarBoardReplyVO vo) {
		
		System.out.println(vo.toString());
		int pwResult = starBoardService.pwCheck(vo);
		System.out.println(pwResult);
		if(pwResult == 1) {
			int updateResult = starBoardService.starReplyUpdate(vo);
			if(updateResult == 1) {
				return 1;
			}else {
				return 0;
			}
		}else {
			return 2;
		}
		
	}
	
	
	@ResponseBody
	@PostMapping("/starReplyDelete")
	public int starReplyDelete(@RequestBody StarBoardReplyVO vo) {
		
		System.out.println(vo.toString());
		
		int pwResult = starBoardService.pwCheck(vo);
		if(pwResult == 1) {
			int deleteResult = starBoardService.starReplyDelete(vo);
			if(deleteResult == 1) {
				return 1;
			}else { 
				return 0;
			}
		}else {
			
			return 2;
		}
		
	}
		
	
	
	
	
	
	

}
