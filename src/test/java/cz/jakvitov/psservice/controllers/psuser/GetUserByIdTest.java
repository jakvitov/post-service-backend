package cz.jakvitov.psservice.controllers.psuser;

import cz.jakvitov.psservice.AbstractTest;
import cz.jakvitov.psservice.persistence.entity.PsUser;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
}
