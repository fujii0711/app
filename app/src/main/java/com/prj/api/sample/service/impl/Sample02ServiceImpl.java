package com.prj.api.sample.service.impl;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prj.api.sample.dao.impl.Sample02DAOImpl;
import com.prj.api.sample.service.Sample02Service;
import com.prj.api.sample.vo.SampleVO;

@Service
public class Sample02ServiceImpl implements Sample02Service{
	
	@Autowired
	private Sample02DAOImpl daoImpl;
	
	@Override
	public Map<String, String> sample02(SampleVO vo) {
		Map<String, String> result = daoImpl.sample02(vo);
		return result;
	}
}
