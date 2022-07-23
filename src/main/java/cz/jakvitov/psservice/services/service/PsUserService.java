package cz.jakvitov.psservice.services.service;

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
    PsUser getPsUserByNamePswd(String pswdHash, String Nick);
}
