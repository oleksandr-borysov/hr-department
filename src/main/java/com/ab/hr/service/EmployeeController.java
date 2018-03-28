package com.ab.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ab.hr.model.Department;
import com.ab.hr.model.Employee;
import com.ab.hr.repository.DepartmentRepository;
import com.ab.hr.repository.EmployeeRepository;

/**
 * The Employee REST service provides methods to access and manipulate employees data.
 * 
 * @author ab
 */
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	
	/**
	 * /employee/{id} - returns details of employee by given ID
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/employee/{id}")
	public Employee find(@PathVariable("id") long id) {
		
		return employeeRepository.findOne(id);
	}
	
	/**
	 * /employees - returns list of all employees
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/employees")
	public Iterable<Employee> find() {
		
		return employeeRepository.findAll();
	}
	
	/**
	 * /employee - creates new employee from JSON string and returns her ID
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/employee")
	public long create(@RequestBody Employee employee) {
		
		Employee employeeEntity = employeeRepository.save(employee);
		return employeeEntity.getId();
	}
	
	/**
	 * /employee/{id} - update information about employee with given ID
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/employee/{id}")
	public void update(@RequestBody Employee employee, @PathVariable("id") long id) {
		
		boolean exists = employeeRepository.exists(id);
		if (exists) {
			employee.setId(id);
			employeeRepository.save(employee);
		}
	}
	
	/**
	 * /employee/{e_id}/department/{d_id} - assign given employee to the given
			department
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/employee/{e_id}/department/{d_id}")
	public void assignToDepartment(@PathVariable("e_id") long employeeId, @PathVariable("d_id") long departmentId) {
		
		Employee employee = employeeRepository.findOne(employeeId);
		Department department = departmentRepository.findOne(departmentId);
		
		if ((employee != null) && (department != null)) {
			employee.setDepartment(department);
			employeeRepository.save(employee);
		}
	}
	
	/**
	 * /employees/{id} - deletes employee with given ID
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/employees/{id}")
	public void delete(@PathVariable("id") long id) {
		
		employeeRepository.delete(id);
	}
}
