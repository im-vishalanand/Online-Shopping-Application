package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {


    @Autowired
    private CartService cartService;





}
