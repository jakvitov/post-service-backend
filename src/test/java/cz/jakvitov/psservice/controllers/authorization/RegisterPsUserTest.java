package cz.jakvitov.psservice.controllers.authorization;

import cz.jakvitov.psservice.AbstractTest;
import cz.jakvitov.psservice.controllers.support_objects.UserLoginInfo;
import cz.jakvitov.psservice.persistence.entity.PsUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @Author Jakub Vítovec
 *  <p>Test for Rest Api for registerPsUser method. This test also test the deletePsUserById method.</p>
 */

public class RegisterPsUserTest extends AbstractTest {

    private Long testUserId;

    @Before
    public void setUpMvc(){
        this.setUp();
    }

    @Test
    public void registerPsUserTest() throws Exception {
        final String uri = "/auth/register";
        //Random user generation
        UserLoginInfo loginInfo = new UserLoginInfo(new String(
                "TestUser" + String.valueOf(Math.random() * 1000)).substring(0,14), "TestUserHash");

        String inputLoginInfo = super.mapToJson(loginInfo);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputLoginInfo)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        String responseJson = mvcResult.getResponse().getContentAsString();
        assertEquals(200 , status);

        PsUser user = super.mapFromJson(responseJson, PsUser.class);
        assertEquals(user.getUserNick(), loginInfo.getName());
        assertEquals(user.getUserPswdHash(), loginInfo.getPswdHash());
        this.testUserId = user.getUserId();
    }

    @After
    public void deleteNewUser() throws Exception {
        String deleteUri = "/user/" + this.testUserId;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(deleteUri)).andReturn();
        assertEquals(mvcResult.getResponse().getStatus(), 200);
    }
}
