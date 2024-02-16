package com.study.jsp.ctrl;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {

    // 1단계 - URI 분석
    String requestURI = req.getRequestURI();// 컨텍스트부터 .do 확장자까지
    String contextPath = req.getContextPath();

    String path = "";

    if (contextPath.compareTo("") == 0) {
      path = requestURI;
    } else {// 별도의 컨텍스트 패스가 있는경우
      path = requestURI.substring(contextPath.length());
    }

    // 2단계 - URI에 매칭되는 서브컨트롤러 추출
    HanderMapping handlerMapping = new HanderMapping();
    Controller ctrl = handlerMapping.getController(path);

    // 3단계 - 서브컨트롤러 실행 및 viewName 추출
    Map<String, String> viewInfo = ctrl.execute(req, res);

    // 4단계 - 프론트엔드 단으로 데이터 포워딩 또는 리다이렉트
    if (viewInfo.get("name").equals("forward")) {// forward인 경우
      RequestDispatcher dispatcher = req.getRequestDispatcher(viewInfo.get("path"));
      dispatcher.forward(req, res);
      return;
    }

    res.sendRedirect(req.getContextPath() + viewInfo.get("path"));
  }
}
