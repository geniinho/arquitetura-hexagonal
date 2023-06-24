package com.geninho.hexagonal.application.core.usecase;

import com.geninho.hexagonal.application.core.domain.Customer;
import com.geninho.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.geninho.hexagonal.application.ports.out.FindAddresByZipCodeOutPort;
import com.geninho.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.geninho.hexagonal.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

  private final FindAddresByZipCodeOutPort findAddresByZipCodeOutPort;
  private final InsertCustomerOutputPort insertCustomerOutputPort;

  private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

  public InsertCustomerUseCase(FindAddresByZipCodeOutPort findAddresByZipCodeOutPort,
                               InsertCustomerOutputPort insertCustomerOutputPort, SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
    this.findAddresByZipCodeOutPort = findAddresByZipCodeOutPort;
    this.insertCustomerOutputPort = insertCustomerOutputPort;
    this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
  }

  @Override
  public void insert(Customer customer, String zipCode) {
    var address = findAddresByZipCodeOutPort.find(zipCode);
    customer.setAddress(address);
    insertCustomerOutputPort.insert(customer);
    sendCpfForValidationOutputPort.send(customer.getCpf());
  }
}
