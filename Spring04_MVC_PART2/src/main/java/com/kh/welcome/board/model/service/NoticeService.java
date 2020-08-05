package com.kh.welcome.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.kh.welcome.board.model.vo.Notice;

public interface NoticeService {

	public int insertNotice(Notice notice, List<MultipartFile> files, String root);

	public Map<String, Object> selectNoticeList(
			// 현재 페이지
			int currentPage
			// 페이지당 노출할 게시글 수
			, int cntPerPage);

	// 게시물 상세
	public Map<String, Object> selectNoticeDetail(int nIdx);

	public int deleteFile(int fIdx);

	public String selectSavePath(int fIdx);

}
