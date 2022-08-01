package cz.jakvitov.psservice.services.serviceimpl;

import cz.jakvitov.psservice.persistence.entity.PsPost;
import cz.jakvitov.psservice.persistence.entity.PsUser;
import cz.jakvitov.psservice.persistence.repo.PsUserRepository;
import cz.jakvitov.psservice.services.service.PsUserService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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

    private static final Logger logger = Logger.getLogger(PsUserServiceImpl.class);


    @Override
    public PsUser savePsUser(PsUser user) throws org.hibernate.exception.ConstraintViolationException {
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

    //Returns all known details about user, his posts, topics etc.
    @Override
    public PsUser getPsUserById(Long id) throws EntityNotFoundException{
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

    //User nick must be unique and not null in database -> we should always get only one record back
    @Override
    public boolean verifyLoginInfo (String nick, String pswdHash) throws EntityNotFoundException {
        List<PsUser> users = psUserRepository.findByUserNick(nick);
        if (users.size() == 0 || !users.get(0).getUserPswdHash().equals(pswdHash)){
            throw new EntityNotFoundException("No user with given nick and password!");
        }
        else if (users.size() == 1 && users.get(0).getUserPswdHash().equals(pswdHash)){
            return true;
        }
        //Someone must have changed the user entity by default, this should never happen
        else {
            logger.error("{verifyLoginInfo} More users returned by one nick");
            throw new RuntimeException("More users returned by nick.");
        }
    }
    //todo solve cycling dependency
    @Override
    public List<PsPost> getUserPosts(Long userId){
        return this.getPsUserById(userId).getPsPosts();
    }
}
