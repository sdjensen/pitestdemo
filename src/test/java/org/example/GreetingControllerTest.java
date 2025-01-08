package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGreet() throws Exception {
        mockMvc.perform(get("/greet"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, Mutation Testing!"));
    }

    @Test
    public void testUpdate() throws Exception {
        mockMvc.perform(put("/greet").content("John Doe"))
                .andExpect(status().isOk());
    }


    @Test
    @Disabled
    public void testUpdateBetter() throws Exception {
        mockMvc.perform(put("/greet").content("John Doe"))
                .andExpect(content().string("Hello John Doe, Mutating Testing!"))
                .andExpect(status().isOk());
    }

}
