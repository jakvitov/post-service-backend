package cz.jakvitov.psservice.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    private PsTopic psTopic;

    @OneToMany(mappedBy = "psPost")
    private List<PsPostComment> PsPostComments;


    /*-------------------Attributes------------------------*/

    public PsPost() {
    }

    public PsPost(Long postId, String postText, LocalDateTime postCreatedTime, PsUser psUser, PsTopic psTopic, List<PsPostComment> psPostComments) {
        this.postId = postId;
        this.postText = postText;
        this.postCreatedTime = postCreatedTime;
        this.psUser = psUser;
        this.psTopic = psTopic;
        PsPostComments = psPostComments;
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

    public PsTopic getPsTopic() {
        return psTopic;
    }

    public void setPsTopic(PsTopic psTopic) {
        this.psTopic = psTopic;
    }

    public List<PsPostComment> getPsPostComments() {
        return PsPostComments;
    }

    public void setPsPostComments(List<PsPostComment> psPostComments) {
        PsPostComments = psPostComments;
    }
}
