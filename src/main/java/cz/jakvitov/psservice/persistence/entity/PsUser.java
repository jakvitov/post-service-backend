package cz.jakvitov.psservice.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author Jakub Vítovec
 *  <h1>Entity mapping to table ps_user</h1>
 */

@Entity
@Table(name = "ps_user")
public class PsUser {

    /*-------------------Attributes------------------------*/

    @Id
    @Column(name = "user_id", updatable = false, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long userId = 1L;

    @Column(name = "user_nick", unique = true)
    private String userNick;

    @Column(name = "user_pswd_hash")
    private String userPswdHash;

    @Column(name = "user_created_time")
    private LocalDateTime userCreatedTime;

    @OneToMany(mappedBy = "psUser")
    private List<PsPost> psPosts;

    //TODO make relations as soon as other entities are ready

    /*-------------------Attributes------------------------*/

    public PsUser() {
    }

    public PsUser(Long userId, String userNick, String userPswdHash, LocalDateTime userCreatedTime, List<PsPost> psPosts) {
        this.userId = userId;
        this.userNick = userNick;
        this.userPswdHash = userPswdHash;
        this.userCreatedTime = userCreatedTime;
        this.psPosts = psPosts;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

    public LocalDateTime getUserCreatedTime() {
        return userCreatedTime;
    }

    public void setUserCreatedTime(LocalDateTime userCreatedTime) {
        this.userCreatedTime = userCreatedTime;
    }

    public List<PsPost> getPsPosts() {
        return psPosts;
    }

    public void setPsPosts(List<PsPost> psPosts) {
        this.psPosts = psPosts;
    }
}
