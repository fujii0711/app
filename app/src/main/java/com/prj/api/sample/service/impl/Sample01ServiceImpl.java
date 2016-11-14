package com.prj.api.sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.prj.api.sample.dao.impl.Sample01DAOImpl;
import com.prj.api.sample.service.Sample01Service;
import com.prj.api.sample.vo.SampleVO;

@Service
public class Sample01ServiceImpl implements Sample01Service{
	
	@Autowired
	private Sample01DAOImpl daoImpl;
	
	@Override
	public String sample01(SampleVO vo) {
		Gson gson = new Gson(); 
		String rtnString = gson.toJson(daoImpl.sample01(vo));
		return rtnString;
	}
}
