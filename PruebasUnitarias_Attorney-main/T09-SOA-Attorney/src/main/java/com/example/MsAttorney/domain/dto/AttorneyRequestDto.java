package com.example.MsAttorney.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class AttorneyRequestDto implements Serializable {

    private static final long serialVersionUID = 8222253670338491507L;
    private String name;
    private String fatherlastname;
    private String motherlastname;
    private String dni;
    private String cellphone;
    private String address;
    private String active;



    public AttorneyRequestDto(int id,String name, String fatherlastname,String motherlastname, String dni,String cellphone, String address,String active) {
        this.name = name;
        this.fatherlastname = fatherlastname;
        this.motherlastname = motherlastname;
        this.dni = dni;
        this.cellphone = cellphone;
        this.address = address;
        this.active = active;
    }

    public AttorneyRequestDto() {

    }
}
