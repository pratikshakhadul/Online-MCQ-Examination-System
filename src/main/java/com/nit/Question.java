package com.nit;

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
@Table(name="que_value")
@Data
public class Question {
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="que_id")
private int id;
private String Questions;

@OneToMany
@ToString.Exclude
private List<Answers> answer;
}
