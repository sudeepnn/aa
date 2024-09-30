package com.demo.department_service.model;


import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "department")
public class DepartmentPojo {
    
    @Id
    @Column(name = "dept_id")
    private long deptId;
    @Column(name = "dept_name")
    private String deptName;
    @Transient
    private List<employeepojo> allemplyee;
}



