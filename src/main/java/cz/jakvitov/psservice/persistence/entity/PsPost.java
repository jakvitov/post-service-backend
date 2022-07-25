package cz.jakvitov.psservice.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ps_post")
public class PsPost {

    /*-------------------Attributes------------------------*/

    @Id
    @Column(name = "post_id", updatable = false, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long postId = 1L;

    @Column(name = "post_test", nullable = false)
    private String postText;

    @Column(name = "post_created_time")
    private LocalDateTime postCreatedTime;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private PsUser psUser;

    //todo setup relation with topics as soon as topic entity is ready

    /*-------------------Attributes------------------------*/

    public PsPost() {
    }

    public PsPost(Long postId, String postText, LocalDateTime postCreatedTime, PsUser psUser) {
        this.postId = postId;
        this.postText = postText;
        this.postCreatedTime = postCreatedTime;
        this.psUser = psUser;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public LocalDateTime getPostCreatedTime() {
        return postCreatedTime;
    }

    public void setPostCreatedTime(LocalDateTime postCreatedTime) {
        this.postCreatedTime = postCreatedTime;
    }

    public PsUser getPsUser() {
        return psUser;
    }

    public void setPsUser(PsUser psUser) {
        this.psUser = psUser;
    }
}
