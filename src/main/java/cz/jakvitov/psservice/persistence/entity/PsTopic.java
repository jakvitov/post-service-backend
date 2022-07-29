package cz.jakvitov.psservice.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ps_topic")
public class PsTopic {

    /*-------------------Attributes------------------------*/

    @Id
    @Column(name = "topic_id", updatable = false, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long postId = 1L;

    @Column(name = "topic_name", nullable = false)
    private String topicName;

    @Column(name = "topic_created_time")
    private LocalDateTime topicCreatedTime;

    @ManyToOne
    @JsonBackReference("user-topic")
    @JoinColumn(name = "user_id", nullable = false)
    private PsUser psUser;

    @OneToMany(mappedBy = "psTopic")
    @JsonManagedReference("topic-post")
    private List<PsPost> psPosts;

    /*-------------------Attributes------------------------*/


    public PsTopic() {
    }

    public PsTopic(Long postId, String topicName, LocalDateTime topicCreatedTime, PsUser psUser, List<PsPost> psPosts) {
        this.postId = postId;
        this.topicName = topicName;
        this.topicCreatedTime = topicCreatedTime;
        this.psUser = psUser;
        this.psPosts = psPosts;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public LocalDateTime getTopicCreatedTime() {
        return topicCreatedTime;
    }

    public void setTopicCreatedTime(LocalDateTime topicCreatedTime) {
        this.topicCreatedTime = topicCreatedTime;
    }

    public PsUser getPsUser() {
        return psUser;
    }

    public void setPsUser(PsUser psUser) {
        this.psUser = psUser;
    }

    public List<PsPost> getPsPosts() {
        return psPosts;
    }

    public void setPsPosts(List<PsPost> psPosts) {
        this.psPosts = psPosts;
    }
}
