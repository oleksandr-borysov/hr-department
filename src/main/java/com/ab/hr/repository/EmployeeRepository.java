package com.ab.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ab.hr.model.Employee;

public interface EmployeeRepository extends JpaRepository <Employee, Long> {

	@Query("SELECT emp FROM Employee emp WHERE emp.department.id = ?1")
	List<Employee> findByDepartmentId(long id);
}
