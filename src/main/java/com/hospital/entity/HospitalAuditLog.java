package com.hospital.entity;

import java.sql.Timestamp;

public class HospitalAuditLog {
	
	private Long HospitalAuditLogId;
	private Integer hospitalId;
	private String action;
	private Timestamp timestamp;
	private String notes;


}
