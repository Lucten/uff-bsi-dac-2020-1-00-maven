/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author viter
 */
@WebServlet("/alomundo")
public class HelloServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
        String msg = "";
        Calendar cal = Calendar.getInstance();
	System.out.println(cal.getTime());
	int hora = cal.get(Calendar.HOUR_OF_DAY);
        
        String lang = request.getParameter("lang");
        String trat = request.getParameter("trat");
        String gen = request.getParameter("gen");
        
  
        if(lang==null)
            lang = "pt";
        switch(lang){
            case "pt":
                if(!gen.isBlank()){
                    msg = "Olá ";
                }
                else{
                    if(hora < 12 ) {
                            msg =  "Bom dia ";
                    }else if(hora >= 12 && hora < 18) {
                            msg = "Boa Tarde ";
                    }else {
                            msg = "Boa Noite ";
                    }

                }
                switch(trat){
                    case "no":
                        break;
                    case "sr":
                        msg = msg + "Sr. ";
                        break;
                    case "sa":
                        msg = msg + "Sra. ";
                        break;
                }break;
            case "en":
                if(gen == "ge"){
                    msg = "Hello ";
                }
                else{
                    if(hora < 12 ) {
                            msg =  "Good Morning ";
                    }else if(hora >= 12 && hora < 18) {
                            msg = "Good afternoon ";
                    }else {
                            msg = "Good night ";
                    }
                }
                switch(trat){
                    case "no":
                        break;
                    case "sr":
                        msg = msg + "Mr. ";
                        break;
                    case "sa":
                        msg = msg + "Mrs.";
                        break;
                }break;
            case "fr":
                if(gen == "ge"){
                    msg = "Bonjour ";
                }
                else{
                    if(hora < 12 ) {
                            msg =  "Bonjour ";
                    }else if(hora >= 12 && hora < 18) {
                            msg = "Bon après-midi ";
                    }else {
                            msg = "Bonne nuit ";
                    }
                }
                switch(trat){
                    case "no":
                        break;
                    case "sr":
                        msg = msg + "M. ";
                        break;
                    case "sa":
                        msg = msg + "Mme. ";
                        break;
                }break;
             case "es":
                 if(gen == "ge"){
                    msg = "hola ";
                }
                else{
                    if(hora < 12 ) {
                            msg =  "Buenos dias ";
                    }else if(hora >= 12 && hora < 18) {
                            msg = "Buenas tardes ";
                    }else {
                            msg = "Buenas noches ";
                    }
                 }
                switch(trat){
                    case "no":
                        break;
                    case "sr":
                        msg = msg + "Señor. ";
                        break;
                    case "sa":
                        msg = msg + "Sra. ";
                        break;
                }
                break;
             case "it":
                  if(gen == "ge"){
                    msg = "Ciao ";
                }
                else{
                    if(hora < 12 ) {
                            msg =  "Buongiorno ";
                    }else if(hora >= 12 && hora < 18) {
                            msg = "Buon pomeriggio ";
                    }else {
                            msg = "Buona notte ";
                    }
                  }
                switch(trat){
                    case "no":
                        break;
                    case "sr":
                        msg = msg + "Sig. ";
                        break;
                    case "sa":
                        msg = msg + "Sig.ra. ";
                        break;
                }break;
            case "de":
                 if(gen == "ge"){
                    msg = "Hallo ";
                }
                else{
                    if(hora < 12 ) {
                            msg =  "Guten Morgen ";
                    }else if(hora >= 12 && hora < 18) {
                            msg = "Guten tag ";
                    }else {
                            msg = "Gute Nacht ";
                    }
                 }
                switch(trat){
                    case "no":
                        break;
                    case "sr":
                        msg = msg + "Herr. ";
                        break;
                    case "sa":
                        msg = msg + "Herrin. ";
                        break;
                }break;
        }
        
        
        String nome = request.getParameter("nome");

        if(nome==null)
            nome = "Fulano";
        
        msg = msg+nome+"!";

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
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
       String msg = "";
        Calendar cal = Calendar.getInstance();
	System.out.println(cal.getTime());
	int hora = cal.get(Calendar.HOUR_OF_DAY);
        
        String lang = request.getParameter("lang");
        String trat = request.getParameter("trat");
        String gen = request.getParameter("gen");
        
  
        if(lang==null)
            lang = "pt";
        switch(lang){
            case "pt":
                if(gen == "ge"){
                    msg = "Olá ";
                }
                else{
                    if(hora < 12 ) {
                            msg =  "Bom dia ";
                    }else if(hora >= 12 && hora < 18) {
                            msg = "Boa Tarde ";
                    }else {
                            msg = "Boa Noite ";
                    }

                }
                switch(trat){
                    case "no":
                        break;
                    case "sr":
                        msg = msg + "Sr. ";
                        break;
                    case "sa":
                        msg = msg + "Sra. ";
                        break;
                }break;
            case "en":
                if(gen == "ge"){
                    msg = "Hello ";
                }
                else{
                    if(hora < 12 ) {
                            msg =  "Good Morning ";
                    }else if(hora >= 12 && hora < 18) {
                            msg = "Good afternoon ";
                    }else {
                            msg = "Good night ";
                    }
                }
                switch(trat){
                    case "no":
                        break;
                    case "sr":
                        msg = msg + "Mr. ";
                        break;
                    case "sa":
                        msg = msg + "Mrs.";
                        break;
                }break;
            case "fr":
                if(gen == "ge"){
                    msg = "Bonjour ";
                }
                else{
                    if(hora < 12 ) {
                            msg =  "Bonjour ";
                    }else if(hora >= 12 && hora < 18) {
                            msg = "Bon après-midi ";
                    }else {
                            msg = "Bonne nuit ";
                    }
                }
                switch(trat){
                    case "no":
                        break;
                    case "sr":
                        msg = msg + "M. ";
                        break;
                    case "sa":
                        msg = msg + "Mme. ";
                        break;
                }break;
             case "es":
                 if(gen == "ge"){
                    msg = "hola ";
                }
                else{
                    if(hora < 12 ) {
                            msg =  "Buenos dias ";
                    }else if(hora >= 12 && hora < 18) {
                            msg = "Buenas tardes ";
                    }else {
                            msg = "Buenas noches ";
                    }
                 }
                switch(trat){
                    case "no":
                        break;
                    case "sr":
                        msg = msg + "Señor. ";
                        break;
                    case "sa":
                        msg = msg + "Sra. ";
                        break;
                }
                break;
             case "it":
                  if(gen == "ge"){
                    msg = "Ciao ";
                }
                else{
                    if(hora < 12 ) {
                            msg =  "Buongiorno ";
                    }else if(hora >= 12 && hora < 18) {
                            msg = "Buon pomeriggio ";
                    }else {
                            msg = "Buona notte ";
                    }
                  }
                switch(trat){
                    case "no":
                        break;
                    case "sr":
                        msg = msg + "Sig. ";
                        break;
                    case "sa":
                        msg = msg + "Sig.ra. ";
                        break;
                }break;
            case "de":
                 if(gen == "ge"){
                    msg = "Hallo ";
                }
                else{
                    if(hora < 12 ) {
                            msg =  "Guten Morgen ";
                    }else if(hora >= 12 && hora < 18) {
                            msg = "Guten tag ";
                    }else {
                            msg = "Gute Nacht ";
                    }
                 }
                switch(trat){
                    case "no":
                        break;
                    case "sr":
                        msg = msg + "Herr. ";
                        break;
                    case "sa":
                        msg = msg + "Herrin. ";
                        break;
                }break;
        }
        
        
        String nome = request.getParameter("nome");

        if(nome==null)
            nome = "Fulano";
        
        msg = msg+nome+"!";

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
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
