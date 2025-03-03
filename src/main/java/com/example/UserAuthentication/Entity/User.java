package com.example.UserAuthentication.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
//@Component
public class User {

    private String id;
    private String userName;
    private String password;
    private Double balance;

    public String[] toArray() {
        return new String[]{
                id, userName, password, String.valueOf(balance)
        };
    }

}
