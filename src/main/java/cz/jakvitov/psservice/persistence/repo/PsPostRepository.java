package cz.jakvitov.psservice.persistence.repo;

import cz.jakvitov.psservice.persistence.entity.PsPost;
import cz.jakvitov.psservice.persistence.entity.PsTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * @Author Jakub Vítovec
 *  <h1>Repository for storing PsPost entity</h1>
 */
public interface PsPostRepository extends JpaRepository<PsPost, Long> {

    @Modifying
    @Transactional
    @Query(value = "update ps_post set post_text=:replacement where ps_post.post_id=:id", nativeQuery = true)
    void updatePostText(@Param("id") Long id,@Param("replacement") String replacement);

    @Query(value = "select topic_id from ps_topic where ps_topic.topic_id=:id", nativeQuery = true)
    Long getPsPostTopic(@Param("id") Long id);
}
