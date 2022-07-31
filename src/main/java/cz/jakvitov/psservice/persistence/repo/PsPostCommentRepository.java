package cz.jakvitov.psservice.persistence.repo;

import cz.jakvitov.psservice.persistence.entity.PsPostComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author Jakub Vítovec
 *  <h1>Repository for storing PsPostComment entity</h1>
 */
public interface PsPostCommentRepository extends JpaRepository<PsPostComment, Long> {

    public List<PsPostComment> findByPostId(Long id);
}
