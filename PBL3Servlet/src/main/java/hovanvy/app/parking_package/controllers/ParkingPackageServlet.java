/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hovanvy.app.parking_package.controllers;

import hovanvy.common.enums.PathJsp;
import hovanvy.core.parking_package.services.ParkingPackageService;
import hovanvy.core.parking_package.services.ParkingPackageServiceImpl;
import hovanvy.core.payment.service.PaymentService;
import hovanvy.core.payment.service.PaymentServiceImpl;
import hovanvy.entity.Customer;
import hovanvy.entity.ParkingPackage;
import hovanvy.entity.Payment;
import hovanvy.util.CustomerUtil;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hovanvydut
 */

@WebServlet(urlPatterns = {"/parking-package/list"}, name = "ParkingPackageServlet")
public class ParkingPackageServlet extends HttpServlet {
    
    private final ParkingPackageService parkingPackageService = new ParkingPackageServiceImpl();
    private final PaymentService paymentService = new PaymentServiceImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Customer loggedCustomer = CustomerUtil.getLoggedInUser(request);
        
        List<ParkingPackage> parkingPackages = this.parkingPackageService.findAllParkingPackages();
        List<Payment> payments = this.paymentService.getAllPayments(loggedCustomer);
        
        for (Payment payment : payments) {
            System.out.println(payment);
        }
        
        request.setAttribute("loggedInCustomer", loggedCustomer);
        request.setAttribute("parkingPackages", parkingPackages);
        request.setAttribute("payments", payments);
        response.setContentType("text/html");
        
        request.getRequestDispatcher(PathJsp.PACKAGE_LIST.getPath()).forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}