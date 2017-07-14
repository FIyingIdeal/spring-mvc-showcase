package org.springframework.samples.mvc.yc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.samples.mvc.AbstractContextControllerTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Created by Administrator on 2017/6/5.
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class GetPostParameterTests extends AbstractContextControllerTests {

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = webAppContextSetup(this.wac).alwaysExpect(status().isOk()).build();
    }

    @Test
    public void getPostParameterMap() throws Exception {
        this.mockMvc.perform(
                post("/post/getParameterMap")
                    .param("name", "postParam")
                    .param("age", "23")
        ).andExpect(content().string("OK"));
    }
}


