package web.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.DeptDao;
import web.dto.Dept;

@Service
public class DeptServiceImpl implements DeptService {

	private Logger logger = LoggerFactory.getLogger(DeptServiceImpl.class);

	@Autowired
	private DeptDao deptDao;
	
	@Override
	public List<Dept> getList() {

		logger.info("getList()");
		
		List<Dept> list = deptDao.selectAll();
		
		return list;
	}

	
	
}
