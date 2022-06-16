package com.shweta.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shweta.rest.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
