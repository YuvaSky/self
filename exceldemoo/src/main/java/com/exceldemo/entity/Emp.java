package com.exceldemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Emp {

	@Id
	private int eid;
	private String name;
	private String role;
	
}
