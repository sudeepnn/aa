package com.demo.department_service.model;



import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor

@Entity
public class employeepojo {
    @Id
    @Column(name = "deptid")
    private long deptId;
    @Column(name = "empname")
    private String empName;
}

