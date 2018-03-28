package com.ab.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ab.hr.model.Department;

public interface DepartmentRepository extends JpaRepository <Department, Long> {
    
	@Query("SELECT COUNT(emp) FROM Employee emp WHERE emp.department.id = ?1")
    int countEmployeesInDepartment(long departmentId);
}
