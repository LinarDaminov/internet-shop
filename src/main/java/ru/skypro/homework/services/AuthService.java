package ru.skypro.homework.services;
import ru.skypro.homework.dto.RegisterReq;


public interface AuthService {
    boolean login(String userName, String password);
    boolean register(RegisterReq registerReq);
}