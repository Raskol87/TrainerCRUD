/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Trainer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.TrainerServ;

/**
 *
 * @author kyrik
 */
public class TrainerController extends HttpServlet {

    TrainerServ TrService = new TrainerServ();

//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        List trainerList = TrService.getAll();
        request.setAttribute("TrainerList", trainerList);
        switch (request.getParameter("action")) {
            case "view":
                request.getRequestDispatcher("viewTrainers.jsp").
                        forward(request,
                                response);
                break;
            case "update":
                request.getRequestDispatcher("updateTrainers.jsp").forward(
                        request,
                        response);
                break;
            case "delete":
                request.getRequestDispatcher("deleteTrainers.jsp").forward(
                        request,
                        response);
                break;

        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        switch (request.getParameter("action")) {
            case "create":
                Trainer createTrainer = populateBean((Trainer) request.
                        getSession().getAttribute("createTrainer"), request);
                if (TrService.isSimilar(createTrainer)) {
                    request.getRequestDispatcher("process.jsp").include(request,
                                                                        response);
                } else {
                    TrService.create(createTrainer);
                    request.getRequestDispatcher("createSuccess.jsp").include(
                            request,
                            response);
                    request.getSession().removeAttribute("createTrainer");
                }
                break;
            case "forcecreate":
                TrService.create((Trainer) request.
                        getSession().getAttribute("createTrainer"));
                request.getRequestDispatcher("createSuccess.jsp").include(
                        request, response);
                request.getSession().removeAttribute("createTrainer");
                break;
            case "loadupdate":
                request.getRequestDispatcher(
                        "/TrainerCRUDAssignment/updateTrainers?action=update").
                        forward(request, response);
                break;
            case "update":
                TrService.update(
                        TrService.filterBeans(populateBeanWithId(request.
                                getParameterValues("idToBeUp")), populateBeans(
                                              request)));

                response.getWriter().print(
                        "<!DOCTYPE html><html><head><title>Trainer CRUD WELCOME</title><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"></head><body> <div>Entities Succesfully Updated from Database</div><h3>Trainer CRUD</h3><br><nav><a href=\"createTrainer.jsp\">Create Trainer</a><a href=\"/TrainerCRUDAssignment/viewTrainers?action=view\">Read Trainers</a><a href=\"/TrainerCRUDAssignment/updateTrainers?action=update\">Update Trainer</a><a href=\"/TrainerCRUDAssignment/deleteTrainers?action=delete\">Delete Trainer</a></nav></body></html>");
                break;
            case "delete":
                TrService.delete(populateBeanWithId(request.getParameterValues(
                        "idToBeDel")));
                response.getWriter().print(
                        "<!DOCTYPE html><html><head><title>Trainer CRUD WELCOME</title><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"></head><body> <div>Entities Succesfully Deleted from Database</div><h3>Trainer CRUD</h3><br><nav><a href=\"createTrainer.jsp\">Create Trainer</a><a href=\"/TrainerCRUDAssignment/viewTrainers?action=view\">Read Trainers</a><a href=\"/TrainerCRUDAssignment/updateTrainers?action=update\">Update Trainer</a><a href=\"/TrainerCRUDAssignment/deleteTrainers?action=delete\">Delete Trainer</a></nav></body></html>");
                break;

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Controller Servlet to Process Trainer CRUD requests";
    }

    protected Trainer populateBean(Trainer tr, HttpServletRequest req) {

        tr.setFirstName(req.getParameter("firstName"));
        tr.setLastName(req.getParameter("lastName"));
        tr.setSubject(req.getParameter("subject"));
        tr.setTag("KIK control Servlet was here!");
        return tr;
    }

    protected List<Trainer> populateBeans(HttpServletRequest req) {
        List<Trainer> trainerList = new ArrayList();
        String[] ids_s = req.getParameterValues("idTrainer");
        int[] ids = new int[ids_s.length];
        for (int i = 0; i < ids_s.length; i++) {
            ids[i] = Integer.parseInt(ids_s[i]);
        }
        String[] fNames = req.getParameterValues("firstName");
        String[] lNames = req.getParameterValues("lastName");
        String[] subjs = req.getParameterValues("subject");

        for (int i = 0; i < ids.length; i++) {
            trainerList.add(new Trainer(ids[i], fNames[i], lNames[i], subjs[i],
                                        "KIK Servlet Updated Here!"));
        }
        return trainerList;
    }

    protected List<Trainer> populateBeanWithId(String[] ids) {
        List<Trainer> trainerList = new ArrayList();
        for (String id : ids) {
            trainerList.add(new Trainer(Integer.parseInt(id)));
            System.out.println(trainerList);
        }
        return trainerList;
    }

}
