package cz.jakvitov.psservice.controllers;

import cz.jakvitov.psservice.controllers.support_objects.UserLoginInfo;
import cz.jakvitov.psservice.exceptions.LoginFailedException;
import cz.jakvitov.psservice.persistence.entity.PsUser;
import cz.jakvitov.psservice.services.serviceimpl.PsUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * @Author Jakub Vítovec
 *  <h1>Rest controller for PsUser</h1>
 */
@RestController
@RequestMapping("/user")
public class PsUserController {

    @Autowired
    private PsUserServiceImpl psUserService;

    @GetMapping("/{id}")
    public PsUser getPsUserByIdRequest(@PathVariable Long id){
        try {
            return psUserService.getPsUserById(id);
        }
        catch (EntityNotFoundException ENFE){
            throw new org.springframework.web.server.ResponseStatusException(HttpStatus.NOT_FOUND, ENFE.getMessage());
        }
    }

    @GetMapping("/all")
    public List<PsUser> getAllPsUsers(){
        return psUserService.getAllPsUser();
    }

    @DeleteMapping("/{id}")
    public Boolean deletePsUserById(@PathVariable Long id){
        psUserService.deletePsUser(id);
        return true;
    }

    @PostMapping("/register")
    public PsUser registerPsUser(@RequestBody String name, @RequestBody String pswd_hash){
        PsUser user = psUserService.fillPsUser(name, pswd_hash);
        return psUserService.savePsUser(user);
    }

    @PostMapping("/login")
    @ResponseBody
    public UserLoginInfo loginPsUser(@RequestBody UserLoginInfo loginInfo) {
        try {
            psUserService.getPsUserByNamePswd(loginInfo.getName(), loginInfo.getPswdHash());
            return loginInfo;
        }
        catch (EntityNotFoundException ENFE){
            throw new LoginFailedException(ENFE);
        }
    }
}
