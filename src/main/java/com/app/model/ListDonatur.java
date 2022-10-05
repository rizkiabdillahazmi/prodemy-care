package com.app.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "list_donatur")
public class ListDonatur {
	@Id
	@Column(name = "list_id")
	@SequenceGenerator(name="pk_donatur",sequenceName="seq_dtr", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_donatur")
	private Long listId;
		
	@Column(name = "donatur_name", updatable = false, nullable = false)
	private String nama;
	
	@Column(name = "donation_email", updatable = false, nullable = false)
	private String email;
	
	@Column(name = "donation_phone", updatable = false, nullable = false)
	private String phone;
	
	@Column(name = "total_donation", updatable = false, nullable = false)
	private String total;
	
	@Column(name = "anonim", updatable = false, nullable = false)
	private int anonim;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
	
	@UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
