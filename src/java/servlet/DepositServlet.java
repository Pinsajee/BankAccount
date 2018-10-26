/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import model.Account;
import model.History;
import model.controller.AccountJpaController;
import model.controller.HistoryJpaController;

/**
 *
 * @author Student
 */
public class DepositServlet extends HttpServlet {
    
    @PersistenceUnit(unitName = "BankPU")
    EntityManagerFactory emf;
    
    @Resource
    UserTransaction utx;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
         HttpSession session = request.getSession(false);
         if(session == null) {
             getServletContext().getRequestDispatcher("/Login").forward(request, response);
             return;
         }
         
         String deposit = request.getParameter("deposit");
         if(deposit != null && deposit.trim().length() > 0) {
             int depositNum = Integer.valueOf(deposit);
             Account accountSession = (Account) session.getAttribute("user");
             
             if(depositNum > 0 && accountSession != null) {
                 int sum = accountSession.getBalance() + depositNum;
                 accountSession.setBalance(sum);
                 
                 History history = new History();
                 history.setAccountid(accountSession);
                 history.setAmount(depositNum);
                 history.setBalance(sum);
                 history.setCreatedate(new Date());
                 history.setMethod("deposit");
                 
                 HistoryJpaController hisCtrl = new HistoryJpaController(utx, emf);
                 hisCtrl.create(history);
                 
                 List<History> historyFromDB = hisCtrl.findHistoryEntities();
                 List<History> historyFromAccount = new ArrayList<>();
                 
                 for (History h : historyFromDB) {
                     if(h.getAccountid().getAccountid() == accountSession.getAccountid()) {
                         historyFromAccount.add(h);
                     }
                     accountSession.setHistoryList(historyFromAccount);
                 }
                 AccountJpaController accCtrl = new AccountJpaController(utx, emf);
                 accCtrl.edit(accountSession);
                 getServletContext().getRequestDispatcher("/MyAccount.jsp").forward(request, response);
                 return;
             }
         }
         getServletContext().getRequestDispatcher("/Deposit.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(DepositServlet.class.getName()).log(Level.SEVERE, null, ex);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(DepositServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
