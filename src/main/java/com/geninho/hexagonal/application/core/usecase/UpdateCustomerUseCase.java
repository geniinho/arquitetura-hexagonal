package com.geninho.hexagonal.application.core.usecase;

import com.geninho.hexagonal.application.core.domain.Customer;
import com.geninho.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.geninho.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.geninho.hexagonal.application.ports.out.FindAddresByZipCodeOutPort;
import com.geninho.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

  private final FindCustomerByIdInputPort findCustomerByIdInputPort;
  private final FindAddresByZipCodeOutPort findAddresByZipCodeOutPort;
  private final UpdateCustomerOutputPort updateCustomerOutputPort;

  public UpdateCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                               FindAddresByZipCodeOutPort findAddresByZipCodeOutPort,
                               UpdateCustomerOutputPort updateCustomerOutputPort) {
    this.findCustomerByIdInputPort = findCustomerByIdInputPort;
    this.findAddresByZipCodeOutPort = findAddresByZipCodeOutPort;
    this.updateCustomerOutputPort = updateCustomerOutputPort;
  }

  @Override
  public void update(Customer customer, String zipCode){
    findCustomerByIdInputPort.find(customer.getId());
    var address = findAddresByZipCodeOutPort.find(zipCode);
    customer.setAddress(address);
    updateCustomerOutputPort.update(customer);
  }
}
