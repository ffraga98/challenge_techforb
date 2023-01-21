package com.techforb.challenge.repository;

import com.techforb.challenge.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
