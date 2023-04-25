package com.codeclan.departmentservice;

import com.codeclan.departmentservice.models.Department;
import com.codeclan.departmentservice.models.Employee;
import com.codeclan.departmentservice.models.Project;
import com.codeclan.departmentservice.repositories.DepartmentRepository;
import com.codeclan.departmentservice.repositories.EmployeeRepository;
import com.codeclan.departmentservice.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DepartmentserviceApplicationTests {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	ProjectRepository projectRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canCreateEmployee(){
		Department department = new Department("Business Law");
		departmentRepository.save(department);
		Employee employee = new Employee("James", "Burns", 12345, department);
		employeeRepository.save(employee);
	}

	@Test
	public void canAddEmployeesToAProject(){
		Department department = new Department("Litigation");
		departmentRepository.save(department);
		Employee employee = new Employee("Laura", "Palmer", 45678, department);
		Employee employee2 = new Employee("Dale", "Cooper", 98765, department);
		employeeRepository.save(employee);
		employeeRepository.save(employee2);
		Project project = new Project("Risk Assessment", 5);
		project.addEmployeeToProject(employee);
		project.addEmployeeToProject(employee2);
		projectRepository.save(project);
	}
	@Test
	public void canAddProjectsToAnEmployee(){
		Department department = new Department("Private Client");
		departmentRepository.save(department);
		Project project = new Project("AML Check", 1);
		Project project2 = new Project("Training", 1);
		projectRepository.save(project);
		projectRepository.save(project2);
		Employee employee = new Employee("Gordon", "Cole", 11111, department);
		employee.addProjectToEmployee(project);
		employee.addProjectToEmployee(project2);
		employeeRepository.save(employee);
	}

}
