/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package locacaoDVDs.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import locacaoDVDs.DAO.AtorDAO;
import locacaoDVDs.Entidades.Ator;
import java.sql.SQLException;
import jakarta.servlet.RequestDispatcher;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import locacaoDVDs.Entidades.Erro;

/**
 *
 * @author nicho
 */
@WebServlet(name = "AtorServlet", urlPatterns = {"/processaAtor"})
public class AtorServlet extends HttpServlet {

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
        String url = "/processaAtor" ;
        String acao = request.getParameter("acao") ;
        AtorDAO dao = null ;
        RequestDispatcher disp = null ;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        try{
            dao = new AtorDAO();
            
            if (acao.equals("inserir")) {
                
                String nome = request.getParameter("nome") ;
                String sobrenome = request.getParameter("sobrenome") ;
                String data = request.getParameter("data") ;
                
                Ator a = new Ator() ;
                
                
                if (Character.isUpperCase(nome.charAt(0)) && Character.isUpperCase(sobrenome.charAt(0)) && data!=null){
                    a.setNome(nome);
                    a.setSobrenome(sobrenome);
                    a.setDataEstreia(Date.valueOf(LocalDate.parse(data, dtf)));
                    System.out.println(a.toString());

                    dao.salvar(a);

                    disp = request.getRequestDispatcher("/formularios/Atores/listagem.jsp");
                } else {
                    
                    Erro er = new Erro() ;
                    er.setProcessa(url);
                    er.setCaminho("/formularios/Atores/novo.jsp");
                    
                    if (Character.isLowerCase(nome.charAt(0))){
                     
                        er.setMensagem("O nome desse Ator/Atriz não é Válido");

                        
                    } else if (Character.isLowerCase(sobrenome.charAt(0))) {
                        
                        er.setMensagem("O sobrenome desse Ator/Atriz não é Válido");
   
                    } else if (data == null){
                        er.setMensagem("Uma data de Estreia precisa ser atribuida");
                    } else {
                        
                        er.setMensagem("a data de estreia desse Ator/Atriz não é Válida");
                        
                    }
                    request.setAttribute("erro", er);
                    disp = request.getRequestDispatcher("/error.jsp" );
                        
                }
                
            } else if (acao.equals("alterar")) {
                
                int id = Integer.parseInt(request.getParameter("id")) ;
                String nome = request.getParameter("nome") ;
                String sobrenome = request.getParameter("sobrenome") ;
                String data = request.getParameter("data") ;
                
                Ator a = new Ator() ;
                
                if (Character.isUpperCase(nome.charAt(0)) && Character.isUpperCase(sobrenome.charAt(0)) && data != null){
                    a.setId(id);
                    a.setNome(nome);
                    a.setSobrenome(sobrenome);
                    a.setDataEstreia(Date.valueOf(LocalDate.parse(data, dtf)));
                    System.out.println(a.toString());

                    dao.atualizar(a);

                    disp = request.getRequestDispatcher("/formularios/Atores/listagem.jsp");
                } else {
                    
                    Erro er = new Erro() ;
                    er.setProcessa(url);
                    er.setId(id);
                    er.setCaminho("/formularios/Atores/alterar.jsp");
                    
                    if (Character.isLowerCase(nome.charAt(0))){
                    
                        er.setMensagem("O nome desse Ator/Atriz não é Válido");

                        request.setAttribute("erro", er);
                        disp = request.getRequestDispatcher("/error.jsp" );
                        
                    } else if (Character.isLowerCase(sobrenome.charAt(0))) {
                        
                        er.setMensagem("O sobrenome desse Ator/Atriz não é Válido");

                        request.setAttribute("erro", er);
                        disp = request.getRequestDispatcher("/error.jsp" );
                        
                    } else {
                        
                        er.setMensagem("a data de estreia desse Ator/Atriz não é Válida");

                        request.setAttribute("erro", er);
                        disp = request.getRequestDispatcher("/error.jsp" );
                        
                    }
                }
                
            } else if (acao.equals("excluir")) {
                
                int id = Integer.parseInt(request.getParameter("id")) ;
                
                Ator a = new Ator() ;
                a.setId(id);
                
                dao.excluir(a);
                
                disp = request.getRequestDispatcher(
                    "/formularios/Atores/listagem.jsp" );
                
            } else if (acao.equals("erro")) {
                    
                    String caminho = request.getParameter("caminho") ;
                    
                    Ator a = null ;
                    
                    if (caminho.equals("/formularios/Genero/alterar.jsp")){
                        int id = Integer.parseInt(request.getParameter("id"));
                        a = dao.selecionarPorID(id) ;
                        request.setAttribute("Ator", a);
                    }
                    
                    disp = request.getRequestDispatcher(caminho) ;
                    
            } else {
                
                int id = Integer.parseInt(request.getParameter("id")) ;
                Ator e = dao.selecionarPorID(id) ;
                
                request.setAttribute("Ator", e);
                
                if (acao.equals("prepararAlteracao")) {
                    disp = request.getRequestDispatcher(
                    "/formularios/Atores/alterar.jsp" );
                } else if (acao.equals("prepararExclusao")) {
                    disp = request.getRequestDispatcher(
                    "/formularios/Atores/excluir.jsp" );
                }
            }
            
        }catch (SQLException ex) {
            
            ex.printStackTrace();
            
        }finally {
            
            if (dao != null) {
                try{
                    dao.fecharConexao();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            
        }
        
        if (disp != null) {
            disp.forward(request, response);
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
