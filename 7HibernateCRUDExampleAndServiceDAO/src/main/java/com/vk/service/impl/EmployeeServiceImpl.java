package com.vk.service.impl;

import com.vk.dao.impl.EmployeeDAOImpl;
import com.vk.entities.Employee;
import com.vk.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public void createEmployee(Employee employee) {
		new EmployeeDAOImpl().addEmployee(employee);

	}

	@Override
	public Employee getEmployeebyId(int employeeId) {
		// TODO Auto-generated method stub
		return new EmployeeDAOImpl().fetchEmployeebyId(employeeId);
	}

	@Override
	public void updateEmployeeById(int employeeId, Double newSal) {
		new EmployeeDAOImpl().updateEmployeeById(employeeId, newSal);

	}

	@Override
	public void deleteEmployeeById(Integer employeeId) {
		new EmployeeDAOImpl().deleteEmployeeById(employeeId);

	}

}
