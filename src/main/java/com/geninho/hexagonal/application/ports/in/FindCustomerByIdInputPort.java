package com.geninho.hexagonal.application.ports.in;

import com.geninho.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {
  Customer find(String id);
}
