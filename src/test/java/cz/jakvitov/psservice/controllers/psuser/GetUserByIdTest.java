package cz.jakvitov.psservice.controllers.psuser;

import com.fasterxml.jackson.databind.ObjectMapper;
import cz.jakvitov.psservice.AbstractTest;
import cz.jakvitov.psservice.controllers.support_objects.UserLoginInfo;
import cz.jakvitov.psservice.persistence.entity.PsUser;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author Jakub Vítovec
 *  <p>Test for Rest Api for getUserById method. In case of fail,
 *  try checking or resetting test database, for user with id 1</p>
 */

public class GetUserByIdTest extends AbstractTest {

    @Before
    public void setUpMvc(){
        this.setUp();
    }

    @Test
    public void getUserByIdTest() throws Exception {
        //User with this should always be present as one of the testing users
        //if not, reset testing database
        final String uri = "/user/1";

        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = result.getResponse().getStatus();
        assertEquals(200, status);
        String json  = result.getResponse().getContentAsString();
        PsUser user = super.mapFromJson(json, PsUser.class);
    }
}
