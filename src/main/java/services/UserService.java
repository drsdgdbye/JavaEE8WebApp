package services;

import entities.User;
import repositories.UserRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.List;

@Stateless
public class UserService implements Serializable {
    private static final long serialVersionUID = 391856592901190395L;

    @EJB
    private UserRepository userRepository;

    public void saveOrUpdateUser(User user) {
        if (user.getId() == null) {
            userRepository.insert(user);
        } else {
            userRepository.update(user);
        }
    }

    public User getUserById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteUser(User user) {
        userRepository.delete(user.getId());
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
