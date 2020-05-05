package controllers;

import entities.Role;
import entities.User;
import lombok.Getter;
import lombok.Setter;
import services.RoleService;
import services.UserService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class UserController implements Serializable {
    private static final long serialVersionUID = -4118144519094007627L;

    @EJB
    private UserService userService;

    @Inject
    private RoleService roleService;

    @Getter
    @Setter
    private User user;

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    public String editUser(User user) {
        this.user = user;
        return "/admin/user.xhtml?faces-redirect=true";
    }

    public void deleteUser(User user) {
        userService.deleteUser(user);
    }

    public String createUser() {
        this.user = new User();
        return "/admin/user.xhtml?faces-redirect=true";
    }

    public String saveUser() {
        userService.saveOrUpdateUser(this.user);
        return "/admin/users.xhtml?faces-redirect=true";
    }

    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }
}
