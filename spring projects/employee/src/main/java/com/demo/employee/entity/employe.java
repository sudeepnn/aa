package com.demo.employee.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor

@Entity
public class employe {
    @Id
    @Column(name = "deptid")
    private long deptId;
    @Column(name = "empname")
    private String empName;
}
