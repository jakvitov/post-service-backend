package cz.jakvitov.psservice.persistence.repo;

import cz.jakvitov.psservice.persistence.entity.PsUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Jakub Vítovec
 *  <h1>Repository for storing PsUser entity</h1>
 */
@Repository
public interface PsUserRepository extends JpaRepository <PsUser, Long> {

}
