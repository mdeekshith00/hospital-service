package com.hospital.entity;

import java.time.LocalDate;
import java.util.UUID;

public class HospitaiInventory {
	
	private UUID hospitalInventoryId ; // (UUID)
	private Integer hospitalId;
	private Integer componentId; // (if linked to central Blood-Service unit) or `localUnitId`
	private String  bloodGroup;
	private String  StringcomponentType; //  (RBC, Plasma, Platelet)
	private String volumeMl;
	private LocalDate expiryDate;
	private String status;  // (AVAILABLE, RESERVED, ISSUED, TRANSFERRED, EXPIRED)
	private String source ; // (OWN, CENTRAL, DONATION)
	private String storageLocation ; //  (fridge id)

}
