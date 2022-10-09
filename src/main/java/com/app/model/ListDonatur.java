package com.app.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	private Long id;
	
//	@OneToOne
//    @JoinColumn(name = "donation_id")
//	private Donation donation;
	@Column(name = "donation_id", nullable = false)
	private Long donationId;
	
	@Column(name = "donatur_name", nullable = false)
	private String nama;
	
	@Column(name = "donation_nominal", nullable = false)
	private Long nominal;
	
	@Column(name = "payment_id", nullable = false)
    private int rekening;
	
	@Column(name = "donation_phone", nullable = false)
	private String phone;
	
	@Column(name = "donation_support", nullable = false)
	private String dukungan;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
	
	@UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
