package com.study.jsp.ctrl.board;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.ctrl.Controller;
import com.study.jsp.ioc.Factory;
import com.study.jsp.srv.BoardService;

public class BoardListCtrl implements Controller {

  @Override
  public Map<String, String> execute(HttpServletRequest req, HttpServletResponse res) {
    Map<String, String> viewInfo = new HashMap<String, String>();
    viewInfo.put("name", "forward");
    viewInfo.put("path", "/views/board/list.jsp");

    HttpSession session = req.getSession();

    // list.jsp는 로그인한 사용자만 접근 가능하도록 설정
    if (session.getAttribute("userid") == null) {
      viewInfo.put("path", "/views/user/login.jsp");
    }

    BoardService boardSrv = Factory.INSTANCE.getBoardSrv();
    req.setAttribute("list", boardSrv.findAll());

    return viewInfo;
  }

}
