package com.app.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "donation")
public class Donation {
	@Id
	@Column(name = "donation_id", updatable = false, nullable = false)
	@SequenceGenerator(name="pk_donation",sequenceName="seq_dns", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_donation")
	private Long id;

//	@Column(name = "event_id", nullable = false)
//	private Long eventId;

	@Column(name = "donation_title",  nullable = false)
	private String title;

	@Column(name = "donation_target", nullable = false)
	private Long target;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "donation_deadline",  nullable = false)
	private Date deadline;

	@Column(name = "donation_status", nullable = false)
	private int status;

	@Column(name = "donation_photo",  nullable = false)
	private String photo;
	
	@OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
//	@Column(name = "payment_id", nullable = false)
//	private String payment;

	@CreationTimestamp
	@Column(name = "created_at",  updatable = false)
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at", updatable = false)
	private LocalDateTime updatedAt;
	
	@OneToOne
    @JoinColumn(name = "event_id")
    private Event event;
	
	@OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "donation_id")
	private List<ListDonatur> donatur;
}
