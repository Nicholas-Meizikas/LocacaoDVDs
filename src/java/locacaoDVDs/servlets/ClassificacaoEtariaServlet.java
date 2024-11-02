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
import locacaoDVDs.DAO.ClassificacaoEtariaDAO;
import locacaoDVDs.Entidades.ClassificacaoEtaria ;
import locacaoDVDs.Entidades.Erro ;
import java.sql.SQLException;
import jakarta.servlet.RequestDispatcher;

/**
 *
 * @author nicho
 */
@WebServlet(name = "ClassificacaoEtariaServlet", urlPatterns = {"/processaCE"})
public class ClassificacaoEtariaServlet extends HttpServlet {

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
        String url = "/processaCE" ;
        String acao = request.getParameter("acao") ;
        ClassificacaoEtariaDAO dao = null ;
        RequestDispatcher disp = null ;
        
        try{
            dao = new ClassificacaoEtariaDAO() ;
            
            if (acao.equals("inserir")) {
                
                String descricao = request.getParameter("descricao") ;
                
                ClassificacaoEtaria cE = new ClassificacaoEtaria() ;
                if(Character.isUpperCase(descricao.charAt(0))){
                    cE.setDescricao(descricao);
                
                    dao.salvar(cE);
                
                    disp = request.getRequestDispatcher("/formularios/classificacaoEtaria/listagem.jsp" );

                } else {
                    Erro er = new Erro() ;
                    
                    er.setProcessa(url);
                    er.setCaminho("/formularios/classificacaoEtaria/novo.jsp");
                    er.setMensagem("A descricao dessa classificação etária não é Válida");
                    
                    request.setAttribute("erro", er);
                    disp = request.getRequestDispatcher("/error.jsp" );
                }
                
            } else if (acao.equals("alterar")) {
                
                int id = Integer.parseInt(request.getParameter("id")) ;
                String descricao = request.getParameter("descricao") ;
                
                ClassificacaoEtaria cE = new ClassificacaoEtaria() ;
                
                if(Character.isUpperCase(descricao.charAt(0))){
                    cE.setId(id);
                    cE.setDescricao(descricao);
                
                    dao.atualizar(cE);
                
                    disp = request.getRequestDispatcher("/formularios/classificacaoEtaria/listagem.jsp" );

                } else {
                    Erro er = new Erro() ;
                    
                    er.setProcessa(url);
                    er.setId(id);
                    er.setCaminho("/formularios/classificacaoEtaria/alterar.jsp");
                    er.setMensagem("A descricao dessa classificação etária não é Válida");
                    
                    request.setAttribute("erro", er);
                    disp = request.getRequestDispatcher("/error.jsp" );
                }
                
                
            } else if (acao.equals("excluir")) {
                
                int id = Integer.parseInt(request.getParameter("id")) ;
                
                ClassificacaoEtaria cE = new ClassificacaoEtaria() ;
                cE.setId(id);
                
                dao.excluir(cE);
                
                disp = request.getRequestDispatcher("/formularios/classificacaoEtaria/listagem.jsp" );
                
            } else if (acao.equals("erro")) {
                    
                    String caminho = request.getParameter("caminho") ;
                    
                    ClassificacaoEtaria g = null ;
                    
                    if (caminho.equals("/formularios/classificacaoEtaria/alterar.jsp")){
                        int id = Integer.parseInt(request.getParameter("id"));
                        g = dao.selecionarPorID(id) ;
                        request.setAttribute("ClassificacaoEtaria", g);
                    }
                    
                    disp = request.getRequestDispatcher(caminho) ;
                    
            } else {
                
                int id = Integer.parseInt(request.getParameter("id")) ;
                ClassificacaoEtaria e = dao.selecionarPorID(id) ;
                
                request.setAttribute("ClassificacaoEtaria", e);
                
                if (acao.equals("prepararAlteracao")) {
                    disp = request.getRequestDispatcher(
                    "/formularios/classificacaoEtaria/alterar.jsp" );
                } else if (acao.equals("prepararExclusao")) {
                    disp = request.getRequestDispatcher(
                    "/formularios/classificacaoEtaria/excluir.jsp" );
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
