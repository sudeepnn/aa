package com.demo.department_service.service;

import java.util.List;

import com.demo.department_service.model.DepartmentPojo;

public interface department_service {
    List<DepartmentPojo> getAlldepartment();
    DepartmentPojo getDepartmentById(long id);
    DepartmentPojo creaDepartment(DepartmentPojo newdept);
    DepartmentPojo updatedDepartment(DepartmentPojo newdept);
    void deleteDepartment(long id);

}
