package com.nit;

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
@Table(name="ans_value")
@Data
public class Answers {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ans_id")
private int id;
private String answers;

@ManyToOne
@JoinColumn(name="que_id")
@ToString.Exclude
private Question question;
}
