package com.arthur.takeda.icomida.telemetry.demo.integration;

import com.arthur.takeda.icomida.telemetry.demo.controller.PositionLogController;
import com.arthur.takeda.icomida.telemetry.demo.service.PositionLogService;
import com.arthur.takeda.icomida.telemetry.demo.testFactory.PositionLogTestFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PositionLogController.class)
public class PositionLogIntTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PositionLogService positionLogService;

    private String urlTemplate = "/position_log/post";

    @Test
    public void testPositionLogPostWithAllArguments() throws Exception{
        String json = "{ \"latitude\":-90, \"longitude\":180, \"battery\": 50, \"deliverymanId\": 2 }";
        Mockito.when(positionLogService.save(new PositionLogTestFactory().positionLogDTO(1l))).thenReturn(1l);
        mvc.perform( MockMvcRequestBuilders
                .post(urlTemplate)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }

    @Test
    public void testPositionLogPostWithAllArgumentsButLatitude() throws Exception {
        String json = "{ \"longitude\":180, \"battery\": 50, \"deliverymanId\": 2 }";
        Mockito.when(positionLogService.save(new PositionLogTestFactory().positionLogDTO(1l))).thenReturn(1l);
        MvcResult result = mvc.perform( MockMvcRequestBuilders
                .post(urlTemplate)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();
        Assertions.assertEquals("{\"latitude\":\"Informe a latitude!\"}", result.getResponse().getContentAsString());
    }

    @Test
    public void testPositionLogPostWithLatitudePastMaxValue() throws Exception {
        String json = "{ \"latitude\":91, \"longitude\":180, \"battery\": 50, \"deliverymanId\": 2 }";
        Mockito.when(positionLogService.save(new PositionLogTestFactory().positionLogDTO(1l))).thenReturn(1l);
        MvcResult result = mvc.perform( MockMvcRequestBuilders
                .post(urlTemplate)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();

        Assertions.assertEquals("{\"latitude\":\"must be less than or equal to 90\"}", result.getResponse().getContentAsString());
    }

    @Test
    public void testPositionLogPostWithLatitudePastMinimumValue() throws Exception {
        String json = "{ \"latitude\":-91, \"longitude\":180, \"battery\": 50, \"deliverymanId\": 2 }";
        Mockito.when(positionLogService.save(new PositionLogTestFactory().positionLogDTO(1l))).thenReturn(1l);
        MvcResult result = mvc.perform( MockMvcRequestBuilders
                .post(urlTemplate)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();

        Assertions.assertEquals("{\"latitude\":\"must be greater than or equal to -90\"}", result.getResponse().getContentAsString());
    }

    @Test
    public void testPositionLogPostWithAllArgumentsButLongitude() throws Exception {
        String json = "{ \"latitude\":90, \"battery\": 50, \"deliverymanId\": 2 }";
        Mockito.when(positionLogService.save(new PositionLogTestFactory().positionLogDTO(1l))).thenReturn(1l);
        MvcResult result = mvc.perform( MockMvcRequestBuilders
                .post(urlTemplate)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();

        Assertions.assertEquals("{\"longitude\":\"Informe a longitude!\"}", result.getResponse().getContentAsString());
    }

    @Test
    public void testPositionLogPostWithLongitudePastMaxValue() throws Exception {
        String json = "{ \"latitude\":90, \"longitude\":181, \"battery\": 50, \"deliverymanId\": 2 }";
        Mockito.when(positionLogService.save(new PositionLogTestFactory().positionLogDTO(1l))).thenReturn(1l);
        MvcResult result = mvc.perform( MockMvcRequestBuilders
                .post(urlTemplate)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();

        Assertions.assertEquals("{\"longitude\":\"must be less than or equal to 180\"}", result.getResponse().getContentAsString());
    }

    @Test
    public void testPositionLogPostWithLongitudePastMinimumValue() throws Exception {
        String json = "{ \"latitude\":-90, \"longitude\":-181, \"battery\": 50, \"deliverymanId\": 2 }";
        Mockito.when(positionLogService.save(new PositionLogTestFactory().positionLogDTO(1l))).thenReturn(1l);
        MvcResult result = mvc.perform( MockMvcRequestBuilders
                .post(urlTemplate)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();

        Assertions.assertEquals("{\"longitude\":\"must be greater than or equal to -180\"}", result.getResponse().getContentAsString());
    }

    @Test
    public void testPositionLogPostWithAllArgumentsButBattery() throws Exception {
        String json = "{ \"latitude\":90, \"longitude\": 180, \"deliverymanId\": 2 }";
        Mockito.when(positionLogService.save(new PositionLogTestFactory().positionLogDTO(1l))).thenReturn(1l);
        MvcResult result = mvc.perform( MockMvcRequestBuilders
                .post(urlTemplate)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();

        Assertions.assertEquals("{\"battery\":\"Informe a bateria!\"}", result.getResponse().getContentAsString());
    }

    @Test
    public void testPositionLogPostWithBatteryPastMaxValue() throws Exception {
        String json = "{ \"latitude\":90, \"longitude\":180, \"battery\": 101, \"deliverymanId\": 2 }";
        Mockito.when(positionLogService.save(new PositionLogTestFactory().positionLogDTO(1l))).thenReturn(1l);
        MvcResult result = mvc.perform( MockMvcRequestBuilders
                .post(urlTemplate)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();

        Assertions.assertEquals("{\"battery\":\"must be less than or equal to 100\"}", result.getResponse().getContentAsString());
    }

    @Test
    public void testPositionLogPostWithBatteryPastMinimumValue() throws Exception {
        String json = "{ \"latitude\":-90, \"longitude\":-180, \"battery\": 0, \"deliverymanId\": 2 }";
        Mockito.when(positionLogService.save(new PositionLogTestFactory().positionLogDTO(1l))).thenReturn(1l);
        MvcResult result = mvc.perform( MockMvcRequestBuilders
                .post(urlTemplate)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();

        Assertions.assertEquals("{\"battery\":\"must be greater than or equal to 1\"}", result.getResponse().getContentAsString());
    }

    @Test
    public void testPositionLogPostWithAllArgumentsButDeliverymanId() throws Exception {
        String json = "{ \"latitude\":90, \"longitude\": 180, \"battery\": 50 }";
        Mockito.when(positionLogService.save(new PositionLogTestFactory().positionLogDTO(1l))).thenReturn(1l);
        MvcResult result = mvc.perform( MockMvcRequestBuilders
                .post(urlTemplate)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();

        Assertions.assertEquals("{\"deliverymanId\":\"Informe o deliverymanId!\"}", result.getResponse().getContentAsString());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
