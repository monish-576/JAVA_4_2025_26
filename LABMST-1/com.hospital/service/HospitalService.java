package com.hospital.service;

import com.hospital.exception.DuplicatePatientException;
import com.hospital.exception.PatientNotFoundException;
import com.hospital.patient.Patient;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HospitalService {
    private static final String FILE_NAME = "patients.txt";
    private List<Patient> patients;

    public HospitalService() {
        patients = new ArrayList<>();
        loadRecords();
    }

    private void loadRecords() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    String disease = data[3];
                    patients.add(new Patient(id, name, age, disease));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading records: " + e.getMessage());
        }
    }

    public void addPatient(Patient p) throws DuplicatePatientException {
        // Check for duplicate ID
        for (Patient patient : patients) {
            if (patient.getPatientId() == p.getPatientId()) {
                throw new DuplicatePatientException("Patient with ID " + p.getPatientId() + " already exists.");
            }
        }

        // Alert for critical patients
        if (p.getAge() > 60 && "Heart Problem".equalsIgnoreCase(p.getDisease())) {
            System.out.println("\nALERT: Priority Patient – Immediate Attention Required");
        }

        patients.add(p);
        saveToFile(p);
    }

    private void saveToFile(Patient p) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(p.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    public void searchPatient(int patientId) throws PatientNotFoundException {
        boolean found = false;
        for (Patient p : patients) {
            if (p.getPatientId() == patientId) {
                p.displayPatient();
                found = true;
                break;
            }
        }
        if (!found) {
            throw new PatientNotFoundException("Patient with ID " + patientId + " not found.");
        }
    }

    public void displayPatients() {
        if (patients.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        System.out.println("\n--- All Patient Records ---");
        for (Patient p : patients) {
            p.displayPatient();
        }
    }
}
