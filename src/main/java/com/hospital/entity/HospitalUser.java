package com.hospital.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hospital.enums.ApprovalStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "hospital_users")
public class HospitalUser implements Serializable{

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    private Integer userId;  // comes from user-service

	    @Column(nullable = false)
	    private String roleInHospital;  // ADMIN, OPERATOR, DOCTOR

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "hospital_id")
	    @JsonBackReference
	    private Hospital hospital;

	    @Column(name = "created_at")
	    private LocalDateTime createdAt;


}
