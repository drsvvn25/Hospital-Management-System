
######  FOR THE CODE GO TO THE MASTER BRANCH

# Hospital-Management-System
1.	Introduction
               
          The Hospital Management System is a Java-based application designed to manage various hospital activities such as maintaining patient records, managing appointments, storing prescriptions, and generating bills. This project utilizes core object-oriented programming concepts and Java features to provide a simple, yet functional management system.

	What to do:-
-	Objective: Develop a system to manage patient records, appointments, and billing in a hospital.

•	Concepts:
-	Inheritance: Different user types (Doctor, Patient, Admin) inherit from a base User class.
-	Inner Class: Implement an inner class for managing prescriptions within the Patient class.
-	Exception Handling: Handle scheduling conflicts and invalid billing information.
-	Threading: Manage simultaneous appointment bookings and patient updates.
-	Collection API: Use List and Map for managing patients, doctors, and appointments.
-	File Handling: Store patient records and billing information in files.
 

2.	 Objectives

1)	Automate Patient Management:
o	Allow easy addition, modification, deletion, and retrieval of patient details such as name, age, gender, disease, and admission status.
o	Maintain patient history and keep records for future references.
2)	Efficient Appointment Handling:
o	Provide functionality to book appointments between patients and available doctors.
o	Prevent overlapping appointments and maintain appointment schedules.
3)	Doctor Information Management:
o	Store and manage doctor details like name, specialization, availability, and years of experience.
o	Help assign patients to appropriate doctors based on specialization.
4)	Prescription Handling:
o	Allow doctors to generate and save prescriptions for patients.
o	Maintain a list of medications and prescribed treatments for each patient.
5)	Billing System:
o	Automatically generate bills based on consultations, medications, and additional services.
o	Ensure accuracy in financial calculations and maintain payment records.
 

6)	Implement Java OOP Concepts:
o	Use inheritance, polymorphism, encapsulation, and abstraction to make the system modular and maintainable.
o	Implement inner classes to handle related data within parent classes.
7)	Use of Java Collection Framework:
o	Manage dynamic lists of patients, doctors, and appointments using ArrayList, HashMap, and other collections.
8)	Exception Handling:
o	Improve system stability by handling input errors and exceptional conditions using try-catch blocks and custom exceptions.
9)	File Handling for Data Persistence:
o	Store all data in text files using Java I/O to ensure that information is not lost after the program is closed.
10)	Multithreading (if applicable):
o	Implement background processes like autosaving, data loading, or timed reminders using threads.
11)	Console-Based Interface:
o	Provide a simple user interface through the command line to allow users to interact with the system.
 

3.	 Modules Used

1)	Patient Management:
-	Allows adding, updating, viewing, and deleting patient records including name, age, gender, and disease details.

2)	Appointment Scheduling:
-	Helps patients schedule appointments with available doctors and allows admins to view all upcoming appointments.

3)	Doctor Management:
-	Stores doctor information like specialization, available times, and experience.

4)	Prescription Handling:
-	Manages and stores prescriptions provided to patients after diagnosis.

5)	Billing System:
-	Generates bills based on consultation fees, medicines, and other charges.

6)	File Handling:
-	All records (patients, doctors, bills) are stored using Java File I/O for persistent storage.
 

4.	System Design

i)	Class Diagram:
 
ii)	Flow Chart:
 


5.	Implementation Details
🧬Inheritance:
•	A base class User is defined with common fields like id and name.
•	Doctor and Patient classes extend User, inheriting shared attributes and behavior.
•	This promotes code reusability and a clear class hierarchy.
🧩 Inner Classes:
•	The Patient class contains an inner class Prescription, used to manage patient-specific prescriptions.
•	This allows Prescription to access Patient’s data directly and logically groups related functionalities.
🛑 Exception Handling:
•	Basic validation is done through try-catch blocks to handle user input errors (e.g., selecting non-existent patient index).
•	Custom messages are shown for errors like duplicate appointment IDs or missing billing data.
•	Prevents the program from crashing due to invalid operations.
🧵 Multithreading:
•	Appointment booking is handled using a separate Thread (AppointmentBooking) to simulate real-time and concurrent booking processes.
•	The run() method adds appointments safely using synchronization to prevent data conflicts.
🗃️ Collection Framework:
•	ArrayList<Patient> and ArrayList<Doctor> are used to store dynamic lists of patients and doctors.

•	

•	HashMap<String, Appointment> is used for fast retrieval and uniqueness of appointments by ID.
•	Makes the system scalable and easy to manipulate data structures.
📁 File Handling:
•	All patient details are stored in patients.txt using FileWriter for persistent storage.
•	Billing records are stored in bills.txt and can be retrieved and displayed using Scanner.
•	This allows the system to preserve data between runs and acts as a simple database alternative.
 

6.	Code

1.	User.java
 
2.	Doctor.java
 
3.	Patient.java
 
 

4.	Appointment.java
 
5.	AppoinmentBooking.java
 
6.	FileManager.java
 

7.	HospitalManagementSystem.java(Main File)
 
 

 
 

7.	Outputs
1.	Adding Patient & Doctor
  
2.	Make the Appointment
 


3.	Viewing the Appointments & Making the Prescription
 
4.	Viewing the Bills From the Text file
 
 

5.	Patient.txt
 
6.	Bills.txt
 
 

8.	Limitations & Future Enhancements

	Limitations:
1.	No GUI Interface
o	The system uses a command-line interface which may not be user-friendly for hospital staff.
2.	No Database Integration
o	Data is stored in .txt files, which can lead to data inconsistency, no encryption, and limited scalability.
3.	Limited Error Handling
o	While basic exception handling is present, it doesn't cover all edge cases or provide detailed feedback.
4.	Single Prescription per Patient
o	Currently, each patient can have only one prescription at a time.
5.	No Login or Authentication System
o	All users (patients, doctors, admin) have unrestricted access to the system without security checks.
6.	Limited Reporting & Search Functionality
o	There is no feature to search for patients/doctors by name or generate detailed reports.

	Future Enhancements:
1.	Graphical User Interface (GUI)
o	Develop a user-friendly GUI using JavaFX or Swing for better usability and navigation.


2.	Database Integration
o	Replace file handling with a database like MySQL or SQLite for efficient and secure data storage.
3.	Advanced Prescription Handling
o	Allow multiple prescriptions per patient with support for tracking history and dosage timelines.
4.	User Authentication System
o	Add login functionality with roles (Admin, Doctor, Patient) and permission-based access.
5.	Search & Filter Features
o	Implement search, filter, and sort capabilities for appointments, patients, and billing data.
6.	Analytics & Reporting
o	Generate detailed reports for hospital management (e.g., most visited doctors, billing summaries).
7.	Cloud Backup & Auto-Save
o	Enable background auto-save and cloud syncing to prevent data loss.
 
