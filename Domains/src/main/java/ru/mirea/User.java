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
        this.role = getRoleR(role);
    }

    public static String getStringRole(Role role){
        String roleS;
        switch (role){
            case user:
                roleS = "user";
                break;
            case admin:
                roleS = "admin";
                break;
            default:
                roleS = "error";
                break;
        }
        return roleS;
    }

    public static Role getRoleR(String roleS){
        Role r;
        switch (roleS){
            case "user":
                r = Role.user;
                break;
            case "admin":
                r = Role.admin;
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
        user,
        //Администратор
        admin
    }

    public User(){

    }
}
