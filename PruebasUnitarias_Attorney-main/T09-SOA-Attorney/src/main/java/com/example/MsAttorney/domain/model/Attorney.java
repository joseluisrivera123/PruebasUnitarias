package com.example.MsAttorney.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Getter
@Setter
@NoArgsConstructor
public class Attorney {
    @Id
    private Integer id;
    private String name;
    private String fatherlastname;
    private String motherlastname;
    private String dni;
    private String cellphone;
    private String address;
    private String active;

    public Attorney(String name, String fatherlastname, String motherlastname, String dni, String cellphone, String address, String active) {
        this.name = name;
        this.fatherlastname = fatherlastname;
        this.motherlastname = motherlastname;
        this.dni = dni;
        this.cellphone = cellphone;
        this.address = address;
        this.active = active;
    }

    public Attorney(Integer id, String name, String fatherlastname, String motherlastname, String dni, String cellphone, String address, String active) {
        this.id = id;
        this.name = name;
        this.fatherlastname = fatherlastname;
        this.motherlastname = motherlastname;
        this.dni = dni;
        this.cellphone = cellphone;
        this.address = address;
        this.active = active;
    }
}
