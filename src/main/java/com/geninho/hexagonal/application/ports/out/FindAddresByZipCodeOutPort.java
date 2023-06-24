package com.geninho.hexagonal.application.ports.out;

import com.geninho.hexagonal.application.core.domain.Address;

public interface FindAddresByZipCodeOutPort {
  Address find(String zipCode);
}
