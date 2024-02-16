package com.study.jsp.ctrl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.ioc.Factory;
import com.study.jsp.srv.BoardService;

public class BoardDeleteCtrl implements Controller {

  @Override
  public Map<String, String> execute(HttpServletRequest req, HttpServletResponse res) {
    Map<String, String> viewInfo = new HashMap<String, String>();
    viewInfo.put("name", "redirect");
    viewInfo.put("path", "/board/list.do");

    // seq 처리 로직
    int seq = 0;

    String seq_ = req.getParameter("seq");
    if (!seq_.isEmpty()) {
      seq = Integer.valueOf(seq_);
    }

    BoardService boardSrv = Factory.INSTANCE.getBoardSrv();
    boardSrv.delete(seq);

    return viewInfo;
  }

}
