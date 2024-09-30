package com.demo.department_service.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "department")
public class DepartmentEntity {
    @Id
    @Column(name = "dept_id")
    private long deptId;
    @Column(name = "dept_name")
    private String deptName;
}
