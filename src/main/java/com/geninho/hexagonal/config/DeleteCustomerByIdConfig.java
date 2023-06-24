package com.geninho.hexagonal.config;

import com.geninho.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.geninho.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.geninho.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {
  @Bean
  public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
    FindCustomerByIdUseCase findCustomerByIdUseCase,
    DeleteCustomerByIdAdapter deleteCustomerByIdAdapter
  ){
    return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase,deleteCustomerByIdAdapter);
  }
}
