package front.controleur;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import back.bean.Panier;
import back.service.ClientService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import back.service.ProduitService;

/**
 *
 * @author a
 */
//@WebServlet(name = "ClientControler", urlPatterns = "/clientControler")
public class ClientControler extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClientService loginService = new ClientService();
        ProduitService produitService = new ProduitService();

        response.setContentType("text/html;charset=UTF-8");
        //request.getServletPath();
        String user = request.getParameter("username");
        String password = request.getParameter("password");

        if (user != null && password != null) {
            Object[] seCOnnnecter = loginService.seCOnnnecter(user, password);
            System.out.println("seCOnnnecter = " + seCOnnnecter[0]);
            if (seCOnnnecter[1] != null) {
                HttpSession session = request.getSession();
                session.setAttribute("username", user);
                session.setAttribute("password", password);
                session.setAttribute("produits", produitService.findAll());
                session.setAttribute("panier",new Panier());

                request.getRequestDispatcher("view/Produit.jsp").forward(request, response);

            } else {
                request.getRequestDispatcher("view/Login.jsp").forward(request, response);

            }
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
