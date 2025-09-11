package com.hospital.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "hospital_users")
public class HospitalUser implements Serializable{

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private Long userId;  // comes from user-service

	    @Column(nullable = false)
	    private String roleInHospital;  // ADMIN, OPERATOR, DOCTOR

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "hospital_id")
	    private Hospital hospital;

	    @Column
	    private LocalDateTime createdAt;


}
