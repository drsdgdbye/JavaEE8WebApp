package services;

import entities.Role;
import repositories.RoleRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.List;

@Stateless
public class RoleService implements Serializable {
    private static final long serialVersionUID = -3901357010456489797L;

    @EJB
    private RoleRepository roleRepository;

    public void saveOrUpdateRole(Role role) {
        if (role.getId() == null) {
            roleRepository.insert(role);
        } else {
            roleRepository.update(role);
        }
    }

    public Role getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    public void deleteRole(Role role) {
        roleRepository.delete(role.getId());
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
