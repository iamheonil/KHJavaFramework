package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {

	// SQLSession 객체를 생성하는 팩토리 객체
	private static SqlSessionFactory sqlSessionFactory;

	static {

		// MyBatis Configuration XML 파일의 경로 지정
		String res = "mybatis/mybatis-config.xml";

		try {
			Reader reader = Resources.getResourceAsReader(res);
			
			// 싱글톤 유지 코드
			if(sqlSessionFactory == null) {
				
				// 입력 스트림으로 읽은 설정파일을 이용한 SqlSessionFactory 객체를 생성
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
						
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	// 다른곳에서 함부로 생성하지 못하게 private 생성자를 만들어 준다.
	private MyBatisConnectionFactory() {}
	
	// 싱글톤 객체 반환 메소드
	public static SqlSessionFactory getsqlSessionFactory() {
		return sqlSessionFactory;
	}

}
