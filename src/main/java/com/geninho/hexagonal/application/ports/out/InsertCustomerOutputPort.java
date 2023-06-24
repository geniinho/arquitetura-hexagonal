package com.geninho.hexagonal.application.ports.out;

import com.geninho.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {
  void insert(Customer customer);
}
