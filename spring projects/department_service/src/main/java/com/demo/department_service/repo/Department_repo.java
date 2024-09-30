package com.demo.department_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.department_service.dao.DepartmentEntity;

public interface Department_repo extends JpaRepository<DepartmentEntity,Long> {

}
