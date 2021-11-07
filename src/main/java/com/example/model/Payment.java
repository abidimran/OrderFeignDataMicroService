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
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Payment implements Serializable{
	
	private static final long serialVersionUID = -1370089557407175473L;
	private Integer paymentId;
	private String paymentStatus;
	private Date paymentDate;
	private Integer orderId;
	
	
	

}
