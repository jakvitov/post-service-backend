package cz.jakvitov.psservice.controllers.entity_controllers;

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

}
