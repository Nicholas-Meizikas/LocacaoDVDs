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
import locacaoDVDs.DAO.DVDDAO;
import locacaoDVDs.Entidades.*;
import java.sql.SQLException;
import java.sql.Date;
import jakarta.servlet.RequestDispatcher;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author nicho
 */
@WebServlet(name = "DVDservlet", urlPatterns = {"/processaDVD"})
public class DVDservlet extends HttpServlet {

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
        String acao = request.getParameter("acao") ;
        DVDDAO dao = null ;
        RequestDispatcher disp = null ;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        try {
            dao = new DVDDAO();
            
            if (acao.equals("inserir")){
                
                String titulo = request.getParameter("titulo") ;
                int anoLancamento = Integer.parseInt(request.getParameter("anoLancamento"));
                int duracao = Integer.parseInt(request.getParameter("duracao"));
                String dataLancamento = request.getParameter("dataLancamento");
                int generoID = Integer.parseInt(request.getParameter("idgenero"));
                int cEID = Integer.parseInt(request.getParameter("idCE"));
                int atorP = Integer.parseInt(request.getParameter("idAtorPrincipal"));
                int atorC = Integer.parseInt(request.getParameter("idAtorCoadjuvante"));
                
                Genero g = new Genero() ;
                g.setId(generoID);
                
                ClassificacaoEtaria cE = new ClassificacaoEtaria();
                cE.setId(cEID);
                
                Ator principal = new Ator() ;
                Ator coad = new Ator() ;
                principal.setId(atorP);
                coad.setId(atorC);
                
                DVD d = new DVD() ;
                d.setTitulo(titulo);
                d.setAnoLancamento(anoLancamento);
                d.setDuracaoMinutos(duracao);
                d.setDataLancamento(Date.valueOf(LocalDate.parse(dataLancamento, dtf)));
                d.setGenero(g);
                d.setEtaria(cE);
                d.setAtorPrincipal(principal);
                d.setAtorCoadjuvante(coad);
                
                dao.salvar(d);
                
                disp = request.getRequestDispatcher("/formularios/DVDs/listagem.jsp" );
                
            } else if (acao.equals("alterar")) {
                
                int DVDid = Integer.parseInt(request.getParameter("id")) ;
                String titulo = request.getParameter("titulo") ;
                int anoLancamento = Integer.parseInt(request.getParameter("anoLancamento"));
                int duracao = Integer.parseInt(request.getParameter("duracao"));
                String dataLancamento = request.getParameter("dataLancamento");
                int generoID = Integer.parseInt(request.getParameter("idgenero"));
                int cEID = Integer.parseInt(request.getParameter("idCE"));
                int atorP = Integer.parseInt(request.getParameter("idAtorPrincipal"));
                int atorC = Integer.parseInt(request.getParameter("idAtorCoadjuvante"));
                
                Genero g = new Genero() ;
                g.setId(generoID);
                
                ClassificacaoEtaria cE = new ClassificacaoEtaria();
                cE.setId(cEID);
                
                Ator principal = new Ator() ;
                Ator coad = new Ator() ;
                principal.setId(atorP);
                coad.setId(atorC);
                
                DVD d = new DVD() ;
                d.setId(DVDid);
                d.setTitulo(titulo);
                d.setAnoLancamento(anoLancamento);
                d.setDuracaoMinutos(duracao);
                d.setDataLancamento(Date.valueOf(LocalDate.parse(dataLancamento, dtf)));
                d.setGenero(g);
                d.setEtaria(cE);
                d.setAtorPrincipal(principal);
                d.setAtorCoadjuvante(coad);
                
                dao.atualizar(d);
                
                disp = request.getRequestDispatcher("/formularios/DVDs/listagem.jsp" );
                
            } else if (acao.equals("excluir")) {
                int id = Integer.parseInt(request.getParameter( "id" ));
                
                DVD d = new DVD();
                
                d.setId( id );
                
                dao.excluir( d );
                
                disp = request.getRequestDispatcher("/formularios/DVDs/listagem.jsp" );
                
            } else {
                int id = Integer.parseInt(request.getParameter( "id" ));
                
                DVD d = dao.selecionarPorID(id);
                request.setAttribute( "DVD", d );
                
                if ( acao.equals( "prepararAlteracao" ) ) {
                    disp = request.getRequestDispatcher("/formularios/DVDs/alterar.jsp" );
                    
                } else if ( acao.equals( "prepararExclusao" ) ) {
                    disp = request.getRequestDispatcher("/formularios/DVDs/excluir.jsp" );
                }

            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (dao != null) {
                try {
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
