package com.geninho.hexagonal.adapters.out.client.mapper;

import com.geninho.hexagonal.adapters.out.client.response.AddressResponse;
import com.geninho.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
  Address toAddress(AddressResponse addressResponse);
}
