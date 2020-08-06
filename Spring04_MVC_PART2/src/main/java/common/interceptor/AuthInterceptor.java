package common.interceptor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

// HandlerInterceptor 를 구현해 인터페이스로 해당 클래스를 활용한다
public class AuthInterceptor implements HandlerInterceptor {

	// Interceptor

	// dispatcherServlet 이 Controller 의 메소드를 호출할 때
	// 중간에서 요청을 가로채 필요한 선 작업들을 처리할 수 있다
	// filter 가 비슷한 역할을 한다
	// - Servlet Container 가 Servlet 을 호출하기 전에 요청을 가로채는 역할

	// Servlet Container > filter > dispatcher-Servlet > interCeptor > controller

	@Override
	// preHandle - 컨트롤러로 요청이 가기전 실행되는 메소드
	// return true - 컨트롤러의 메소드가 실행 됨
	// false - 실행 안됨
	// object handler - preHandle 을 수행하고 수행될 컨트롤러 메소드에 대한 정보
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {

		if (request.getRequestURI().contains("notice/") && request.getSession().getAttribute("logInInfo") == null) {

			request.setAttribute("alertMsg", "비회원은 접근할 권한이 없습니다");
			request.setAttribute("url", request.getContextPath()+"/member/login.do");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			rd.forward(request, response);
			
			return false;
		}
	
		return true;

	}

}
