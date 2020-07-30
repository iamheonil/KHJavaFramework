package com.kh.welcome.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoticeController {

	@RequestMapping("board/boardform.do")
	public String boardForm() {

		return "board/boardForm";

		// 추후에 수정할 메소드

	}

	@RequestMapping("/notice/noticeupload.do")
	public ModelAndView noticeUpload(@RequestParam List<MultipartFile> files, HttpSession session) {
		// 다중 파일 업로드이므로 여러개의 MultipartFile 을 담기위한 List 생성

		ModelAndView mav = new ModelAndView();

		// 파일 업로드를 위한 절대경로 반환
		String root = session.getServletContext().getRealPath("/");

		// MultipartFile 예외처리
		// 사용자가 게시글만 작성하고 파일업로드는 하지 않았을 때
		// 사용자가 첨부한 파일이 없어도 List<MultipleFile> 의 size() 가 1로 설정된다
		// 이때 첨부한 파일의 이름은 공백이다

		if (!(files.size() == 1 && files.get(0).getOriginalFilename().equals(""))) {

			for(MultipartFile mf : files) {
				String savePath = root + "resources/upload";
				System.out.println(savePath);
				
				// transferTo 메소드의 매개변수에 넣어 줄 빈 파일 객체를 저장할 경로 + 사용자가 등록한 파일 이름으로 생성
				File fileData = new File(savePath + "/" + mf.getOriginalFilename());
				
				try {
					mf.transferTo(fileData);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}

		return mav;
	}
}
