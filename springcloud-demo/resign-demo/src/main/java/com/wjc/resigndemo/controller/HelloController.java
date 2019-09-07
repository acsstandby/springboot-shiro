package com.wjc.resigndemo.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class HelloController {
    private final Logger logger = Logger.getLogger(String.valueOf(getClass()));

    @Autowired
    private DiscoveryClient client;
    @RequestMapping("/hello")
    public String index() {
        List<ServiceInstance> instances=client.getInstances("hello-service");
        for (int i=0;i<instances.size();i++){
            logger.info("/hello,host:"+instances.get(i).getHost()+",service_id:"+instances.get(i).getServiceId());
        }
         return "hello World";
    }


}
