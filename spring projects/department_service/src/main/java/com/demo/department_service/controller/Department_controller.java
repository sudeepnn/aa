package com.demo.department_service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import com.demo.department_service.model.DepartmentPojo;
import com.demo.department_service.model.employeepojo;
import com.demo.department_service.service.Depart_service_impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class Department_controller {
    @Autowired
    Depart_service_impl service;

    public static final Logger log=LoggerFactory.getLogger(Department_controller.class);

    @GetMapping("/departments")
    public List<DepartmentPojo> getalldepartment() {
        log.info("in getallDepartments");
        return service.getAlldepartment();
    }

    @GetMapping("/departments/{did}")
    @CircuitBreaker(name = "ciremp",fallbackMethod = "empFallBack")
    public DepartmentPojo getAdepartment(@PathVariable("did") long deptid){
        log.info("in get a department");
        DepartmentPojo deptpojo= service.getDepartmentById(deptid);
        RestClient restClient=RestClient.create();
       List<employeepojo> allemp= restClient.get().uri("http://localhost:8082/employees/dept/"+deptid).retrieve().body(List.class);
       deptpojo.setAllemplyee(allemp);
       return deptpojo;
    }
public DepartmentPojo empFallBack(Exception e){
    return new DepartmentPojo(0,"fallback",null);
}

    @PostMapping("/departments")
    public DepartmentPojo adddepat(@RequestBody DepartmentPojo newdept){
        log.info("in add department");

        return service.creaDepartment(newdept);
    }

    @PutMapping("/departments")
    public DepartmentPojo updatedepat(@RequestBody DepartmentPojo newdept){
        log.info("in update department");

        return service.updatedDepartment(newdept);
    }

    @DeleteMapping("/departments/{did}")
    public void deletedepat(@PathVariable("did") long id){
        log.info("in delete department");

         service.deleteDepartment(id);
    }
    
}
