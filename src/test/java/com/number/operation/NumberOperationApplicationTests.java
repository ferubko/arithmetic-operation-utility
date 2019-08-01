package com.number.operation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;

import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class NumberOperationApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void validInputData_test() throws Exception {
        MediaType textPlainUtf8 = new MediaType(MediaType.APPLICATION_JSON_UTF8, Charset.forName("UTF-8"));
        String request = "{\"firstElement\": 3, \"secondElement\" : 3}";
        mockMvc.perform(MockMvcRequestBuilders.post("/api/plus")
                .content(request)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result", is(6)))
                .andExpect(MockMvcResultMatchers.content().contentType(textPlainUtf8));
    }

    @Test
    public void emptyInputData_test() throws Exception {
        MediaType textPlainUtf8 = new MediaType(MediaType.APPLICATION_JSON_UTF8, Charset.forName("UTF-8"));
        String request = "{\"firstElement\": \"\", \"secondElement\" : 3}";
        mockMvc.perform(MockMvcRequestBuilders.post("/api/plus")
                .content(request)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.jsonPath("$.error", is("firstElement is null")))
                .andExpect(MockMvcResultMatchers.content().contentType(textPlainUtf8));
    }

    @Test
    public void incorrectInputData_test() throws Exception {
        MediaType textPlainUtf8 = new MediaType(MediaType.APPLICATION_JSON_UTF8, Charset.forName("UTF-8"));
        String request = "{\"firstElement\": \"S\", \"secondElement\" : 3}";
        mockMvc.perform(MockMvcRequestBuilders.post("/api/plus")
                .content(request)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.jsonPath("$.error", is("Invalid value of firstElement")))
                .andExpect(MockMvcResultMatchers.content().contentType(textPlainUtf8));
    }
}
