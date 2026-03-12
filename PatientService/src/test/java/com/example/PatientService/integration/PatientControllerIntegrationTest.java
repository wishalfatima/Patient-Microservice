package com.example.PatientService.integration;

import com.example.PatientService.model.Patient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PatientControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private Patient createSamplePatient() {
        return new Patient(
                null,
                "Alice",
                "Smith",
                LocalDate.of(1992, 3, 15),
                "9876543210",
                "alice.smith@example.com",
                "Female"
        );
    }

    @Test
    void testAddPatient() throws Exception {
        Patient patient = createSamplePatient();

        mockMvc.perform(post("/api/patients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(patient)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value("Alice"));
    }

    @Test
    void testGetSinglePatient() throws Exception {
        Patient patient = createSamplePatient();

        String response = mockMvc.perform(post("/api/patients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(patient)))
                .andReturn()
                .getResponse()
                .getContentAsString();

        Patient created = objectMapper.readValue(response, Patient.class);

        mockMvc.perform(get("/api/patients/" + created.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("alice.smith@example.com"));
    }

    @Test
    void testGetAllPatients() throws Exception {
        mockMvc.perform(get("/api/patients"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void testUpdatePatient() throws Exception {
        Patient patient = createSamplePatient();

        String response = mockMvc.perform(post("/api/patients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(patient)))
                .andReturn()
                .getResponse()
                .getContentAsString();

        Patient created = objectMapper.readValue(response, Patient.class);
        created.setFirstName("UpdatedAlice");

        mockMvc.perform(put("/api/patients/" + created.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(created)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("UpdatedAlice"));
    }

    @Test
    void testDeletePatient() throws Exception {
        Patient patient = createSamplePatient();

        String response = mockMvc.perform(post("/api/patients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(patient)))
                .andReturn()
                .getResponse()
                .getContentAsString();

        Patient created = objectMapper.readValue(response, Patient.class);

        mockMvc.perform(delete("/api/patients/" + created.getId()))
                .andExpect(status().isOk());
    }
}
