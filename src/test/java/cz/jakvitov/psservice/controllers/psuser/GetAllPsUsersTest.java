package cz.jakvitov.psservice.controllers.psuser;

import cz.jakvitov.psservice.AbstractTest;
import cz.jakvitov.psservice.persistence.entity.PsUser;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author Jakub Vítovec
 *  <p>Test for Rest Api for getAllPsUsersTest method.</p>
 */
public class GetAllPsUsersTest extends AbstractTest {

    @Before
    public void setUpMvc(){
        this.setUp();
    }

    @Test
    public void getAllPsUsersTest() throws Exception {
        final String uri = "/user/all";

        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = result.getResponse().getStatus();
        assertEquals(200, status);
        String json  = result.getResponse().getContentAsString();
        List<PsUser> user = super.mapFromJson(json, List.class);
    }

}
