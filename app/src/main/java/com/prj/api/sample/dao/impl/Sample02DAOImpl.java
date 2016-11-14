package com.prj.api.sample.dao.impl;

import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.prj.api.sample.dao.Sample02DAO;
import com.prj.api.sample.vo.SampleVO;

@Repository
public class Sample02DAOImpl implements Sample02DAO{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public Map<String, String> sample02(SampleVO vo) {
		Sample02DAO dao = sqlSession.getMapper(Sample02DAO.class);
		Map<String, String> result = dao.sample02(vo);
		return result;
	}	
}
