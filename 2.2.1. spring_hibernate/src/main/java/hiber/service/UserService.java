package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    public User getUserWhereCar(Long id, int series);
    List<User> listUsers();
}
