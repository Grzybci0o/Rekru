package com.example.demo.Repository;

import com.example.demo.Model.PharmacyStorageModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyStorageRepository extends JpaRepository<PharmacyStorageModel, Integer> {
}
