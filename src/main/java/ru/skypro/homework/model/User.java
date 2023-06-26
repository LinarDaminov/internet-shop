package ru.skypro.homework.model;

import lombok.Data;
import ru.skypro.homework.dto.Role;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private Role role;
}
