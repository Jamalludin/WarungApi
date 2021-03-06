package com.warung.makmi.warungapi.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class User implements Serializable {

    private String email;
    private String namaLengkap;
    private String password;
    private String role;
}
