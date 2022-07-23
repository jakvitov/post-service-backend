package cz.jakvitov.psservice.persistence.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author Jakub Vítovec
 *  <h1>Entity mapping to table ps_user</h1>
 */

@Entity
@Table(name = "ps_user")
public class PsUser {

    /*-------------------Attributes------------------------*/

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "user_nick", unique = true)
    private String userNick;

    @Column(name = "user_pswd_hash")
    private String userPswdHash;

    @Column(name = "user_created_time")
    private LocalDateTime userCreatedTime;

    //TODO make relations as soon as other entities are ready

    /*-------------------Attributes------------------------*/

    public PsUser() {
    }

    public PsUser(long userId, String userNick, String userPswdHash, LocalDateTime userCreatedTime) {
        this.userId = userId;
        this.userNick = userNick;
        this.userPswdHash = userPswdHash;
        this.userCreatedTime = userCreatedTime;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getUserPswdHash() {
        return userPswdHash;
    }

    public void setUserPswdHash(String userPswdHash) {
        this.userPswdHash = userPswdHash;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getUserCreatedTime() {
        return userCreatedTime;
    }

    public void setUserCreatedTime(LocalDateTime userCreatedTime) {
        this.userCreatedTime = userCreatedTime;
    }
}
