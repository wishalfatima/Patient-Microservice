package com.example.PatientService.service;
import com.example.PatientService.model.Patient;

import com.example.PatientService.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public List<Patient> getAllPatients() {
        return repository.findAll();
    }

    public Optional<Patient> getPatientById(String id) {
        return repository.findById(id);
    }

    public Patient addPatient(Patient patient) {
        return repository.save(patient);
    }

    public Patient updatePatient(String id, Patient updatedPatient) {
        Patient existing = repository.findById(id).orElseThrow();
        existing.setFirstName(updatedPatient.getFirstName());
        existing.setLastName(updatedPatient.getLastName());
        existing.setDateOfBirth(updatedPatient.getDateOfBirth());
        existing.setContactNumber(updatedPatient.getContactNumber());
        existing.setEmail(updatedPatient.getEmail());
        existing.setGender(updatedPatient.getGender());
        return repository.save(existing);
    }

    public void deletePatient(String id) {
        repository.deleteById(id);
    }
}
