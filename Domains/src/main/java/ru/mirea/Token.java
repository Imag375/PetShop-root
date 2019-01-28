package ru.mirea;

public class Token {

    protected int userID;
    protected User.Role role;
    protected String signature;

    public Token(int userID, User.Role role) {
        this.userID = userID;
        this.role = role;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public User.Role getRole() {
        return role;
    }

    public void setRole(User.Role role) {
        this.role = role;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString(){
        return userID + User.getStringRole(role);
    }

    public Token(){

    }
}
