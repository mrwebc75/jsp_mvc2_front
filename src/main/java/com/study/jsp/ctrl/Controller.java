package com.study.jsp.ctrl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
  Map<String, String> execute(HttpServletRequest req, HttpServletResponse res);
  
  /*
   * 서브컨트롤러에서
   * 
      Map<String, String> viewInfo = new HashMap<String, String>();
      viewInfo.put("name", "redirect");
      viewInfo.put("path", "/board/list.do");
      
      Map<String, String> viewInfo = new HashMap<String, String>();
      viewInfo.put("name", "forward");
      viewInfo.put("path", "/views/board/list.jsp");      

   */
}
