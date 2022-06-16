package com.shweta.rest.Dto;

import com.shweta.rest.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDTO {
	int addrId;
	String streetName;
	long pincode;
}
