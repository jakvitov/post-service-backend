package cz.jakvitov.psservice.services.serviceimpl;

import cz.jakvitov.psservice.PsServiceApplication;
import cz.jakvitov.psservice.persistence.entity.PsUser;
import cz.jakvitov.psservice.persistence.repo.PsUserRepository;
import cz.jakvitov.psservice.services.service.PsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author Jakub Vítovec
 *  <h1>Service implementation for ps_user</h1>
 */
@Service
public class PsUserServiceImpl implements PsUserService {

    @Autowired
    PsUserRepository psUserRepository;

    @Override
    public PsUser savePsUser(PsUser user) {
        return psUserRepository.save(user);
    }

    @Override
    public boolean deletePsUser(Long userId) {
        psUserRepository.deleteById(userId);
        return true;
    }

    @Override
    public List<PsUser> getAllPsUser() {
        return psUserRepository.findAll();
    }

    @Override
    public PsUser getPsUserById(Long id) {
        return psUserRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    public PsUser fillPsUser(String nick, String pswdHash) {
        PsUser user = new PsUser();
        user.setUserNick(nick);
        user.setUserPswdHash(pswdHash);
        user.setUserCreatedTime(LocalDateTime.now());
        return user;
    }
}
