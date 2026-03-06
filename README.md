Miletone 2 Payroll System Code Submission (README)

Course and Section: Computer Programming 1 | S1101

Team Details: Group # 61 | Zayed T. Mir

1. Description of the Program:
The MotorPH Payroll System is a Java-based console application designed to automate the payroll processing of MotorPH employees. 
It bridges the gap between raw attendance data and financial reporting by calculating work hours, applying company policies (like grace periods and overtime caps), 
and computing government-mandated deductions based on Philippine law (SSS, PhilHealth, Pag-IBIG, and Withholding Tax).


2. Features & Functionality
This program performs the following core tasks:

    a) Secure Access Control: Features separate login paths for "Employees" (to view personal info) and "Payroll Staff" (to process calculations).

    b) CSV Data Integration: Dynamically reads and parses employee profiles and attendance logs from external .csv files using robust Regex patterns.

    c) Attendance Processing: Automatically applies a 10-minute grace period for late arrivals.
    Enforces a 60-minute mandatory lunch deduction for shifts exceeding 5 hours.
    Caps daily hours at 5:00 PM to prevent unauthorized overtime.
  
    d) Automated Payroll Engine:
    Calculates SSS, PhilHealth, and Pag-IBIG contributions based on the 2023 Contribution Tables (Provided via the MOTORPH Website*).
    Computes taxable income and applies the appropriate BIR Withholding Tax bracket.
  
    e) Detailed Reporting: Generates a formatted Payroll Report showing a breakdown of two cut-offs, total monthly gross, individual deductions, and the final Net Monthly Salary.


3. Requirements:
Software Requirements:

    a) Java Development Kit (JDK): Version 11 or higher.

    b) IDE: Apache NetBeans (or any other supported Java IDE).

    c) File Reader: Any spreadsheet tool (Excel/Google Sheets) to manage the .csv source files.

File Dependencies:

The program requires the following files to be located in the resources directory located in the Root Project Directory:

  MotorPH_Employee_Information.csv: Contains employee ID, names, birthdays, and salary rates.
  MotorPH_Attendance_Record.csv: Contains the logs for Time In and Time Out. 

4. Project Plan:

To Access my revised project plan, please use the link below:
    https://docs.google.com/spreadsheets/d/1fPTG4bzm688KDI2mqLmHbmYak2F_Fi-pk1GwUM_Muq8/edit?usp=sharing
