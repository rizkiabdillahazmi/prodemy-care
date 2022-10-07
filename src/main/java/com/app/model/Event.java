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
@Table(name = "event")
public class Event {
	@Id
	@Column(name = "event_id", updatable = false, nullable = false)
	@SequenceGenerator(name="pk_event", sequenceName="seq_event", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_event")
	private int id;
	
	@Column(name = "event_name", nullable = false)
	private String name;

}