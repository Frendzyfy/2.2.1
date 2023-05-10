package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    public User getUserWhereCar(String model, int series);
    List<User> listUsers();
}
