package com.prj.api.sample.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.prj.api.sample.dao.Sample01DAO;
import com.prj.api.sample.vo.SampleVO;

@Repository
public class Sample01DAOImpl implements Sample01DAO{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Map<String, Object>> sample01(SampleVO vo) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Sample01DAO dao = sqlSession.getMapper(Sample01DAO.class);
		result = dao.sample01(vo);
		return result;
	}
}
