package com.example.demo;

public class TestRunner {
    
    public static void main(String[] args) {
        try {
            Class<?> testClass = Class.forName("com.example.demo.Login_TestCases");
            Object testInstance = testClass.getDeclaredConstructor().newInstance();
            
            testClass.getMethod("testCase1_ValidLogin").invoke(testInstance);
            testClass.getMethod("testCase2_WrongUsername").invoke(testInstance);
            testClass.getMethod("testCase3_WrongPassword").invoke(testInstance);
            
            ReportGenerator.generateReport();
            System.out.println("Tests completed!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}