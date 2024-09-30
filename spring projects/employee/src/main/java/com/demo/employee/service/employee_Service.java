package com.demo.employee.service;

import java.util.List;

import com.demo.employee.entity.employe;

public interface employee_Service {
    List<employe> getAllemployee();
    employe getemployeeById(long id);
    employe createmployee(employe emp);
    employe updatedemployee(employe emp);
    void deleteemployee(long id);
    
}
