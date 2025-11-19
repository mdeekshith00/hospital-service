package com.hospital.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entity.HospitalAuditLog;

public interface HospitaiAuditLogRepositary extends JpaRepository<HospitalAuditLog, Integer>{

}
