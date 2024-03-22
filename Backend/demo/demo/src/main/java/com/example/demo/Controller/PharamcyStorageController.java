package com.example.demo.Controller;

import com.example.demo.Model.PharmacyStorageModel;
import com.example.demo.Service.PharmacyStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PharamcyStorageController {

    @Autowired
    private PharmacyStorageService pharmacyStorageService;

    @GetMapping("/getAllMedicines")
    public ResponseEntity<List<PharmacyStorageModel>> getPhramacyStorage() {
        return ResponseEntity.ok().body(pharmacyStorageService.getAllMedicines());
    }
}
