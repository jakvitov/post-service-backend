package cz.jakvitov.psservice.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ps_post_comment")
public class PsPostComment {

    /*-------------------Attributes------------------------*/

    @Id
    @Column(name = "post_comment_id", updatable = false, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long postCommentId = 1L;

    @Column(name = "post_comment_text", nullable = false)
    private String commentText;

    @Column(name = "post_comment_created_time")
    private LocalDateTime postCommentCreatedTime;

    @ManyToOne
    @JsonBackReference("post-comment")
    @JoinColumn(name = "post_id", nullable = false)
    private PsPost psPost;

    @ManyToOne
    @JsonBackReference("user-comment")
    @JoinColumn(name = "user_id", nullable = false)
    private PsUser psUser;

    /*-------------------Attributes------------------------*/

    public PsPostComment() {
    }

    public PsPostComment(Long postCommentId, String commentText, LocalDateTime postCommentCreatedTime, PsPost psPost, PsUser psUser) {
        this.postCommentId = postCommentId;
        this.commentText = commentText;
        this.postCommentCreatedTime = postCommentCreatedTime;
        this.psPost = psPost;
        this.psUser = psUser;
    }

    public Long getPostCommentId() {
        return postCommentId;
    }

    public void setPostCommentId(Long postCommentId) {
        this.postCommentId = postCommentId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public LocalDateTime getPostCommentCreatedTime() {
        return postCommentCreatedTime;
    }

    public void setPostCommentCreatedTime(LocalDateTime postCommentCreatedTime) {
        this.postCommentCreatedTime = postCommentCreatedTime;
    }

    public PsPost getPsPost() {
        return psPost;
    }

    public void setPsPost(PsPost psPost) {
        this.psPost = psPost;
    }

    public PsUser getPsUser() {
        return psUser;
    }

    public void setPsUser(PsUser psUser) {
        this.psUser = psUser;
    }
}
