package com.geninho.hexagonal.application.ports.out;

import com.geninho.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {
  void update(Customer customer);
}
