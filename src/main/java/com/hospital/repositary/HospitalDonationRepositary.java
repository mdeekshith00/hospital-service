package com.hospital.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entity.HospitalDonation;

public interface HospitalDonationRepositary extends JpaRepository<HospitalDonation, Integer>{

}
