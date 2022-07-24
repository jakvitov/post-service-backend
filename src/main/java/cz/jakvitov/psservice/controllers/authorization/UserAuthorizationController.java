package cz.jakvitov.psservice.controllers.authorization;

import cz.jakvitov.psservice.controllers.support_objects.UserLoginInfo;
import cz.jakvitov.psservice.controllers.support_objects.UserRegisterInfo;
import cz.jakvitov.psservice.exceptions.LoginFailedException;
import cz.jakvitov.psservice.persistence.entity.PsUser;
import cz.jakvitov.psservice.services.serviceimpl.PsUserServiceImpl;
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

    @PostMapping("/register")
    public PsUser registerPsUser(@RequestBody UserRegisterInfo registerInfo){
        PsUser user = psUserService.fillPsUser(registerInfo.getName(), registerInfo.getPswdHash());
        return psUserService.savePsUser(user);
    }

    @PostMapping("/login")
    @ResponseBody
    public UserLoginInfo verifyLoginInfo(@RequestBody UserLoginInfo loginInfo) {
        try {
            if (psUserService.verifyLoginInfo(loginInfo.getName(), loginInfo.getPswdHash())){
                return loginInfo;
            }
            else {
                throw new LoginFailedException();
            }
        }
        catch (EntityNotFoundException ENFE){
            throw new LoginFailedException(ENFE);
        }
        catch (RuntimeException RE){
            throw new LoginFailedException(RE);
        }
    }

}
