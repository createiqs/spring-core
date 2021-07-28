package com.createiq.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.createiq.spring.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private JdbcTemplate template;

	public void add(Employee employee) {
		template.update("INSERT INTO EMPLOYEE VALUES(?,?,?)", employee.getEid(), employee.getEname(),
				employee.getEsal());
	}

	public void update(Employee employee) {
		template.update("UPDATE EMPLOYEE SET ENAME = ?, ESAL = ? WHERE EID = ?", employee.getEname(),
				employee.getEsal(), employee.getEid());
	}

	public void delete(Integer eid) {
		template.update("DELETE FROM EMPLOYEE WHERE EID = ?", eid);
	}

}
