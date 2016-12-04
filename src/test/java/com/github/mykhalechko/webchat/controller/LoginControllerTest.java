package com.github.mykhalechko.webchat.controller;

import com.github.mykhalechko.webchat.util.ApplicationConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MockServletContext.class, AnnotationConfigWebContextLoader.class, ApplicationConfig.class})
@WebAppConfiguration
public class LoginControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).dispatchOptions(true).build();
    }

    @Test
    public void getLogin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/login"))
                .andExpect(status().isOk())
                .andExpect(model()
                        .attribute("urlpath", "/getLoginLink"));
    }

    @Test
    public void verifyLogin() throws Exception {

        String jsonStr = "{ \"login\": \"1\", \"password\": \"1\" }";
        mockMvc.perform(MockMvcRequestBuilders.post("/verifyLogin")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonStr))
                .andExpect(jsonPath("$.links[0].href", is("http://localhost/chat")));
    }

}
