package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.Country;
import com.cognizant.repository.CountryRepository;

@Service
public class CountryService {

    @Autowired
    CountryRepository repository;

    public List<Country> getCountries() {

        return repository.findAll();

    }

}
