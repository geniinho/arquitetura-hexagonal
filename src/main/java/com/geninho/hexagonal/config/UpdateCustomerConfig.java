package com.geninho.hexagonal.config;

import com.geninho.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.geninho.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.geninho.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.geninho.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

  @Bean
  public UpdateCustomerUseCase updateCustomerUseCase
    (
      FindCustomerByIdUseCase findCustomerByIdUseCase,
      FindAddressByZipCodeAdapter findAddresByZipCodeAdapter,
      UpdateCustomerAdapter updateCustomerAdapter
    )
  {
    return new UpdateCustomerUseCase(findCustomerByIdUseCase,findAddresByZipCodeAdapter,updateCustomerAdapter);
  }
}
