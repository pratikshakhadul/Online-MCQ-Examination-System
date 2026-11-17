package com.OneToMany;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="doctor")
@Data
public class Doctor 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="doct_id")
private Long doctorId;
private String doctorName;
private String specilization;
private Double salary;


@ManyToOne
@JoinColumn(name="dept_id")
@ToString.Exclude
private Department department;

}
