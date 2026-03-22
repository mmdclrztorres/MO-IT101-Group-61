Milestone 2 & Terminal Assessment Submission

Presented by: Zayed T. Mir

Computer Programming 1 | S1101

MotorPH Payroll System (Group 61)
---

A Java-based payroll management system designed to display employee information in prescribed format, automate salary calculations, attendance tracking, 
and tax deductions for MotorPH employees. 

This project is coded in Java using the Netbeans IDE.

***Key Features of the Program:***

* **Secure Login**: Role-based access for Employee and Payroll Staff.
* **Dynamic Payroll Calculation**: Automates Gross Pay, SSS, PhilHealth, Pag-IBIG, and Withholding Tax.
* **Attendance Integration**: Processes raw timestamps from CSV records to calculate daily and monthly work hours.
* **Automated Full-Staff Processing**: Generates payroll reports for all employees across multiple months in a single execution.

---

### Code Revisions:

Based on Mentor/IT Coach feedback and performance auditing, the following improvements were implemented:

### 1. The "Load Once" Rule (Memory Optimization)
Previously, the system accessed the `Attendance_Record.csv` file repeatedly within nested loops. For a staff of 34 employees over 7 months, this caused over 200 disk I/O operations.
* **The Update**: Implemented `loadAttendance()`. The system now reads the CSV once into a `List<String[]>` in RAM.


### 2. Method Modularization
To improve readability and maintainability, bulky logic for Processing All Employee Payrolls were moved out of the `main` method.
* **New Method**: `processAllEmployees(String empPath, List<String[]> attendanceList)`. This encapsulates the iteration logic, making the main menu cleaner and easier to debug.

---
## Project Files & Dependencies:
* `MotorPH_Payroll_System_Group61.java`: The core application logic.
* `resources/`: Contains the CSV databases for employees and attendance.
* `UnitTests`: Internal methods used to verify net pay accuracy and attendance methods.
---

**Updated Project Plan File:** https://docs.google.com/spreadsheets/d/1fPTG4bzm688KDI2mqLmHbmYak2F_Fi-pk1GwUM_Muq8/edit?usp=drive_link

**QA Testing File:** https://docs.google.com/spreadsheets/d/1kJ-6WRA5WWhjoQ0XouC17Q__yyPAQu0n6mKgrJ6BxH0/edit?usp=sharing

Tested by: Group 39 - Marjury Seroje
