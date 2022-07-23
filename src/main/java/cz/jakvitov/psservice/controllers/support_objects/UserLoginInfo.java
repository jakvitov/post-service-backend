package cz.jakvitov.psservice.controllers.support_objects;
/**
 * @Author Jakub Vítovec
 *  <h1>Support object for PSUserController containing user login info</h1>
 */
public class UserLoginInfo {

    private String name;
    private String pswdHash;

    public UserLoginInfo() {
    }

    public UserLoginInfo(String name, String pswd_hash) {
        this.name = name;
        this.pswdHash = pswd_hash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPswdHash() {
        return pswdHash;
    }

    public void setPswdHash(String pswdHash) {
        this.pswdHash = pswdHash;
    }
}
