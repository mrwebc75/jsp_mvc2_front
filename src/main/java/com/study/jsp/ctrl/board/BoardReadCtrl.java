package com.study.jsp.ctrl.board;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.ctrl.Controller;
import com.study.jsp.ioc.Factory;
import com.study.jsp.srv.BoardService;

public class BoardReadCtrl implements Controller {

  @Override
  public Map<String, String> execute(HttpServletRequest req, HttpServletResponse res) {

    Map<String, String> viewInfo = new HashMap<String, String>();
    viewInfo.put("name", "forward");
    viewInfo.put("path", "/views/board/read.jsp");

    int seq = 0;

    String seq_ = req.getParameter("seq");
    if (!seq_.isEmpty()) {
      seq = Integer.valueOf(seq_);
    }

    BoardService boardSrv = Factory.INSTANCE.getBoardSrv();
    req.setAttribute("dto", boardSrv.getOne(seq));

    return viewInfo;
  }

}
