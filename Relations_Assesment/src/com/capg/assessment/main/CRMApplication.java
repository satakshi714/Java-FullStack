package com.capg.assessment.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capg.assessment.entity.Address;
import com.capg.assessment.service.*;
import com.capg.assessment.service.impl.*;
import com.capg.assessment.util.JPAUtil;

public class CRMApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CustomerService customerService = new CustomerServiceImpl();
        LeadService leadService = new LeadServiceImpl();
        ProductService productService = new ProductServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        TicketService ticketService = new TicketServiceImpl();
        ReportService reportService = new ReportServiceImpl();

        while (true) {

            System.out.println("\n===== CRM SALES MANAGEMENT SYSTEM =====");
            System.out.println("1. Register Customer");
            System.out.println("2. Add Address to Customer");
            System.out.println("3. Create Lead");
            System.out.println("4. Assign Lead to Employee");
            System.out.println("5. Convert Lead to Customer");
            System.out.println("6. Add Product");
            System.out.println("7. Place Order");
            System.out.println("8. Raise Support Ticket");
            System.out.println("9. View Employee Performance");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    customerService.registerCustomer(name, email, phone);
                    break;

                case 2:
                    System.out.print("Enter Customer ID: ");
                    Long custId = sc.nextLong();
                    sc.nextLine();

                    System.out.print("Enter Street: ");
                    String street = sc.nextLine();

                    System.out.print("Enter City: ");
                    String city = sc.nextLine();

                    System.out.print("Enter State: ");
                    String state = sc.nextLine();

                    System.out.print("Enter Zip Code: ");
                    String zip = sc.nextLine();

                    Address address = new Address(street, city, state, zip);
                    customerService.addAddressToCustomer(custId, address);
                    break;

                case 3:
                    System.out.print("Enter Lead Name: ");
                    String leadName = sc.nextLine();

                    System.out.print("Enter Source: ");
                    String source = sc.nextLine();

                    System.out.print("Enter Contact Info: ");
                    String contact = sc.nextLine();

                    leadService.createLead(leadName, source, contact);
                    break;

                case 4:
                    System.out.print("Enter Lead ID: ");
                    Long leadId = sc.nextLong();

                    System.out.print("Enter Employee ID: ");
                    Long empId = sc.nextLong();

                    leadService.assignLeadToEmployee(leadId, empId);
                    break;

                case 5:
                    System.out.print("Enter Lead ID to convert: ");
                    Long convertLeadId = sc.nextLong();

                    leadService.convertLeadToCustomer(convertLeadId);
                    break;

                case 6:
                    System.out.print("Enter Product Name: ");
                    String productName = sc.nextLine();

                    System.out.print("Enter Product Price: ");
                    double price = sc.nextDouble();

                    productService.addProduct(productName, price);
                    break;

                case 7:
                    System.out.print("Enter Customer ID: ");
                    Long customerId = sc.nextLong();

                    System.out.print("Enter number of products: ");
                    int count = sc.nextInt();

                    List<Long> productIds = new ArrayList<>();
                    for (int i = 0; i < count; i++) {
                        System.out.print("Enter Product ID " + (i + 1) + ": ");
                        productIds.add(sc.nextLong());
                    }

                    orderService.placeOrder(customerId, productIds);
                    break;

                case 8:
                    System.out.print("Enter Order ID: ");
                    Long orderId = sc.nextLong();
                    sc.nextLine();

                    System.out.print("Enter Issue Description: ");
                    String issue = sc.nextLine();

                    ticketService.raiseTicket(orderId, issue);
                    break;

                case 9:
                    System.out.print("Enter Employee ID: ");
                    Long employeeId = sc.nextLong();

                    reportService.getEmployeePerformance(employeeId);
                    break;

                case 10:
                    System.out.println("Exiting application...");
                    sc.close();
                    JPAUtil.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}