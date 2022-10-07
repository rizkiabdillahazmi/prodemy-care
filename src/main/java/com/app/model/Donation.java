package com.app.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "donation")
public class Donation {
	@Id
	@Column(name = "donation_id", updatable = false, nullable = false)
	private int id;

	@Column(name = "event_id", nullable = false)
	private String eventId;

	@Column(name = "donation_title",  nullable = false)
	private String title;

	@Column(name = "donation_target", nullable = false)
	private String target;

	@Column(name = "donation_deadline",  nullable = false)
	private LocalDateTime deadline;

	@Column(name = "donation_status", nullable = false)
	private int status;

	@Column(name = "donation_file",  nullable = false)
	private String file;

	@Column(name = "donation_photo",  nullable = false)
	private String photo;
	
	@Column(name = "payment_id", nullable = false)
	private String payment;

	@CreationTimestamp
	@Column(name = "created_at",  updatable = false)
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at", updatable = false)
	private LocalDateTime updatedAt;
}
