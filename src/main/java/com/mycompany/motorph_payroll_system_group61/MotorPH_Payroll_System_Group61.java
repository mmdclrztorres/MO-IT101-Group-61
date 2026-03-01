/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.motorph_payroll_system_group61;

/**
 *
 * @author Zayed
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MotorPH_Payroll_System_Group61 {
    
    //Method 1: Displays Employee Information in the prescribed Phase 1 Format.
    public static boolean findAndDisplayEmpInfo(String filePath, String inputEmployeeID) {
        
        boolean empDatafound = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine(); 
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] empData = line.split(",");

                if (empData[0].equals(inputEmployeeID)) {
                    empDatafound = true;
                    System.out.println("\n---Employee Information---");
                    System.out.println("Employee # : " + empData[0]);
                    System.out.println("Employee Name : " + empData[1] + ", " + empData[2]);
                    System.out.println("Birthday : " + empData[3]);
                    System.out.println("--------------------------");
                    break; 
                }
            }

            if (!empDatafound) {
            System.out.println("Employee does not exist.");
            }

        } catch (IOException e) {
        System.out.println("Error reading employee file.");
        } 
        return empDatafound;
    } 
    
    //Method 2: Calculates Daily hours, including Late Deductions.
    public static double calculateDailyHours(String timeIn, String timeOut) {
        try {
            
            DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("H:mm");
            
            LocalTime login = LocalTime.parse(timeIn.trim(), timeFormat);
            LocalTime logout = LocalTime.parse(timeOut.trim(), timeFormat);

            LocalTime workStart = LocalTime.of(8, 0);
            LocalTime graceLimit = LocalTime.of(8, 10);
            LocalTime workEnd = LocalTime.of(17, 0);

            // Cap at 17:00 (No paid overtime)
            if (logout.isAfter(workEnd)) logout = workEnd;

            // Apply 10-minute Grace Period
            if (!login.isAfter(graceLimit)) {
                login = workStart;
            }

            long totalMinutes = Duration.between(login, logout).toMinutes();

            // Deduct 1 hour (60 mins) for lunch break if they worked over 5 hours
            if (totalMinutes > 300) {
                totalMinutes -= 60;
            }

            return Math.max(0, totalMinutes / 60.0);
        } catch (Exception e) {
            return 0; // Return 0 for invalid time formats or missing logs.
        }
    }
    // Method 3: To Fetch the Semi Monthly Rate from Employee Info. File.
    public static double getSemiMonthlyRate(String filePath, String id) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        reader.readLine(); 
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            if (data[0].equals(id)) {
                // Index 17 is the Semi-monthly Rate column
                return Double.parseDouble(data[17].replace("\"", "").replace(",", "").trim());
            }
        }
    } catch (Exception e) {
        return 0;
    }
    return 0;
}
    
    //Method 4: To Fetch the Hourly Rate from the Employee Info. File.
    public static double getHourlyRate(String filePath, String id) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Skips header
            String line;
            while ((line = br.readLine()) != null) {
                // Regex to handle potential commas inside quoted addresses
                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                if (data[0].equals(id)) {
                // Hourly rate is at the last index (18)
                return Double.parseDouble(data[18].replace("\"", "").trim());
                }
            }
        } catch (Exception e) {
            return 0;
        }
            return 0;
    }
    /* Government Deduction Methods:
    Method 5: SSS Deduction: */
    public static double computeSSS(double grossMonthlySalary){
        
        double sssContribution = 0;
        
        if(grossMonthlySalary < 3250) {
           sssContribution = 135.00;
        } else if (grossMonthlySalary <= 3750){
           sssContribution = 157.50; 
        } else if (grossMonthlySalary <= 4250){
           sssContribution = 180.00;
        } else if (grossMonthlySalary <= 4750){
           sssContribution = 202.50;
        } else if (grossMonthlySalary <= 5250){
           sssContribution = 225.00;
        } else if (grossMonthlySalary <= 5750){
           sssContribution = 247.50;
        } else if (grossMonthlySalary <= 6250){
           sssContribution = 270.00;
        } else if (grossMonthlySalary <= 6750){
           sssContribution = 292.50;
        } else if (grossMonthlySalary <= 7250){
           sssContribution = 315.00;
        } else if (grossMonthlySalary <= 7750){
           sssContribution = 337.50;
        } else if (grossMonthlySalary <= 8250){
           sssContribution = 360.00;
        } else if (grossMonthlySalary <= 8750){
           sssContribution = 382.50;
        } else if (grossMonthlySalary <= 9250){
           sssContribution = 405.00;
        } else if (grossMonthlySalary <= 9750){
           sssContribution = 427.50;
        } else if (grossMonthlySalary <= 10250){
           sssContribution = 450.00;
        } else if (grossMonthlySalary <= 10750){
           sssContribution = 472.50;
        } else if (grossMonthlySalary <= 11250){
           sssContribution = 495.00;
        } else if (grossMonthlySalary <= 11750){
           sssContribution = 517.50;
        } else if (grossMonthlySalary <= 12250){
           sssContribution = 540.00;
        } else if (grossMonthlySalary <= 12750){
           sssContribution = 562.50;
        } else if (grossMonthlySalary <= 13250){
           sssContribution = 585.00;
        } else if (grossMonthlySalary <= 13750){
           sssContribution = 607.50;
        } else if (grossMonthlySalary <= 14250){
           sssContribution = 630.00;
        } else if (grossMonthlySalary <= 14750){
           sssContribution = 652.50;
        } else if (grossMonthlySalary <= 15250){
           sssContribution = 675.00;
        } else if (grossMonthlySalary <= 15750){
           sssContribution = 697.50;
        } else if (grossMonthlySalary <= 16250){
           sssContribution = 720.00;
        } else if (grossMonthlySalary <= 16750){
           sssContribution = 742.50;
        } else if (grossMonthlySalary <= 17250){
           sssContribution = 765.00;
        } else if (grossMonthlySalary <= 17750){
           sssContribution = 787.50;
        } else if (grossMonthlySalary <= 18250){
           sssContribution = 810.00;
        } else if (grossMonthlySalary <= 18750){
           sssContribution = 832.50;
        } else if (grossMonthlySalary <= 19250){
           sssContribution = 855.00;
        } else if (grossMonthlySalary <= 19750){
           sssContribution = 877.50;
        } else if (grossMonthlySalary <= 20250){
           sssContribution = 900.00;
        } else if (grossMonthlySalary <= 20750){
           sssContribution = 922.50;
        } else if (grossMonthlySalary <= 21250){
           sssContribution = 945.00;
        } else if (grossMonthlySalary <= 21750){
           sssContribution = 967.50;
        } else if (grossMonthlySalary <= 22250){
           sssContribution = 990.00;
        } else if (grossMonthlySalary <= 22750){
           sssContribution = 1012.50;
        } else if (grossMonthlySalary <= 23250){
           sssContribution = 1035.00;
        } else if (grossMonthlySalary <= 23750){
           sssContribution = 1057.50;
        } else if (grossMonthlySalary <= 24250){
           sssContribution = 1080.00;
        } else if (grossMonthlySalary <= 24750){
           sssContribution = 1102.50; 
        } else if (grossMonthlySalary > 24750) {
            sssContribution = 1125.00;
        }
        return sssContribution;
    }
    
    //Method 6: Philhealth Deduction
    public static double computePhilHealth(double grossMonthlySalary) {
        
        double philHealthPremium;

        if (grossMonthlySalary <= 10000) {
            philHealthPremium = 300 / 2;
        } else if (grossMonthlySalary >= 60000) {
            philHealthPremium = 1800 / 2;
        } else {
            philHealthPremium = (grossMonthlySalary * 0.03) / 2;
        }
        return philHealthPremium;
    }
    
    //Method 7: Pag-Ibig Deduction:
    public static double computePagIbig(double grossMonthlySalary) {
        
        double pagIbigContribution = 0;
        
        if (grossMonthlySalary <= 1500){
            pagIbigContribution = 0.01 * grossMonthlySalary;
        } else if (grossMonthlySalary > 1500) {
            pagIbigContribution = 0.02 * grossMonthlySalary;
            if (pagIbigContribution > 100) {
                pagIbigContribution = 100;
            }
        } 
        return pagIbigContribution;
    } 
    
    //Method 8: Income Tax/WHT Deduction:
    public static double computeIncomeTax(double grossMonthlySalary){
        
        double taxableIncomeDeductions = computeSSS(grossMonthlySalary) + 
                                     computePhilHealth(grossMonthlySalary) + 
                                     computePagIbig(grossMonthlySalary);
    
        double taxableIncome = grossMonthlySalary - taxableIncomeDeductions;
        double incomeTax = 0;     
    
        if(taxableIncome <= 20832){
            incomeTax = 0;
            
        } else if(taxableIncome < 33333){
        incomeTax = (taxableIncome - 20833) * 0.2; 
        } else if (taxableIncome < 66667) {
        incomeTax = 2500 + (taxableIncome - 33333) * 0.25; 
        } else if (taxableIncome < 166667) {
        incomeTax = 10833 + (taxableIncome - 66667) * 0.30; 
        } else if (taxableIncome < 666667) {
        incomeTax = 40833.33 + (taxableIncome - 166667) * 0.32;
        } else {
        incomeTax = 200833.33 + (taxableIncome - 666667) * 0.35; 
        }    
    
        // Returns the result (ensuring no tiny negative floating point errors)
        return Math.max(0, incomeTax);
    }
    
    //Method 9: Computing all GOVT Deductions:
    public static double computeTotalGovtDeductions(double grossMonthlySalary) {
        double sss = computeSSS(grossMonthlySalary);
        double philHealth = computePhilHealth(grossMonthlySalary);
        double pagIbig = computePagIbig(grossMonthlySalary);
        double tax = computeIncomeTax(grossMonthlySalary);
    
        return sss + philHealth + pagIbig + tax;
    }
    
    //Method 10: Monthly Net Pay Computation:
    public static double computeNetPay(double grossMonthlySalary){
        
        double netPay = grossMonthlySalary - computeTotalGovtDeductions(grossMonthlySalary);
        
        return netPay;
    }
    //Method 11: Displaying Payroll Results in Prescribed Format (as per payroll flow)
    public static void displayPayrollResults(int month, String id, double rate, double semiMonthlyRate, double h1, double h2) {
        
        String monthName = switch (month) {
            case 6 -> "JUNE"; 
            case 7 -> "JULY"; 
            case 8 -> "AUGUST";
            case 9 -> "SEPTEMBER"; 
            case 10 -> "OCTOBER"; 
            case 11 -> "NOVEMBER"; 
            case 12 -> "DECEMBER";
            default -> "";
        };
        double gross1 = semiMonthlyRate;
        double netSalary1 = h1 * rate;
        
        double netSalary2 = h2* rate;
               
        double totalMonthlyGross = netSalary1 + netSalary2;
    
        double sss = computeSSS(totalMonthlyGross);
        double philHealth = computePhilHealth(totalMonthlyGross);
        double pagIbig = computePagIbig(totalMonthlyGross);
        double incomeTax = computeIncomeTax(totalMonthlyGross);
        
        double totalGovtDeductions = computeTotalGovtDeductions(totalMonthlyGross);
        double netPay = computeNetPay(totalMonthlyGross);
            
            System.out.println("\n==========================================");
            System.out.println("         PAYROLL REPORT: " + monthName);
            System.out.println("==========================================");
            System.out.println("CUTOFF 1: " + monthName + " 1 to " + monthName + " 15");
            System.out.println("Total Hours Worked   : " + h1 + " hrs");
            System.out.println("Gross Salary         : " + "PHP " + gross1);
            System.out.println("Net Salary           : " + "PHP " + netSalary1);
            System.out.println("------------------------------------------");
            System.out.println("CUTOFF 2: " + monthName + " 16 to END OF MONTH.");
            System.out.println("Total Hours Worked   : " + h2 + " hrs");
            System.out.println("Gross Salary         : " + "PHP " + netSalary2);
            System.out.println("------------------------------------------");
            System.out.println("Monthly Gross Salary : " + "PHP " + totalMonthlyGross);
            System.out.println("------------------------------------------");
            System.out.println("GOVERNMENT DEDUCTIONS:");
            System.out.println("SSS Contribution     : " + "PHP " + sss);
            System.out.println("PhilHealth           : " + "PHP " + philHealth);
            System.out.println("Pag-IBIG             : " + "PHP " + pagIbig);
            System.out.println("Withholding Tax      : " + "PHP " + incomeTax); 
            System.out.println("------------------------------------------");
            System.out.println("TOTAL GOVT DEDUCTIONS : PHP " + totalGovtDeductions);
            System.out.println("NET MONTHLY SALARY    : PHP " + netPay);
            System.out.println("==========================================");
    }
    
    public static void main(String[] args) {
        
        //Initializing Variables for Reader/s:
        String empInfo = "resources/MotorPH_Employee_Information.csv";
        String attendanceInfo = "resources/MotorPH_Attendance_Record.csv";
        
        //Initializing Variables for Employee Information Display:
        String employeeID = "";
        String firstName = "";
        String lastName = "";
        String birthday = "";
                
        Scanner keyboard = new Scanner(System.in);
        
            System.out.println("===MOTORPH PAYROLL SYSTEM===");
            System.out.println("\n-----------Log In-----------");
            System.out.println("Enter Username: ");
            String userName = keyboard.nextLine();
            System.out.println("Enter Password: ");
            String password = keyboard.nextLine();
         
        //If User Logged in Successfully as Employee:
        if("employee".equals(userName) && "12345".equals(password)) {
            
            System.out.println("Employee Logged In Successfully...");
            System.out.println("\n---Welcome Employee!----");
            System.out.println("What would you like to do today?");
            System.out.println("1. Enter Employee Number");
            System.out.println("2. Exit the Program");
            int empMenuOptions = keyboard.nextInt();
            
            keyboard.nextLine();
            switch (empMenuOptions) {
                case 1 -> { //If Employee User Chose Option 1:
                    System.out.println("Enter your Employee Number: ");
                    String inputEmployeeID = keyboard.nextLine();
                    
                    boolean exists = findAndDisplayEmpInfo(empInfo, inputEmployeeID);

                    if (!exists) {    
                    return; // Stop here. Don't calculate hourly rate or payroll.
                    }
                }   
                case 2 -> { //If Employee User Chose Option 2:
                    System.out.println("Exiting the Program. Goodbye!");
                    keyboard.close();
                    return; 
                }
                default -> //This handles cases where user types 3, 4, or any other number
                    System.out.println("Invalid choice, Please Select between 1 and 2 only.");
            }
            
            
        //If User Logged In Successfully as Payroll Staff:
        } else if ("payroll_staff".equals(userName) && "12345".equals(password)) {
            System.out.println("Payroll Staff Logged In Successfully...");
            System.out.println("\n---Welcome Payroll Staff!----");
            System.out.println("What would you like to do today?");
            System.out.println("1. Process Payroll");
            System.out.println("2. Exit the Program");
            int pStaffMenuOptions = keyboard.nextInt();
            
            switch (pStaffMenuOptions) {
                case 1 -> { //If Payroll Staff Chooses Option 1:
                    System.out.println("Proceeding to Process Payroll...");
                    System.out.println("\n---Payroll Processing:----");
                    System.out.println("What would you like to process today?");
                    System.out.println("1. One Employee");
                    System.out.println("2. All Employees");
                    System.out.println("3. Exit the Program.");
                    int pStaffSubOptions = keyboard.nextInt(); 
                    
                    keyboard.nextLine();
                    switch (pStaffSubOptions) {
                        case 1 -> { //Process Payroll for 1 Employee ONLY:
                            System.out.println("Enter Employee Number to Process: ");
                            String inputEmployeeID = keyboard.nextLine();
                            findAndDisplayEmpInfo(empInfo, inputEmployeeID);
                            
                            double hourlyRate = getHourlyRate(empInfo, inputEmployeeID);
                            double semiMonthlyRate = getSemiMonthlyRate(empInfo, inputEmployeeID); 
                            
                            //Calculation for Separating Cutoff1 & 2Hours.
                            if (hourlyRate > 0){
                                for (int m = 6; m <= 12; m++) {
                                    double cutoff1Hours = 0;
                                    double cutoff2Hours = 0;
                                    
                                    try (BufferedReader reader = new BufferedReader(new FileReader(attendanceInfo))) {
                                        reader.readLine();
                                        String line;
                                        while ((line = reader.readLine()) != null) {
                                            if(line.trim().isEmpty()) continue;
                                            String[] data = line.split(",");
                                            
                                            if(data[0].equals(inputEmployeeID)) {
                                                String[] dateParts = data[3].split("/");
                                                int month = Integer.parseInt(dateParts[0]);
                                                int day = Integer.parseInt(dateParts[1]);
                                                
                                                if (month == m) {
                                                    double hours = calculateDailyHours(data[4], data[5]);
                                                    if (day <=15) {
                                                        cutoff1Hours += hours;
                                                    } else {
                                                        cutoff2Hours += hours;
                                                    }
                                                }
                                            }
                                        }
                                        displayPayrollResults(m, inputEmployeeID, hourlyRate, semiMonthlyRate, cutoff1Hours, cutoff2Hours);
                                    
                                    } catch (IOException e) {
                                        System.out.println("Error accessing attendance records for month " + m);
                                        } 
                                } 
                            } else {
                                return;
                            }
                        } case 2 -> { //Process Payroll for ALL Employees:
                            System.out.println("Processing Payroll for ALL Employees (June - December)...");

                            try (BufferedReader empReader = new BufferedReader(new FileReader(empInfo))) {
                                empReader.readLine(); 
                                String empLine;

                                while ((empLine = empReader.readLine()) != null) {
                                if (empLine.trim().isEmpty()) continue;

                                    //Used Regex to split the data (for simplicity).
                                    String[] empData = empLine.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                                    
                                    employeeID = empData[0];
                                    firstName = empData[2];
                                    lastName = empData[1];
                                    birthday = empData[3];
                                    double hourlyRate = Double.parseDouble(empData[18].replace("\"", "").replace(",", "").trim());
                                    double semiMonthlyRate = Double.parseDouble(empData[17].replace("\"", "").replace(",", "").trim());
                                    
                                        //Added this header to match the "One Employee" Payroll Format.
                                        System.out.println("\n******************************************");
                                        System.out.println("---Employee Information---");
                                        System.out.println("Employee #      : " + employeeID);
                                        System.out.println("Employee Name   : " + lastName + ", " + firstName);
                                        System.out.println("Birthday        : " + birthday);
                                        System.out.println("--------------------------");

                                // For each employee, loop through the months
                                for (int m = 6; m <= 12; m++) {
                                    double cutoff1Hours = 0;
                                    double cutoff2Hours = 0;

                                    try (BufferedReader attReader = new BufferedReader(new FileReader(attendanceInfo))) {
                                        attReader.readLine(); 
                                        String attLine;

                                        while ((attLine = attReader.readLine()) != null) {
                                            String[] attData = attLine.split(",");

                                        if (attData[0].equals(employeeID)) {
                                            String[] dateParts = attData[3].split("/");
                                            int month = Integer.parseInt(dateParts[0]);
                                            int day = Integer.parseInt(dateParts[1]);

                                            if (month == m) {
                                                double hours = calculateDailyHours(attData[4], attData[5]);
                                                if (day <= 15) {
                                                    cutoff1Hours += hours;
                                                } else {
                                                    cutoff2Hours += hours;
                                                }
                                            }
                                        }
                                        }
                                    // Recalling the Method that Prints Payroll Information:
                                    displayPayrollResults(m, employeeID, hourlyRate,semiMonthlyRate, cutoff1Hours, cutoff2Hours);

                                    } catch (IOException e) {
                                        System.out.println("Error reading attendance for ID: " + employeeID);
                                    }
                                }
                                    System.out.println(">>> COMPLETED ALL MONTHS FOR: " + lastName);
                                    System.out.println("******************************************\n");
                                }
                            } catch (IOException e) {
                                System.out.println("Error reading employee information file.");
                            }
                        }
                        case 3 -> {
                            System.out.println("Exiting the Program. Goodbye!");
                            keyboard.close();
                            return; 
                        }
                        default ->
                            System.out.println("Invalid choice, Please Select between 1, 2 and 3 only.");
                    }
                }   
                case 2 -> { //If Payroll Staff Chooses Option 2 (Exit Program):
                    System.out.println("Exiting the Program. Goodbye!");
                    keyboard.close();
                    return; 
                }
                default -> //If Payroll Staff Inputs a Wrong Choice:
                    System.out.println("Invalid choice, Please Select between 1 and 2 only.");
            }
            
        } else { //If Credentials Inputted Are Wrong:
            System.out.println("Incorrect Username/Password, Please Try Again.");
        }    
    keyboard.close();
    }       
       
}
