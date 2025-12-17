package com.example.demo;

import java.io.FileWriter;

public class ReportGenerator {
    private static StringBuilder report = new StringBuilder();

    public static void addToReport(String testCase, String username, String password, String status) {
        report.append("<tr><td>").append(testCase).append("</td><td>").append(username)
              .append("</td><td>").append(password).append("</td><td>").append(status).append("</td></tr>");
    }

    public static void generateReport() {
        try {
            // Always use same filename - will overwrite existing file
            FileWriter writer = new FileWriter("login_test_report.html");
            writer.write("<html><head><title>Login Test Report</title></head><body>");
            writer.write("<h1>Login Test Report</h1>");
            writer.write("<table border='1'><tr><th>Test Case</th><th>Username</th><th>Password</th><th>Status</th></tr>");
            writer.write(report.toString());
            writer.write("</table></body></html>");
            writer.close();
            System.out.println("Report saved: login_test_report.html (overwritten)");
        } catch (Exception e) {
            System.out.println("Error saving report");
        }
    }
}