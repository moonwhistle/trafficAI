package com.example.backend.api.marketing.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AddressMaster {

    @Id
    private String dongId;
    private String dongNm;
    private String ctpvNm;
    private String cggNm;

    public AddressMaster() {}
}
