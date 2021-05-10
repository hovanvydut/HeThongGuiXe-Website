/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hovanvy.app.parking_package.controllers;

import hovanvy.app.parking_package.services.ParkingPackageService;
import hovanvy.app.parking_package.services.ParkingPackageServiceImpl;
import hovanvy.common.enums.PathJsp;
import hovanvy.entity.ParkingPackage;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hovanvydut
 */

@WebServlet(urlPatterns = {"/package-list"}, name = "ParkingPackageServlet")
public class ParkingPackageServlet extends HttpServlet {
    
    private final ParkingPackageService parkingPackageService = new ParkingPackageServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        ParkingPackage p1 = new ParkingPackage();
//        p1.setName("SV30");
//        p1.setDescription("Giá 30k dùng trong 30 ngày dành riêng cho sinh viên BK");
//        p1.setDuration(30);
//        p1.setPrice(30000);
//        p1.setVisible(true);
//        
//        ParkingPackage p2 = new ParkingPackage();
//        p2.setName("SV20");
//        p2.setDescription("Giá 20k dùng trong 20 ngày dành riêng cho sinh viên BK");
//        p2.setDuration(20);
//        p2.setPrice(20000);
//        p2.setVisible(true);
//        
//        ParkingPackage p3 = new ParkingPackage();
//        p3.setName("SV10");
//        p3.setDescription("Giá 10k dùng trong 10 ngày dành riêng cho sinh viên BK");
//        p3.setDuration(10);
//        p3.setPrice(10000);
//        p3.setVisible(true);
//        
//        this.parkingPackageService.saveParkingPackage(p1);
//        this.parkingPackageService.saveParkingPackage(p2);
//        this.parkingPackageService.saveParkingPackage(p3);
        
        List<ParkingPackage> parkingPackages = this.parkingPackageService.findAllParkingPackages();
        
        request.setAttribute("parkingPackages", parkingPackages);
        response.setContentType("text/html");
        RequestDispatcher rd = 
                request.getRequestDispatcher(PathJsp.PACKAGE_LIST.getPath());
        
        rd.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}