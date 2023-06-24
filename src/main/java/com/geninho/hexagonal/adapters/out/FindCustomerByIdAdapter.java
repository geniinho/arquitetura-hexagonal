package com.geninho.hexagonal.adapters.out;

import com.geninho.hexagonal.adapters.out.repository.CustomerRepository;
import com.geninho.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.geninho.hexagonal.application.core.domain.Customer;
import com.geninho.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

  @Autowired
  private CustomerRepository customerRepository;
  @Autowired
  private CustomerEntityMapper customerEntityMapper;

  @Override
  public Optional<Customer> find(String id) {
    var customerEntity = customerRepository.findById(id);
    return customerEntity.map(entity ->customerEntityMapper.toCustomer(entity));
  }
}
