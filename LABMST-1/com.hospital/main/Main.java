package com.hospital.main;

import com.hospital.exception.DuplicatePatientException;
import com.hospital.exception.InvalidAgeException;
import com.hospital.exception.PatientNotFoundException;
import com.hospital.patient.Patient;
import com.hospital.service.HospitalService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HospitalService service = new HospitalService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nHospital Patient Record System");
            System.out.println("1. Add Patient");
            System.out.println("2. Display All Patients");
            System.out.println("3. Search Patient by ID");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter Patient ID: ");
                        int id = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter Patient Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter Age: ");
                        int age = Integer.parseInt(scanner.nextLine());
                        if (age < 0 || age > 120) {
                            throw new InvalidAgeException("Invalid age: " + age + ". Age must be between 0 and 120.");
                        }

                        System.out.print("Enter Disease: ");
                        String disease = scanner.nextLine();

                        Patient p = new Patient(id, name, age, disease);
                        service.addPatient(p);
                        System.out.println("Patient record added successfully.");

                    } catch (NumberFormatException e) {
                        System.out.println("Input error: Scientific/non-numeric ID or Age.");
                    } catch (InvalidAgeException | DuplicatePatientException e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    service.displayPatients();
                    break;

                case 3:
                    try {
                        System.out.print("Enter Patient ID to search: ");
                        int searchId = Integer.parseInt(scanner.nextLine());
                        service.searchPatient(searchId);
                    } catch (NumberFormatException e) {
                        System.out.println("Input error: ID must be numeric.");
                    } catch (PatientNotFoundException e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Exiting System...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
