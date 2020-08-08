package com.kh.welcome.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.kh.welcome.board.model.dao.NoticeDao;
import com.kh.welcome.board.model.vo.Notice;

import common.exception.FileException;
import common.util.FileUtil;
import common.util.Paging;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDao noticeDao;

	// @Transactional
	
	// @Transactional - 스프링에게 트랜잭션 관리를 위임하는 어노테이션
	// Method 또는 Class 작성할 수 있다
	// Class 에 지정할 경우 해당 클래스의 모든 메소드가 스프링에게 트랜잭션 관리를 위임한다
	public int insertNotice(Notice notice, List<MultipartFile> files, String root) {

		int result = noticeDao.insertNotice(notice);
		
		
		if (!(files.size() == 1 && files.get(0).getOriginalFilename().equals(""))) {

			// int errorNumber = 10/0;
			
			// 파일업로드를 위해 FileUtil.fileUpload() 호출
			List<Map<String, String>> filedata = null;
			try {
				filedata = new FileUtil().fileUpload(files, root);
			} catch (FileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			for (Map<String, String> f : filedata) {
				noticeDao.insertFile(f);
			}
		}

		return result;
	}

	public Map<String, Object> selectNoticeList(
			// 현재 페이지
			int currentPage
			// 페이지당 노출할 게시글 수
			, int cntPerPage) {

		Map<String, Object> commandMap = new HashMap<String, Object>();
		// 페이징 처리를 위한 객체 생성
		Paging p = new Paging(noticeDao.selectContentCnt(), currentPage, cntPerPage);

		// 현재 페이지에 필요한 게시물 목록
		List<Notice> nlist = noticeDao.selectNoticeList(p);
		commandMap.put("nlist", nlist);
		commandMap.put("paging", p);
		return commandMap;
	}

	// 게시물 상세
	public Map<String, Object> selectNoticeDetail(int nIdx) {
		Map<String, Object> commandMap = new HashMap<String, Object>();

		Notice notice = noticeDao.selectNoticeDetail(nIdx);
		List<Map<String, String>> flist = noticeDao.selectFileWithNotice(nIdx);
		commandMap.put("notice", notice);
		commandMap.put("flist", flist);
		return commandMap;
	}

	public int deleteFile(int fIdx) {

		int res = 0;

		noticeDao.deleteFile(fIdx);

		return res;
	}

	public String selectSavePath(int fIdx) {

		String savePath = noticeDao.selectSavePath(fIdx);

		return savePath;
	}

}
