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
 * The Department REST service provides methods to access and manipulate departments data.
 * 
 * @author ab
 */
@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	/**
	 * /department/{id} - returns details of department by given ID
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/department/{id}")
	public Department find(@PathVariable("id") long id) {
		
		return departmentRepository.findOne(id);
	}
	
	/**
	 * /departments - return list of all departments
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/departments")
	public Iterable<Department> find() {
		
		return departmentRepository.findAll();
	}
	
	/**
	 * /department/{id}/employees - returns all employees associated with given
			department
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/department/{id}/employees")
	public Iterable<Employee> findEmployeesOfDepartment(@PathVariable long id) {
		
		// TODO Need to remove department information from the JSON response
		return employeeRepository.findByDepartmentId(id);
	}
	
	/**
	 * /department - creates new department from JSON string and returns its ID
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/department")
	public long create(@RequestBody Department department) {
		
		Department departmentEntity = departmentRepository.save(department);
		return departmentEntity.getId();
	}
	
	/**
	 * /department/{id} - updated information about department with given ID
	 */
	@RequestMapping(method = RequestMethod.PUT, path = "/department/{id}")
	public void update(@RequestBody Department department, @PathVariable long id) {
		
		boolean exists = departmentRepository.exists(id);
		if (exists) {
			department.setId(id);
			departmentRepository.save(department);
		}
	}
	
	/**
	 * /departments/{id} - deletes department with given ID
	 */
	@RequestMapping(method = RequestMethod.DELETE, path = "/departments/{id}")
	public void delete(@PathVariable long id) {
		
		int empsInDeptCount = departmentRepository.countEmployeesInDepartment(id);
		if (empsInDeptCount <= 0) {
			departmentRepository.delete(id);
		}
	}
}
