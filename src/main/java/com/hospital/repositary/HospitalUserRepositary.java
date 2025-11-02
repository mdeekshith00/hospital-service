package com.hospital.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entity.HospitalUser;

public interface HospitalUserRepositary extends JpaRepository<HospitalUser, Integer>{

}
