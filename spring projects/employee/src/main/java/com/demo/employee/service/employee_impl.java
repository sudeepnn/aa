package com.demo.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.employee.entity.employe;
import com.demo.employee.repo.employee_repo;

@Service
public class employee_impl implements employee_Service {

    @Autowired
    employee_repo repo;
    
    @Override
    public List<employe> getAllemployee() {
        return repo.findAll();
    }

    @Override
    public employe getemployeeById(long id) {
        Optional<employe> emp=repo.findById(id);
        if(emp.isPresent()){
            return emp.get();
        
        }
        return null;

    }

    @Override
    public employe createmployee(employe emp) {
        try {
            return repo.save(emp);
        } catch (Exception e) {
            // Log the exception (consider using a logger)
            System.out.println("Error occurred while saving employee: " + e.getMessage());
            throw e; // Re-throw or handle accordingly
        }
       
    }

    @Override
    public employe updatedemployee(employe emp) {
       return repo.save(emp);
       
    }

    @Override
    public void deleteemployee(long id) {
        repo.deleteById(id);
    }

    public List<employe> getallempl(long deptid){
        return repo.findByDeptId(deptid);
    }
}
