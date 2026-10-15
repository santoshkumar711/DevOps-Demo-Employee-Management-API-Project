package com.ninja.DevOps_Demo_Employee_Management_API_Project;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository erepo;
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@RequestMapping("/employee")
	public String test()
	{
		logger.info("this is test info");
		logger.warn("logger test warn");
		logger.error("logger test error");
		logger.debug("logger test debug");
		logger.trace("logger test trace");
		return "This is employee app where deploy in AWS ";
	}
	
	@PostMapping("/save")
	public String save(@RequestBody Employee employee) {
	    logger.info("this is save info");
	    logger.warn("logger save warn");
	    logger.error("logger save error");
	    logger.debug("logger save debug");
	    logger.trace("logger save trace");
	    erepo.save(employee);
	    return " Data save in tables";
	}
	
	@GetMapping("/all")
	public List<Employee> alldata()
	{
		logger.info("this is all info");
		logger.warn("logger all warn");
		logger.error("logger all error");
		logger.debug("logger all debug");
		logger.trace("logger all trace");
		return erepo.findAll();
	}
	
	@PutMapping("/update/{id}")
	public Employee update(@RequestBody Employee employee,@PathVariable int id)
	{
		logger.info("this is put/update/id info");
		logger.warn("logger put/update/id warn");
		logger.error("logger put/update/id error");
		logger.debug("logger put/update/id debug");
		logger.trace("logger put/update/id trace");
		
		Employee emp=erepo.findById(id).get();
		emp.setName(employee.getName());
		emp.setGender(employee.getGender());
		emp.setAge(employee.getAge());
		emp.setPhone(employee.getPhone());
		emp.setEmail(employee.getEmail());
		emp.setCity(employee.getCity());
		emp.setCountry(employee.getCountry());
		emp.setAddress(employee.getAddress());
		emp.setPostalcode(employee.getPostalcode());
		emp.setDepartment(employee.getDepartment());
		emp.setDesignation(employee.getDesignation());
		emp.setSalary(employee.getSalary());
		emp.setDateOfJoining(employee.getDateOfJoining());
		emp.setEmploymentType(employee.getEmploymentType());
		erepo.save(emp);
		return emp;
	}
	@PatchMapping("/partial/{id}")
	public Employee partial(@RequestBody Employee employee,@PathVariable int id)
	{
		logger.info("this is Patch/partial/id info");
		logger.warn("logger Patch/partial/id warn");
		logger.error("logger Patch/partial/id error");
		logger.debug("logger Patch/partial/id debug");
		logger.trace("logger Patch/partial/id trace");
		
		Employee emp=erepo.findById(id).get();
		emp.setCountry(employee.getCountry());
		erepo.save(emp);
		return emp;
	}
	@DeleteMapping("/del/{id}")
	public String delbyid(@PathVariable int id)
	{
		erepo.deleteById(id);
		return "data deleted";
	}
}
	
	
	
	
	
	
	

