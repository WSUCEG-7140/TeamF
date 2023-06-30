package WrightFlightManager.DAO;

import WrightFlightManager.MODEL.Role;

import java.util.HashMap;

public interface iRoleDAO {
    boolean addNewRole(Role newRole);
    HashMap<Integer, Role> getAllRoles();
    boolean updateRole(Role updatedRole);
    boolean deleteRole(Role roleToDelete);
}
