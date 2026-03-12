package com.example.PatientService.controller;

import com.example.PatientService.model.Patient;
import com.example.PatientService.service.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PatientController.class)
public class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientService patientService;

    @Autowired
    private ObjectMapper objectMapper;

    // Helper method to create a sample female patient
    private Patient getSampleFemalePatient() {
        return new Patient(
                "1",
                "Jane",
                "Doe",
                LocalDate.of(1992, 5, 20),
                "0987654321",
                "jane.doe@example.com",
                "Female"
        );
    }

    @Test
    void testGetAllPatients() throws Exception {
        List<Patient> patients = List.of(getSampleFemalePatient());
        Mockito.when(patientService.getAllPatients()).thenReturn(patients);

        mockMvc.perform(get("/api/patients"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("Jane"))
                .andExpect(jsonPath("$[0].gender").value("Female"));
    }

    @Test
    void testGetPatientById() throws Exception {
        Patient patient = getSampleFemalePatient();
        Mockito.when(patientService.getPatientById("1")).thenReturn(Optional.of(patient));

        mockMvc.perform(get("/api/patients/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Jane"))
                .andExpect(jsonPath("$.gender").value("Female"));
    }

    @Test
    void testGetPatientById_NotFound() throws Exception {
        Mockito.when(patientService.getPatientById("2")).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/patients/2"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testAddPatient() throws Exception {
        Patient inputPatient = getSampleFemalePatient();
        inputPatient.setId(null);  // simulate client input without id

        Patient savedPatient = getSampleFemalePatient();

        Mockito.when(patientService.addPatient(any(Patient.class))).thenReturn(savedPatient);

        mockMvc.perform(post("/api/patients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputPatient)))
                .andExpect(status().isCreated())   // 201 Created
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.firstName").value("Jane"))
                .andExpect(jsonPath("$.gender").value("Female"));
    }

    @Test
    void testUpdatePatient() throws Exception {
        Patient updatedPatient = getSampleFemalePatient();
        updatedPatient.setFirstName("Janet");

        Mockito.when(patientService.updatePatient(eq("1"), any(Patient.class))).thenReturn(updatedPatient);

        mockMvc.perform(put("/api/patients/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedPatient)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Janet"));
    }

    @Test
    void testDeletePatient() throws Exception {
        Mockito.doNothing().when(patientService).deletePatient("1");

        mockMvc.perform(delete("/api/patients/1"))
                .andExpect(status().isNoContent());
    }
}
