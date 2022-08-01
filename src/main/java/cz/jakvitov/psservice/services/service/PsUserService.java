package cz.jakvitov.psservice.services.service;

import cz.jakvitov.psservice.persistence.entity.PsPost;
import cz.jakvitov.psservice.persistence.entity.PsUser;

import java.util.List;

/**
 * @Author Jakub Vítovec
 *  <h1>Service interface for PsUser</h1>
 */
public interface PsUserService {

    PsUser savePsUser(PsUser user);

    boolean deletePsUser(Long userId);
    List<PsUser> getAllPsUser();

    PsUser getPsUserById(Long id);

    PsUser fillPsUser(String nick, String pswdHash);
    boolean verifyLoginInfo(String pswdHash, String Nick);

    List<PsPost> getUserPosts(Long userId);
}
