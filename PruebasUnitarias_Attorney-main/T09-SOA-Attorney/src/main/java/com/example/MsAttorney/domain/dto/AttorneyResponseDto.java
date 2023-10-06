package com.example.MsAttorney.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class AttorneyResponseDto implements Serializable {
    private static final long serialVersionUID = 8735757125749188522L;

    private Integer id;
    private String name;
    private String fatherlastname;
    private String motherlastname;
    private String dni;
    private String cellphone;
    private String address;
    private String active;


    public AttorneyResponseDto() {
        this.name = name;
        this.fatherlastname = fatherlastname;
        this.motherlastname = motherlastname;
        this.dni = dni;
        this.cellphone = cellphone;
        this.address = address;
        this.active = active;
    }
}
