package com.hospital.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entity.HospitalRequest;

public interface HospitalRequestRespositary extends JpaRepository<HospitalRequest, Integer>{

}
