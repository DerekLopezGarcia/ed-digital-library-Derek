package com.iesam.digitallibrary.features.user.domain;

public interface UserRepository {
    void save(User user);
    void delete(String dni);
    User get(String dni);
}
