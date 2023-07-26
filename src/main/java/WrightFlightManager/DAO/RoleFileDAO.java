package WrightFlightManager.DAO;

import WrightFlightManager.MODEL.Role;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * The RoleFileDAO class implements the iRoleDAO interface to manage data related to the "Role" entity
 * using a file-based storage system. It represents the Data Access Object (DAO) pattern in the context
 * of managing roles.
 *
 * For more information about the Data Access Object (DAO) pattern, please refer to
 * the Wikipedia page:
 * @ref https://en.wikipedia.org/wiki/Data_access_object
 */
public class RoleFileDAO implements iRoleDAO {

    private final String roleFileName;

    /**
     * The default (non-parameterized) constructor sets the path to the Roles.psv file to a
     * standard location with the FILES directory
     *
     * Linked Issue: #65 https://github.com/WSUCEG-7140/TeamF/issues/65
     */
    public RoleFileDAO() {
        roleFileName = "src/main/java/WrightFlightManager/FILES/Roles.psv";
    }

    /**
     * The parameterized constructor sets the path to the Roles.psv to a user-specified location
     * @param roleFileName  A String representing a user-specified path to the Roles.psv file
     *
     * Linked Issue: #65 https://github.com/WSUCEG-7140/TeamF/issues/65
     */
    public RoleFileDAO(String roleFileName) {
        this.roleFileName = roleFileName;
    }

    /**
     * The addNewRole method takes a new Role as a parameter and adds it to the roles contained in
     * the Roles.psv file if that role ID and role title are not already in the file
     * @param newRole   A role representing the new role to add to the file
     * @return          A boolean value representing whether the Role was successfully added to
     *                  the file
     *
     * Linked Issue: #66 https://github.com/WSUCEG-7140/TeamF/issues/66
     */
    public boolean addNewRole(Role newRole) {
        boolean addSuccessful = false;
        boolean foundInHashMap = isRoleInFile(newRole);

        if (!foundInHashMap) {
            HashMap<Integer, Role> allRoles = getAllRoles();
            allRoles.put(newRole.getRoleId(), newRole);
            addSuccessful = writeToRolesFile(allRoles);
        }
        return addSuccessful;
    }

    /**
     * The getAllRoles method takes no parameters and returns all roles in the file as Role objects
     * @return  A HashMap that uses the roleId (Integer) as keys and the Role (object) as values
     *
     * Linked Issue: #67 https://github.com/WSUCEG-7140/TeamF/issues/67
     */
    public HashMap<Integer, Role> getAllRoles() {
        HashMap<Integer, Role> allRoles = new HashMap<>();

        try {
            Path roleFilePath = Path.of(roleFileName);
            Scanner fileRead = new Scanner(roleFilePath);
            while (fileRead.hasNextLine()) {
                String line = fileRead.nextLine();
                String[] splitLine = line.split("\\|");
                if (splitLine.length == 2) {
                    int roleId = Integer.parseInt(splitLine[0]);
                    String roleTitle = splitLine[1];
                    allRoles.put(roleId, new Role(roleId, roleTitle));
                }
            }
            fileRead.close();
        } catch (IOException e) {
            // Ignore
        }
        return allRoles;
    }

    /**
     * The updateRole method takes a Role as a parameter to update either the role ID or the role title,
     * but cannot update both the role ID AND role title for a specified role in the Roles.psv file
     * @param updatedRole   A Role representing the Role to be updated
     * @return              A boolean value representing whether the specified Role was successfully
     *                      updated in the file
     *
     * Linked Issue: #68 https://github.com/WSUCEG-7140/TeamF/issues/68
     */
    public boolean updateRole(Role updatedRole) {
        boolean updateSuccessful = false;

        if (deleteRole(updatedRole)) {
            updateSuccessful = addNewRole(updatedRole);
        }

        return updateSuccessful;
    }

    /**
     * The deleteRole method takes a Role as a parameter and deletes it from the Roles.psv file if it
     * exists
     * @param roleToDelete  A Role representing the Role to be deleted from the file
     * @return              A boolean value representing whether the specified Role was successfully
     *                      deleted from the file
     *
     * Linked Issue: #69 https://github.com/WSUCEG-7140/TeamF/issues/69
     */
    public boolean deleteRole(Role roleToDelete) {
        boolean deleteSuccessful = false;
        boolean removedFromHashMap = false;

        HashMap<Integer, Role> allRoles = getAllRoles();

        Iterator<Map.Entry<Integer, Role>> itr = allRoles.entrySet().iterator();

        while(itr.hasNext())
        {
            Map.Entry<Integer, Role> entry = itr.next();
            if (entry.getKey() == roleToDelete.getRoleId() || entry.getValue().getRoleTitle().equals(roleToDelete.getRoleTitle())) {
                itr.remove();
                removedFromHashMap = true;
            }
        }
        if (removedFromHashMap) {
            deleteSuccessful = writeToRolesFile(allRoles);
        }


        return deleteSuccessful;
    }

    /**
     * The isRoleInFile method is a helper method that takes a role as a parameter to check if a that
     * Role is in the role file by searching for a match of the role ID number OR the role title
     * @param checkRole This represents the Role being searched for within the file
     * @return          Returns true if the role was found in the file
     */
    private boolean isRoleInFile(Role checkRole) {

        boolean roleFound = false;
        HashMap<Integer, Role> allRoles = getAllRoles();

        for(Map.Entry<Integer, Role> entry : allRoles.entrySet()) {
            if (entry.getKey() == checkRole.getRoleId()) {
                roleFound = true;
                break;
            }
            else if (entry.getValue().getRoleTitle().equals(checkRole.getRoleTitle())) {
                roleFound = true;
                break;
            }
        }

        return roleFound;
    }

    /**
     * The writeToRolesFile is a helper method to write over the file specified by the roleFileName
     * field with a new list of roles
     * @param updatedRoles  This represents the new list of roles to be written to the roles file
     * @return              Returns true if successfully written to roles file
     */
    private boolean writeToRolesFile(HashMap<Integer, Role> updatedRoles) {
        boolean writeSuccessful = false;

        try {
            Path filePath = Path.of(roleFileName);
            FileWriter fw = new FileWriter(filePath.toFile(), false);
            for (Map.Entry<Integer, Role> entry : updatedRoles.entrySet()) {
                Role temp = entry.getValue();
                fw.write(temp.getRoleId() + "|" + temp.getRoleTitle() + "\n");
            }
            fw.flush();
            fw.close();
            writeSuccessful = true;
        } catch (IOException e) {
            // Ignored
        }

        return writeSuccessful;
    }
}
