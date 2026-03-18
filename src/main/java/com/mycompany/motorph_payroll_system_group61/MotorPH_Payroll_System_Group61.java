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
   
    
    //Method 3: To Fetch the Hourly Rate from the Employee Info. File.
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
    Method 4: SSS Deduction: */
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
    
    //Method 5: Philhealth Deduction:
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
    
    //Method 6: Pag-Ibig Deduction:
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
    
    //Method 7: Income Tax/WHT Deduction: 
    public static double computeIncomeTax(double grossMonthlySalary){
        
        double incomeTax;
        double taxableIncomeDeductions = computeSSS(grossMonthlySalary) + 
                                     computePhilHealth(grossMonthlySalary) + 
                                     computePagIbig(grossMonthlySalary);
    
        double taxableIncome = grossMonthlySalary - taxableIncomeDeductions;
             
    
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
        return incomeTax;
    }
    
    //Method 8: Computing all GOVT Deductions:
    public static double computeTotalGovtDeductions(double grossMonthlySalary) {
        double sss = computeSSS(grossMonthlySalary);
        double philHealth = computePhilHealth(grossMonthlySalary);
        double pagIbig = computePagIbig(grossMonthlySalary);
        double tax = computeIncomeTax(grossMonthlySalary);
    
        return sss + philHealth + pagIbig + tax;
    }
    
    //Method 9: Monthly Net Pay Computation:
    public static double computeNetPay(double grossMonthlySalary){
        
        double netPay = grossMonthlySalary - computeTotalGovtDeductions(grossMonthlySalary);
        
        return netPay;
    }
    //Method 10: Displaying Payroll Results in Prescribed Format (as per payroll flow)
    public static void displayPayrollResults(int month, String id, double rate, double h1, double h2) {
        
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
        
        double netSalary1 = h1 * rate;
        
        double netSalary2 = h2 * rate;
               
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
            System.out.println("Gross Salary         : " + "PHP " + netSalary1);
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
    // Method 11: All Employees Loop (New Addition based on feedback 1)
    public static void processAllEmployees(String empPath, java.util.List<String[]> attendanceList) {
        try (BufferedReader br = new BufferedReader(new FileReader(empPath))) {
            br.readLine(); // Skip CSV header
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                // Split data handling potential commas in quotes
                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                String id = data[0];
                String lastName = data[1];
                String firstName = data[2];
                String birthday = data[3];
                double rate = Double.parseDouble(data[18].replace("\"", "").replace(",", "").trim());

                // --- RESTORED HEADER ---
                System.out.println("\n******************************************");
                System.out.println("---Employee Information---");
                System.out.println("Employee #      : " + id);
                System.out.println("Employee Name   : " + lastName + ", " + firstName);
                System.out.println("Birthday        : " + birthday);
                System.out.println("--------------------------");

                // Process June to December for this specific employee
                for (int m = 6; m <= 12; m++) {
                    double h1 = 0, h2 = 0;
                    for (String[] att : attendanceList) {
                        if (att[0].equals(id)) {
                            String[] dParts = att[3].split("/");
                            if (Integer.parseInt(dParts[0]) == m) {
                                double hrs = calculateDailyHours(att[4], att[5]);
                                if (Integer.parseInt(dParts[1]) <= 15) h1 += hrs; else h2 += hrs;
                            }
                        }
                    }
                    displayPayrollResults(m, id, rate, h1, h2);
                }

                // --- RESTORED FOOTER ---
                System.out.println(">>> COMPLETED ALL MONTHS FOR: " + lastName);
                System.out.println("******************************************\n");
            }
        } catch (IOException e) { 
            System.out.println("Error reading employee information file."); 
        }
    }

    // Method 12: Loading Attendance into Array (New Addition based on feedback 2)
    public static java.util.List<String[]> loadAttendance(String path) {
        java.util.List<String[]> list = new java.util.ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine(); 
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) list.add(line.split(","));
            }
        } catch (IOException e) { System.out.println("Error loading attendance."); }
        return list;
    }
    
    //Unit Testing Methods to Test Specific Logics of the Code: (For my own purposes*)
    public static void testAttendanceLogic() { //Test Method 1 for Attendance Logic.
    System.out.println("\n--- Testing Attendance Logic ---");

        // Test A: Exact 8:00 to 17:00 (8 hours work + 1 hour lunch)
        double caseA = calculateDailyHours("8:00", "17:00");
        System.out.println("8:00-17:00: " + (caseA == 8.0 ? "[PASS]" : "[FAIL] (Got " + caseA + ")"));

        // Test B: Grace Period (8:09 to 17:00 should still be 8 hours)
        double caseB = calculateDailyHours("8:09", "17:00");
        System.out.println("8:09-17:00: " + (caseB == 8.0 ? "[PASS]" : "[FAIL]"));

        // Test C: Late (8:11 to 17:00 should be 7.82 hours approx)
        // (17:00 - 8:11) = 8h 49m = 529 mins. 529 - 60 (lunch) = 469 mins. 469/60 = 7.816
        double caseC = calculateDailyHours("8:11", "17:00");
        System.out.println("8:11-17:00: " + (caseC > 7.81 && caseC < 7.82 ? "[PASS]" : "[FAIL]"));
    }
    public static void testDeductionTables() { //Test Method 2 for Deduction Tables.
    System.out.println("\n--- Testing Deduction Tables ---");

        double sampleSalary = 25000.00;

        // SSS Test: At 25k, the contribution should be 1125.00
        double sss = computeSSS(sampleSalary);
        System.out.println("SSS @ 25k: " + (sss == 1125.0 ? "[PASS]" : "[FAIL] (Got " + sss + ")"));

        // PhilHealth Test: 25k * 0.03 / 2 = 375.00
        double ph = computePhilHealth(sampleSalary);
        System.out.println("PhilHealth @ 25k: " + (ph == 375.0 ? "[PASS]" : "[FAIL] (Got " + ph + ")"));

        // Pag-IBIG Test: Should be capped at 100.00
        double pi = computePagIbig(sampleSalary);
        System.out.println("Pag-IBIG @ 25k: " + (pi == 100.0 ? "[PASS]" : "[FAIL]"));
    }
    
    public static void testTaxBrackets() { //Test Method 3 for Tax Brackets (IncomeTax)
        System.out.println("\n--- Testing Tax Brackets ---");

        // Case 1: Low Income (Below 20,832 - should be 0 tax)
        double tax1 = computeIncomeTax(20000.00);
        System.out.println("Tax @ 20k Gross: " + (tax1 == 0 ? "[PASS]" : "[FAIL]"));

        // Case 2: Middle Income (e.g., 30,000 Gross)
        // Est. Taxable: 30,000 - ~1600 (statutory) = ~28,400
        // Tax: (28,400 - 20,833) * 0.20 = ~1,513
        double tax2 = computeIncomeTax(30000.00);
        System.out.println("Tax @ 30k Gross: " + (tax2 > 0 ? "[PASS] (Calculated: " + tax2 + ")" : "[FAIL]"));
    }
    
    public static void testFullMonthlyNetPay() { //Test Method 4 for Calculating Full Monthly Pay (with govt. deductions):
        System.out.println("\n--- Testing Full Monthly Net Pay @ (30k) ---");

        double gross = 30000.00;

        // Calculate each piece using existing deduction methods
        double sss = computeSSS(gross);
        double ph = computePhilHealth(gross);
        double pi = computePagIbig(gross);
        double tax = computeIncomeTax(gross); 

        double totalDeductions = sss + ph + pi + tax;
        double actualNet = gross - totalDeductions;

        // 25,000 - (1,125 + 375 + 100 + 513.4) = 22,886.6
        double expectedNet = 26826.6; 

        System.out.println("Results for 25,000 PHP Gross:");
        System.out.println("SSS: " + sss + " | PhilHealth: " + ph + " | Pag-IBIG: " + pi + " | Tax: " + tax);
        System.out.println("Final Net: " + actualNet);
        
        if (Math.abs(actualNet - expectedNet) < 0.10) {
            System.out.println("[PASS]");
        } else {
            System.out.println("[FAIL] Difference detected. Check your deduction brackets.");
        }
    }
    
    public static void testHighSalaryNetPay() { //Test Method 5 for Calculating High Salary Full Monthly Pay (with govt. deductions):
        System.out.println("\n--- Testing High Salary Net Pay @ (50k) ---");
        double gross = 50000.00;

        double sss = computeSSS(gross);
        double ph = computePhilHealth(gross);
        double pi = computePagIbig(gross);
        double tax = computeIncomeTax(gross);

        double actualNet = gross - (sss + ph + pi + tax);
        double expectedNet = 41852.00; // Target for 50k gross

        System.out.println("Results for 50,000 PHP Gross:");
        System.out.println("SSS: " + sss + " | PH: " + ph + " | PI: " + pi + " | Tax: " + tax);
        System.out.println("Final Net: " + actualNet);

        if (Math.abs(actualNet - expectedNet) < 0.10) {
            System.out.println("[PASS]");
        } else {
            System.out.println("[FAIL] Check your 25% tax bracket logic.");
        }
    }
    
    public static void main(String[] args) {
        
        /**
        System.out.println("=== MOTORPH SYSTEM DIAGNOSTICS ===");
        testAttendanceLogic();
        testDeductionTables();
        testTaxBrackets();
        testFullMonthlyNetPay();
        testHighSalaryNetPay();
        System.out.println("==================================\n");
        **/
        
        //Initializing Variables for Reader/s:
        String empInfo = "resources/MotorPH_Employee_Information.csv";
        String attendanceInfo = "resources/MotorPH_Attendance_Record.csv";
        
        //Attendance File Initialization (Using the New Load Attendance Method 12):
        java.util.List<String[]> allAttendance = loadAttendance(attendanceInfo);
        
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
            System.out.println("1. Process Payroll");
            System.out.println("2. Exit the Program");
            int pStaffMenuOptions = keyboard.nextInt();
            
            switch (pStaffMenuOptions) {
                case 1 -> { 
                    System.out.println("\n---Payroll Processing:----");
                    System.out.println("1. One Employee");
                    System.out.println("2. All Employees");
                    System.out.println("3. Exit");
                    int pStaffSubOptions = keyboard.nextInt(); 
                    keyboard.nextLine(); // Clear buffer

                    switch (pStaffSubOptions) {
                        case 1 -> {
                            System.out.println("Enter Employee Number: ");
                            String inputID = keyboard.nextLine();
                            findAndDisplayEmpInfo(empInfo, inputID);
                            double rate = getHourlyRate(empInfo, inputID);
                                                        
                            if (rate > 0) {
                                for (int m = 6; m <= 12; m++) {
                                    double h1 = 0, h2 = 0;
                                    //Looping through the Attendance list instead of opening the file repeatedly.
                                    for (String[] row : allAttendance) {
                                        if (row[0].equals(inputID)) {
                                            String[] date = row[3].split("/");
                                            int month = Integer.parseInt(date[0]);
                                            int day = Integer.parseInt(date[1]);
                                            if (month == m) {
                                                double hours = calculateDailyHours(row[4], row[5]);
                                                if (day <= 15) h1 += hours; else h2 += hours;
                                            }
                                        }
                                    }
                                    displayPayrollResults(m, inputID, rate, h1, h2);
                                }
                            }
                        } 
                        case 2 -> processAllEmployees(empInfo, allAttendance);
                        case 3 -> System.out.println("Exiting sub-menu...");
                        default -> System.out.println("Invalid selection.");
                    } // End of Sub-Switch
                }   
                case 2 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice, Please Select 1 or 2.");
            } // End of Main Switch

        } else { // Handle incorrect login
            System.out.println("Incorrect Username/Password, Please Try Again.");
        }    
        
        keyboard.close();
    } // End of Main Method          
}
