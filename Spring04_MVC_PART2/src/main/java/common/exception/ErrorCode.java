package common.exception;


// 상수를 효율적으로 다루기 위해서 자바 1.5 부터 추가
// 코드 (에러코드, 상태코드, 회원등급 코드 등) 를 다루기 위해 사용
// 코드와 연관된 데이터들을 일괄적으로 다룰 수 있다

public enum ErrorCode {

	M_ERROR_01("메일 전송 중 에러가 발생하였스빈다", "join.do"),
	
	F_ERROR_01("파일 등록 중 에러가 발생하였씁니다", "noticelist.do");
	
	private final String MESSAGE;
	private final String URL;
	
	ErrorCode(String msg, String url) {
		this.MESSAGE = msg;
		this.URL = url;
	}
	
	public String getMESSAGE() {
		return MESSAGE;
	}
	
	public String getURL() {
		return URL;
	}
	
}
