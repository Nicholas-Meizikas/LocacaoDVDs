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
import locacaoDVDs.Entidades.Genero ;
import locacaoDVDs.Entidades.Erro ;
import locacaoDVDs.DAO.GeneroDAO ;
import java.sql.SQLException ;
import jakarta.servlet.RequestDispatcher ;

/**
 *
 * @author nicho
 */
@WebServlet(name = "GeneroServlet", urlPatterns = {"/processaGenero"})
public class GeneroServlet extends HttpServlet {

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
        String url = "/processaGenero";
        String acao = request.getParameter("acao") ;
        GeneroDAO dao = null ;
        RequestDispatcher disp = null ;
        
        try{
            dao = new GeneroDAO() ;
            
            if (acao.equals("inserir")) {
                
                String descricao = request.getParameter("descricao") ;
                Genero g = new Genero() ;
                
                if(Character.isUpperCase(descricao.charAt(0))){
                    g.setDescricao(descricao);
                    
                    System.out.println(g.toString());
                    dao.salvar(g);

                    disp = request.getRequestDispatcher("/formularios/Genero/listagem.jsp" );
                } else {
                    Erro er = new Erro() ;
                    
                    er.setProcessa(url);
                    er.setCaminho("/formularios/Genero/novo.jsp");
                    er.setMensagem("A descricao desse genero não é Válida");
                    
                    request.setAttribute("erro", er);
                    disp = request.getRequestDispatcher("/error.jsp" );
                }
                
            } else if (acao.equals("alterar")) {
                
                int id = Integer.parseInt(request.getParameter("id")) ;
                String descricao = request.getParameter("descricao") ;
                
                Genero g = new Genero() ;
                g.setId(id);
                
                if(Character.isUpperCase(descricao.charAt(0))){
                    g.setDescricao(descricao);

                    dao.atualizar(g);

                    disp = request.getRequestDispatcher("/formularios/Genero/listagem.jsp" );
                } else {
                    Erro er = new Erro() ;
                    
                    er.setProcessa(url);
                    er.setId(id);
                    er.setCaminho("/formularios/Genero/alterar.jsp");
                    er.setMensagem("A descricao desse genero não é Válida");
                    
                    request.setAttribute("erro", er);
                    disp = request.getRequestDispatcher("/error.jsp" );
                }
                
            } else if (acao.equals("excluir")) {
                
                int id = Integer.parseInt(request.getParameter("id")) ;
                
                Genero e = new Genero() ;
                e.setId(id);
                
                dao.excluir(e);
                
                disp = request.getRequestDispatcher("/formularios/Genero/listagem.jsp" );
                
            } else if (acao.equals("erro")) {
                    
                    String caminho = request.getParameter("caminho") ;
                    
                    Genero g = null ;
                    
                    if (caminho.equals("/formularios/Genero/alterar.jsp")){
                        int id = Integer.parseInt(request.getParameter("id"));
                        g = dao.selecionarPorID(id) ;
                        request.setAttribute("genero", g);
                    }
                    
                    disp = request.getRequestDispatcher(caminho) ;
                    
            } else {
                
                int id = Integer.parseInt(request.getParameter("id")) ;
                Genero g = dao.selecionarPorID(id) ;
                
                request.setAttribute("genero", g);
                
                if (acao.equals("prepararAlteracao")) {
                    disp = request.getRequestDispatcher(
                    "/formularios/Genero/alterar.jsp" );
                } else if (acao.equals("prepararExclusao")) {
                    disp = request.getRequestDispatcher(
                    "/formularios/Genero/excluir.jsp" );
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
