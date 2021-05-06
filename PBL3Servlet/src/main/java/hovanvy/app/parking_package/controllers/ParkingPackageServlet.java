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