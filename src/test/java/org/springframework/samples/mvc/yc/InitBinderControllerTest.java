package org.springframework.samples.mvc.yc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.samples.mvc.AbstractContextControllerTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class InitBinderControllerTest extends AbstractContextControllerTests {

    private MockMvc mockMvc;

    private static String URI = "/initBinder/{action}";

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(this.wac).alwaysExpect(status().isOk()).build();
    }

    @Test
    public void initBinderTest() throws Exception {
        this.mockMvc.perform(
                post(URI, "dateFormat")
                    .contentType(MediaType.APPLICATION_JSON)
                    //.content("{\"username\":\"yc\", \"email\":\"1\", \"birthday\":\"2017-09-02\"}")
                        .param("username", "yc")
                        .param("email", "1")
                        .param("birthday", "2017-09-02")
                        .accept(MediaType.APPLICATION_JSON))
                        //.accept(MediaType.APPLICATION_XML))
                //返回xml测试，使用xPath表达式验证XML
                .andExpect(xpath("initBinderBean/username/text()").string("yc"))
                //打印response
                //.andDo(print())

                /*.andExpect(jsonPath("$.username").value("yc"))
                .andExpect(jsonPath("$.email").value("1"))*/
                //.andExpect(jsonPath("$.birthday").value("2017/09/02"))
                ;
    }

    @Test
    public void pathVariableDateTest() throws Exception {
        this.mockMvc.perform(
                get(URI, "pathvariable/dateFormat/2017-06-13")
        ).andExpect(content().string("1"));
    }

}
