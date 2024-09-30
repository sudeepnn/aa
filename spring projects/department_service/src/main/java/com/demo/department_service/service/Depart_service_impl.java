package com.demo.department_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.department_service.dao.DepartmentEntity;
import com.demo.department_service.model.DepartmentPojo;
import com.demo.department_service.repo.Department_repo;

@Service
public class Depart_service_impl implements department_service{

    @Autowired
    Department_repo repo;
    @Override
    public List<DepartmentPojo> getAlldepartment() {
        List<DepartmentEntity> allDepartment=repo.findAll();
        List<DepartmentPojo> alldeptPojo=new ArrayList<>();
        allDepartment.stream().forEach(dep->{
            DepartmentPojo pojo=new DepartmentPojo();
            BeanUtils.copyProperties(dep, pojo);
            alldeptPojo.add(pojo);
        });
        return alldeptPojo;
    }

    @Override
    public DepartmentPojo getDepartmentById(long id) {
       Optional<DepartmentEntity> entity=repo.findById(id);
       if(entity.isPresent()){
        DepartmentPojo pojo=new DepartmentPojo();
        BeanUtils.copyProperties(entity.get(), pojo);
        return pojo;
       }
       return null;
    }

    @Override
    public DepartmentPojo creaDepartment(DepartmentPojo newdept) {
        DepartmentEntity departmentEntity=new DepartmentEntity();
        BeanUtils.copyProperties(newdept, departmentEntity);
        repo.saveAndFlush(departmentEntity);
        return newdept;
    }

    @Override
    public DepartmentPojo updatedDepartment(DepartmentPojo newdept) {
        DepartmentEntity entity=new DepartmentEntity();
        BeanUtils.copyProperties(newdept, entity);
        repo.save(entity);
        return newdept;
    }

    @Override
    public void deleteDepartment(long id) {
        repo.deleteById(id);
    }

}
