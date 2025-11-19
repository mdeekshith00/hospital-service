package com.hospital.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entity.HospitalHistory;

public interface HospitalHistoryRepositary extends JpaRepository<HospitalHistory, Integer>{

}
