package cz.jakvitov.psservice.controllers;

import cz.jakvitov.psservice.persistence.entity.PsUser;
import cz.jakvitov.psservice.services.serviceimpl.PsUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

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
    public PsUser getUserByIdRequest(@PathVariable Long id){
        try {
            return psUserService.getPsUserById(id);
        }
        catch (EntityNotFoundException enfe){
            throw new org.springframework.web.server.ResponseStatusException(HttpStatus.NOT_FOUND, enfe.getMessage());
        }
    }
}
