package com.shweta.rest.service;

import java.util.List;

import com.shweta.rest.entity.Address;

public interface AddressService {
	
	Address createAddress(Address adr);
	Address updateAddress(Address adr,int id);
	void deleteAddress (int id) ;
	List<Address> getallAddresses();
	Address getAddressbyId(int id);
	

}
