package com.prj.api.sample.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prj.api.sample.service.Sample02Service;
import com.prj.api.sample.vo.SampleVO;

@Controller
public class Sample02Controller {
	
	@Autowired
	private Sample02Service sample02Service;
	
	@RequestMapping(value = "/sample02.do", method = RequestMethod.GET)
	public String sample02() {
		return "sample/sample02";
	}
	
	/**
	 * Map 데이터 타입
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/sampleMap.do", method = RequestMethod.GET)
	public Map<String ,String> sample02(SampleVO vo) throws Exception{		
		Map <String, String> rtnView = sample02Service.sample02(vo);
		Map <String, String> map = new HashMap<String, String>();
		if (rtnView != null) {
			map.put("msg", "success");
			map.put("data01",rtnView.get("DATA01"));
			map.put("data02",rtnView.get("DATA02"));
			map.put("data03",rtnView.get("DATA03"));
			map.put("data04",rtnView.get("DATA04"));
			map.put("data05",rtnView.get("DATA05"));
			map.put("data06",rtnView.get("DATA06"));
		} else {
			map.put("msg", "fail");
		}
		return map;	
	}
}
