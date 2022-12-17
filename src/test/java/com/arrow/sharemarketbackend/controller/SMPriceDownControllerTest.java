package com.arrow.sharemarketbackend.controller;

import com.arrow.sharemarketbackend.model.RequestShareModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SMPriceDownControllerTest {
    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected ObjectMapper objectMapper;

    private RequestShareModel requestShareModel;

    @Test
    public void givenQuantity_whenCheckForQuantity_thenReturnPrice() throws Exception {
        requestShareModel = new RequestShareModel(42,438.0,421.6,
                "Tata Motors",428.0 , 66);
        ResultActions response = mockMvc.perform(get("/sharemarket/priceByQuantity")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(requestShareModel)));
        response.andExpect(status().isOk())
                .andDo(print());
    }
}
