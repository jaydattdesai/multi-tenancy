package com.jaydatt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.jaydatt.config.TenantContext;
import com.jaydatt.entity.SampleEntity;
import com.jaydatt.repository.SampleRepository;

@RestController
public class MultiTenantController {

    @Autowired
    private SampleRepository sampleRepository;

    @GetMapping(value = "/samples")
    public Iterable<SampleEntity> getSamples(@RequestHeader("X-TenantID") String tenantName) {
	TenantContext.setCurrentTenant(tenantName);
	return sampleRepository.findAll();
    }

    @PostMapping(value = "/samples")
    public SampleEntity addSample(@RequestHeader("X-TenantID") String tenantName,
	    @RequestBody SampleEntity sampleEntity) {
	TenantContext.setCurrentTenant(tenantName);
	return sampleRepository.save(sampleEntity);
    }

}
