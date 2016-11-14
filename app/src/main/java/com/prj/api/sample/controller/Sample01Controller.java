package com.prj.api.sample.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.prj.api.sample.service.Sample01Service;
import com.prj.api.sample.vo.SampleVO;

@Controller
public class Sample01Controller {
	
	@Autowired
	private Sample01Service sample01Service;
	
	@RequestMapping(value = "/sample01.do", method = RequestMethod.GET)
	public String sample01() {
		return "sample/sample01";
	}
	
	/**
	 * List 데이터 타입
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/sampleList.do", method = RequestMethod.GET)
	public Map<String ,String> sample01(SampleVO vo) throws Exception{		
		Map <String, String> map = new HashMap<String, String>();	
		String Json = sample01Service.sample01(vo);					
		if (Json != null) {
			map.put("msg", "success");
			map.put("Json",Json);
		} else {
			map.put("msg", "fail");
		}		
		return map;
	}
}
