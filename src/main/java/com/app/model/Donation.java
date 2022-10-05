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
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator", parameters = {
			@Parameter(name = "uuid_gen_strategy_class", value = "org.hibernate.id.uuid.CustomVersionOneStrategy") })
	@Column(name = "donation_id", updatable = false, nullable = false)
	private UUID id;

	@Column(name = "event_id", updatable = false, nullable = false)
	private String eventId;

	@Column(name = "donation_title", updatable = false, nullable = false)
	private String title;

	@Column(name = "donation_target", updatable = false, nullable = false)
	private String target;

	@Column(name = "donation_deadline", updatable = false, nullable = false)
	private LocalDateTime deadline;

	@Column(name = "donation_status", updatable = false, nullable = false)
	private int status;

	@Column(name = "donation_file", updatable = false, nullable = false)
	private String file;

	@Column(name = "donation_photo", updatable = false, nullable = false)
	private String photo;

	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false, updatable = false)
	private LocalDateTime updatedAt;
}
