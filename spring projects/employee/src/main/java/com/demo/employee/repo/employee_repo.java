package com.demo.employee.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.employee.entity.employe;
@Repository
public interface employee_repo extends JpaRepository<employe,Long>{
    List<employe> findByDeptId(long id);
}
