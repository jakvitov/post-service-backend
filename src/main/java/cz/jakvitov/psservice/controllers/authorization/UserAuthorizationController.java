package cz.jakvitov.psservice.controllers.authorization;

import cz.jakvitov.psservice.controllers.support_objects.UserLoginInfo;
import cz.jakvitov.psservice.controllers.support_objects.UserRegisterInfo;
import cz.jakvitov.psservice.exceptions.DuplicateNameException;
import cz.jakvitov.psservice.exceptions.LoginFailedException;
import cz.jakvitov.psservice.persistence.entity.PsUser;
import cz.jakvitov.psservice.services.serviceimpl.PsUserServiceImpl;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

/**
 * @Author Jakub Vítovec
 *  <h1>Rest controller for user authorization</h1>
 */

@RestController
@RequestMapping("/auth")
public class UserAuthorizationController {

    @Autowired
    private PsUserServiceImpl psUserService;

    private static final Logger logger = Logger.getLogger(UserAuthorizationController.class);

    @PostMapping("/register")
    public PsUser registerPsUser(@RequestBody UserRegisterInfo registerInfo){
        try {
            PsUser user = psUserService.fillPsUser(registerInfo.getName(), registerInfo.getPswdHash());
            return psUserService.savePsUser(user);
        }
        //Signals that the username already exists
        catch (org.springframework.dao.DataIntegrityViolationException DIVE){
            throw new DuplicateNameException(DIVE);
        }
    }

    @PostMapping("/login")
    @ResponseBody
    public UserLoginInfo verifyLoginInfo(@RequestBody UserLoginInfo loginInfo) {
        try {
            if (psUserService.verifyLoginInfo(loginInfo.getName(), loginInfo.getPswdHash())){
                return loginInfo;
            }
            else {
                logger.warn("{verifyLoginInfo} returned false.");
                throw new LoginFailedException();
            }
        }
        catch (EntityNotFoundException ENFE){
            throw new LoginFailedException(ENFE);
        }
        //Two entries in database with the same nick encountered
        catch (RuntimeException RE){
            throw new LoginFailedException(RE);
        }
    }

}
