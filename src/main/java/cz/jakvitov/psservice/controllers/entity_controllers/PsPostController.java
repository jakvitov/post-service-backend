package cz.jakvitov.psservice.controllers.entity_controllers;

import cz.jakvitov.psservice.controllers.support_objects.PostReplacementText;
import cz.jakvitov.psservice.persistence.entity.PsPost;
import cz.jakvitov.psservice.services.serviceimpl.PsPostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Jakub Vítovec
 *  <h1>Rest controller for PsPost</h1>
 */

@RestController
@RequestMapping("/post")
public class PsPostController {

    @Autowired
    PsPostServiceImpl psPostService;

    @PutMapping("/{id}/update")
    public PsPost updatePsPostText(@PathVariable Long id, @RequestBody PostReplacementText replacement){
        return psPostService.changePostText(id, replacement.getReplacement());
    }

}
