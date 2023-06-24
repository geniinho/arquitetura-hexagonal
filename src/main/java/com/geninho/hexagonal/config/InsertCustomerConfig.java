package com.geninho.hexagonal.config;

import com.geninho.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.geninho.hexagonal.adapters.out.InsertCustomerAdapter;
import com.geninho.hexagonal.adapters.out.SendCpfValidationAdapter;
import com.geninho.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

  @Bean
  public InsertCustomerUseCase insertCustomerUseCase(
    FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
    InsertCustomerAdapter insertCustomerAdapter,
    SendCpfValidationAdapter sendCpfValidationAdapter
  ){
    return new InsertCustomerUseCase(findAddressByZipCodeAdapter,insertCustomerAdapter, sendCpfValidationAdapter);
  }
}
