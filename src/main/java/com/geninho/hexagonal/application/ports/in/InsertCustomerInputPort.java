package com.geninho.hexagonal.application.ports.in;

import com.geninho.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

  void insert(Customer customer, String zipCode);
}
