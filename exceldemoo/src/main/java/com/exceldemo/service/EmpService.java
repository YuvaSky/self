package com.exceldemo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.exceldemo.dao.EmpDao;
import com.exceldemo.entity.Emp;
import com.exceldemo.helper.ExcelHelper;
@Service
public class EmpService {

	@Autowired
	private EmpDao empDao;
	
	 public void save(MultipartFile file) {
		    try {
		      List<Emp> emps = ExcelHelper.excelToTutorials(file.getInputStream());
		      this.empDao.saveAll(emps);
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		  }

	public List<Emp> getAllEmps() {
		return this.empDao.findAll();
	}
}
