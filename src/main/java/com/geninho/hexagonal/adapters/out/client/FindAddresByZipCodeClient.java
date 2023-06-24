package com.geninho.hexagonal.adapters.out.client;

import com.geninho.hexagonal.adapters.out.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
  name = "FindAddresByZipCodeClient",
  url = "${geninho.clint.address.url}"
)
public interface FindAddresByZipCodeClient {
  @GetMapping("/{zidCode}")
  AddressResponse find(@PathVariable("zipCode") String zipCode);
}
