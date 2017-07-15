package com.cycloneboy;

import com.cycloneboy.controller.UserControllerNew;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by CycloneBoy on 2017/7/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MockServletContext.class})
@WebAppConfiguration
public class UserControllerNewTest {

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception{
        mvc = MockMvcBuilders.standaloneSetup(new UserControllerNew()).build();
    }

    @Test
    public void testUserControllerNew() throws  Exception{
        // 测试UserControllerNew
        RequestBuilder request = null;

        // 1. get 查看一下user列表，应该为空
        request = MockMvcRequestBuilders.get("/users/");
        mvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        // 2. post 提交一个user
        request = MockMvcRequestBuilders.post("/users/")
                    .param("id","1")
                    .param("name", "测试post")
                    .param("age","22");
        mvc.perform(request).andExpect(content().string(equalTo("success")));

        //3. get获取user列表，应该有刚才插入的数据
        request = MockMvcRequestBuilders.get("/users/");
        mvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"测试post\",\"age\":22}]")));

        // 4. put修改id 为1的user
        request = MockMvcRequestBuilders.put("/users/1")
                    .param("name","测试put")
                    .param("age","33");
        mvc.perform(request).andExpect(content().string(equalTo("success")));

        // 5. get一个id 为1的user
        request = MockMvcRequestBuilders.get("/users/1");
        // 这里只返回一个JSon 格式的user
        mvc.perform(request).andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试put\",\"age\":33}")));

        // 6. delete 删除id 为1 的user
        request = MockMvcRequestBuilders.delete("/users/1");
        mvc.perform(request).andExpect(content().string(equalTo("success")));

        // 7. get 查看一下user列表，应该为空
        request = MockMvcRequestBuilders.get("/users/");
        mvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

    }
}
