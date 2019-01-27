package ru.mirea;

public class User {

    protected int id;
    protected String login;
    protected String password;
    protected Role role;

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public User(int id, String login, String password, String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = getRole(role);
    }

    public static String getStringRole(Role role){
        String roleS;
        switch (role){
            case User:
                roleS = "User";
                break;
            case Admin:
                roleS = "Admin";
                break;
            default:
                roleS = "Error";
                break;
        }
        return roleS;
    }

    public static Role getRole(String roleS){
        Role r;
        switch (roleS){
            case "User":
                r = Role.User;
                break;
            case "Admin":
                r = Role.Admin;
                break;
            default:
                r = null;
                break;
        }
        return r;
    }

    //Роли пользователей
    public enum Role {
        //Пользователь
        User,
        //Администратор
        Admin
    }
}
