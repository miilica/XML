package com.example.zuul;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "auth")
public interface AuthClient {



}

