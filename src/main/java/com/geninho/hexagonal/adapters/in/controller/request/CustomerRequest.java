package com.geninho.hexagonal.adapters.in.controller.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CustomerRequest {

  @NotBlank
  private String nome;
  @NotBlank
  private String cpf;
  @NotBlank
  private String zipCode;
}
