package cz.jakvitov.psservice.persistence.repo;


import cz.jakvitov.psservice.persistence.entity.PsTopic;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author Jakub Vítovec
 *  <h1>Repository for storing Topic entity</h1>
 */
public interface PsTopicRepository extends JpaRepository<PsTopic, Long> {
    public PsTopic findByPostId(Long id);
}
