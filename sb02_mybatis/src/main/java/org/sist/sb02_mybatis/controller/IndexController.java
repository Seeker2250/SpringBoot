package org.sist.sb02_mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

@Controller
@Log
public class IndexController {
/*
	@GetMapping("/index")
	@ResponseBody//이러면 순수 String data만 지나감
	public String index() {
		return "hello world index에 찾아왔네";
	}
	*/
	@GetMapping("/index")
	public void index() {
    }
}