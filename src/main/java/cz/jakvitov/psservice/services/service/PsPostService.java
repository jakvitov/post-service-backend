package cz.jakvitov.psservice.services.service;

import cz.jakvitov.psservice.persistence.entity.PsPost;
import cz.jakvitov.psservice.persistence.entity.PsPostComment;
import cz.jakvitov.psservice.persistence.entity.PsTopic;

import java.util.List;

/**
 * @Author Jakub Vítovec
 *  <h1>Service interface for PsPost</h1>
 */

public interface PsPostService {

    public PsPost getPsPostById(Long id);

    public boolean deletePsPostById(Long id);

    public PsPost changePostText(Long id, String replacement);

    public PsTopic getPsPostTopic(Long id);

    public List<PsPostComment> getPostComments(Long id);

    public List<PsPost> getAllPsPosts();

    public void savePsPost(PsPost post);

}
