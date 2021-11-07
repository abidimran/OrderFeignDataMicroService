package com.example.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Delivery implements Serializable{
	
	private static final long serialVersionUID = 3057875979777692592L;
	private Integer deliveryId;
	private String deliveryRiderName;
	private String deliveryStatus;
	private Date deliveryDate;
	private Integer orderId;
	
	

}
