package com.hospital.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entity.Hospital;

public interface HospitalRepositary extends JpaRepository<Hospital, Integer>{

}
