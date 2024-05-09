package com.iesam.digitallibrary.features.user.domain;

import java.util.ArrayList;


public interface UserRepository {
    void save(User user);
    void delete(String dni);
    User get(String dni);
    ArrayList<User> getAll();
}
