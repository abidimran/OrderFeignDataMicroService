package com.example.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Delivery implements Serializable{
	
	private static final long serialVersionUID = 3057875979777692592L;
	private Integer deliveryId;
	private String deliveryRiderName;
	private String deliveryStatus;
	private Date deliveryDate;
	private Integer orderId;
	private Integer paymentId;
	
	

}
