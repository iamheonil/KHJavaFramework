package com.kh.welcome.board.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.welcome.board.model.service.NoticeService;
import com.kh.welcome.board.model.vo.Notice;

import common.util.Paging;

@Repository
public class NoticeDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private NoticeService noticeService = new NoticeService();
	
	//게시물 테이블에 게시물 추가
	public int insertNotice(Notice notice) {
		return sqlSession.insert("Notice.insertNotice", notice);
	}
	
	//파일 테이블에 파일정보 추가
	public int insertFile(Map<String,String> fileInfo) {
		return sqlSession.insert("Notice.insertFile",fileInfo);
	}
	
	//게시글 목록
	public List<Notice> selectNoticeList(Paging page){
		return sqlSession.selectList("Notice.selectNoticeList",page);
	}
	
	//전체 게시글 숫자 반환
	public int selectContentCnt() {
		return sqlSession.selectOne("Notice.selectContentCnt");
	}
	
	//게시글 상세
	public Notice selectNoticeDetail(int nIdx) {
		return sqlSession.selectOne("Notice.selectNoticeDetail",nIdx);
	}
	
	//게시글 파일 정보
	public List<Map<String,String>> selectFileWithNotice(int nIdx){
		return sqlSession.selectList("Notice.selectFileWithNotice",nIdx);
	}
	
	public int deleteFile(int fIdx) {
		return sqlSession.delete("Notice.deleteNoticeFile", fIdx);
	}
	
	public String selectSavePath(int fIdx) {
		return sqlSession.selectOne("Notice.selectSavePath", fIdx);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
