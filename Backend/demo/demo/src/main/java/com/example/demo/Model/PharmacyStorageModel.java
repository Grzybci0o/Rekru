package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name ="Magazyn")
public class PharmacyStorageModel {
    @Id
    @GeneratedValue
    int id;
    @Column(name = "nazwa_leku")
    String name;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_waznosci_leku")
    Date date;
    @Column(name = "ilosc_opakowan_w_magazynie")
    int amount;

}
