package com.hospital.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entity.Shipment;

public interface ShipmentRepositary extends JpaRepository<Shipment, Integer>{

}
