package com.study.jsp.ctrl;

import java.util.HashMap;
import java.util.Map;

import com.study.jsp.ctrl.board.BoardEditCtrl;
import com.study.jsp.ctrl.board.BoardListCtrl;
import com.study.jsp.ctrl.board.BoardReadCtrl;
import com.study.jsp.ctrl.board.BoardWriteCtrl;
import com.study.jsp.ctrl.user.UserLoginCtrl;
import com.study.jsp.ctrl.user.UserLogoutCtrl;

public class HanderMapping {

  // 요청url과 서브컨트롤러 객체를 서로 연결시켜주는 역할
  Map<String, Controller> urlMap = null;

  // 생성자에서 맵 초기화
  public HanderMapping() {
    urlMap = new HashMap<String, Controller>();

    urlMap.put("/board/write.do", new BoardWriteCtrl());
    urlMap.put("/board/list.do", new BoardListCtrl());
    urlMap.put("/board/read.do", new BoardReadCtrl());
    urlMap.put("/board/edit.do", new BoardEditCtrl());
    urlMap.put("/board/delete.do", new BoardDeleteCtrl());

    urlMap.put("/user/login.do", new UserLoginCtrl());
    urlMap.put("/user/logout.do", new UserLogoutCtrl());
  }

  // 요청경로에 해당하는 서브컨트롤러 객체 리턴
  public Controller getController(String path) {
    return urlMap.get(path);
  }

}
