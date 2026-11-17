package com.OneToMany;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;
@Entity
@Table(name="department")
@Data
public class Department 
{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="dept_id")
private Long departmentId;
private String departmentName;
private String location;
private int establishedYear;


@OneToMany(mappedBy = "department")
@ToString.Exclude
private List<Doctor> doctors = new ArrayList<>();
}
