package com.example.demo.Service.Impl;

import com.example.demo.Model.PharmacyStorageModel;
import com.example.demo.Repository.PharmacyStorageRepository;
import com.example.demo.Service.PharmacyStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacyStorageServiceImpl implements PharmacyStorageService {

    @Autowired
    private PharmacyStorageRepository pharmacyStorageRepository;

    @Override
    public List<PharmacyStorageModel> getAllMedicines() {
        return this.pharmacyStorageRepository.findAll();
    }
}
