package com.pluralsight.fundamentals.web;

import com.pluralsight.fundamentals.service.ApplicationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TzaRestController.class)
public class TzaRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ApplicationService applicationService;

    @Test
    public void shouldReturnSuccessfulResponseWithNoApplications() throws Exception {
        mockMvc.perform(get("/tza/applications"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));

        verify(applicationService, times(1)).listApplications();
    }
}
