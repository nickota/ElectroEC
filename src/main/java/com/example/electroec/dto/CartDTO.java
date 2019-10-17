package com.example.electroec.dto;

import com.example.electroec.entity.Product;

import lombok.Data;

@Data
public class CartDTO {

	private Integer userId;
	private Product product;
	private Integer quantity;
}
