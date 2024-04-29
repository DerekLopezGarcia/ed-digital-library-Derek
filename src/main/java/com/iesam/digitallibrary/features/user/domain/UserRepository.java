package com.iesam.digitallibrary.features.user.domain;

import java.util.List;

public interface UserRepository {
    void save(User user);
    void delete(String dni);
    User get(String dni);
    List<User> getAll();
}
