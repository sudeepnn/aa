package com.demo.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.employee.entity.employe;
import com.demo.employee.service.employee_Service;
import com.demo.employee.service.employee_impl;

@RestController
public class employeeController {
    @Autowired
    employee_impl service;

   private static final Logger log=LoggerFactory.getLogger(employe.class);

    @GetMapping("employees")
    public List<employe> getallemplye(){
        log.info("in getall employee");
        return service.getAllemployee();
    }

    @GetMapping("employees/{eid}")
    public employe getaemployee(@PathVariable( "eid") long id){
        log.info("in geta employee");
        return service.getemployeeById(id);
    }
    @GetMapping("employees/dept/{eid}")
    public List<employe> getaemployeebydeptid(@PathVariable( "eid") long id){
        log.info("in deptget employee");
        return service.getallempl(id);
    }

    @PostMapping("employees")
    public employe addemploye(@RequestBody employe emp){
        log.info("in add employee");
        return service.createmployee(emp);
    }

    @PutMapping("employees")
    public employe updateemploye(@RequestBody employe emp){
        log.info("in update employee");
        return service.updatedemployee(emp);
    }

    @DeleteMapping("employees/{eid}")
    public void deleteemployee(@PathVariable( "eid") long id){
        log.info("in delete employee");
        service.deleteemployee(id);
    }
}
