package cz.jakvitov.psservice.services.serviceimpl;

import cz.jakvitov.psservice.persistence.entity.PsPost;
import cz.jakvitov.psservice.persistence.entity.PsPostComment;
import cz.jakvitov.psservice.persistence.entity.PsTopic;
import cz.jakvitov.psservice.persistence.repo.PsPostRepository;
import cz.jakvitov.psservice.services.service.PsPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * @Author Jakub Vítovec
 *  <h1>Service implementation for ps_post</h1>
 */

@Service
public class PsPostServiceImpl implements PsPostService {

    @Autowired
    PsPostRepository psPostRepository;


    @Override
    public PsPost getPsPostById(Long id) {
        return psPostRepository.findById(id).orElseThrow(() -> (new EntityNotFoundException("Post not found!")));
    }

    @Override
    public boolean deletePsPostById(Long id) {
        psPostRepository.deleteById(id);
        return true;
    }

    @Override
    public PsPost changePostText(Long id, String replacement) {
        psPostRepository.updatePostText(id, replacement);
        return getPsPostById(id);
    }

    @Override
    public PsTopic getPsPostTopic(Long id) {
        return null;
    }

    @Override
    public List<PsPostComment> getPostComments(Long id) {
        return null;
    }

    @Override
    public List<PsPost> getAllPsPosts() {
        return null;
    }

    @Override
    public void savePsPost(PsPost post){
        this.psPostRepository.save(post);
    }
}
