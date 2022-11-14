package com.myspring.pro29.ex02;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResController {
	@RequestMapping(value = "/res1")
	@ResponseBody //메서드 호출시 데이터를 전송하도록 설정함
	public Map<String, Object> res1() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "hong");
		map.put("name", "홍킬동");
		return map;
	}
	
	@RequestMapping(value = "/res2")
		public ModelAndView res2() {
		return new ModelAndView("home");
	}
}
