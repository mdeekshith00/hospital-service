package com.hospital.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entity.HospitaiInventory;

public interface HospitaiInventoryRespositary extends JpaRepository<HospitaiInventory, Integer>{

}
