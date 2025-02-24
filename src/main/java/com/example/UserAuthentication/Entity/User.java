package com.example.UserAuthentication.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class User {

    private String id;
    private String userName;
    private Double balance;

}
