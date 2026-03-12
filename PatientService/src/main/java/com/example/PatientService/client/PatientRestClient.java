package com.example.PatientService.client;

import com.example.PatientService.model.Patient;
import org.springframework.http.*;
        import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class PatientRestClient {

    private static final String BASE_URL = "http://localhost:8080/patients";
    private static final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        Patient patient = new Patient();
        patient.setFirstName("Sara");
        patient.setLastName("David");
        patient.setDateOfBirth(LocalDate.of(1996, 9, 21));
        patient.setGender("Female");
        patient.setContactNumber("123456789");
        patient.setEmail("Sara123@gmil.com");

        Patient created = createPatient(patient);
        System.out.println("Created patient: " + created.getId());

        List<Patient> all = getAllPatients();
        System.out.println("All patients: " + all.size());
    }

    public static Patient createPatient(Patient patient) {
        return restTemplate.postForObject(BASE_URL, patient, Patient.class);
    }

    public static List<Patient> getAllPatients() {
        ResponseEntity<Patient[]> response = restTemplate.getForEntity(BASE_URL, Patient[].class);
        return Arrays.asList(response.getBody());
    }
    public static void updatePatient(String id, Patient patient) {
        String url = BASE_URL + "/" + id;
        restTemplate.put(url, patient);
    }

    public static void deletePatient(String id) {
        String url = BASE_URL + "/" + id;
        restTemplate.delete(url);
    }
}
