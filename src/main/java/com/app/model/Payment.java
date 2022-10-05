package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "payment")
public class Payment {
	@Id
	@Column(name = "payment_id", updatable = false, nullable = false)
	@SequenceGenerator(name="pk_payment", sequenceName="seq_payment", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_payment")
	private int id;
	
	@Column(name = "payment_name", updatable = false, nullable = false)
	private String name;
	
	@Column(name = "rekening", updatable = false, nullable = false)
	private String rekening;

}