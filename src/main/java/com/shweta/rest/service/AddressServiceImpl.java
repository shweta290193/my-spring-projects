package com.shweta.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shweta.rest.entity.Address;
import com.shweta.rest.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepository; 
	
	@Override
	public Address createAddress(Address adr) {
		return addressRepository.save(adr);
	}

	@Override
	public Address updateAddress(Address updatedAddress, int id) {
		Address a = addressRepository.findById(id).get();
		a.setPincode(updatedAddress.getPincode());
		a.setStreetName(updatedAddress.getStreetName());
		return addressRepository.save(a);
	}

	@Override
	public void deleteAddress(int id) {
		addressRepository.deleteById(id);
	}

	@Override
	public List<Address> getallAddresses() {
		return addressRepository.findAll();
	}

	@Override
	public Address getAddressbyId(int id) {
		return addressRepository.findById(id).get();
	}

}
