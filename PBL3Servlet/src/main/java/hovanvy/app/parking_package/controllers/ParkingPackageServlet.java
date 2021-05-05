/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hovanvy.app.parking_package.controllers;

import hovanvy.entity.ParkingPackage;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
    
    private final String packageRegistrationJsp = "/templates/pages/package_registration/package_list.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PBL3_Unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        
        // persitent here
//        ParkingPackage parkingPackage = new ParkingPackage();
//        parkingPackage.setName("SV20K2");
//        parkingPackage.setDesciption("Giá gói 20k áp dụng cho các bạn SV Bách Khoa, 30 ngày kể từ ngày đăng kí gói.");
//        parkingPackage.setDuration(30);
//        parkingPackage.setIs_visible(true);
//        parkingPackage.setPrice(20000);
//        
//        entityManager.persist(parkingPackage);

        List<ParkingPackage> list = entityManager.createQuery("SELECT u FROM ParkingPackage u", ParkingPackage.class).getResultList();
        
        for (ParkingPackage p : list) {
            System.out.println(p);
        }
        
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        
        response.setContentType("text/html");
        
        RequestDispatcher rd = 
                request.getRequestDispatcher(packageRegistrationJsp);
        
        rd.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}