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
                /*
                String nome = request.getParameter( "nome" );
                String sobrenome = request.getParameter( "sobrenome" );
                String dataNascimento = request.getParameter( "dataNascimento");
                String cpf = request.getParameter( "cpf" );
                String email = request.getParameter( "email" );
                String logradouro = request.getParameter( "logradouro" );
                String numero = request.getParameter( "numero" );
                String bairro = request.getParameter( "bairro" );
                String cep = request.getParameter( "cep" );
                int idCidade = Integer.parseInt(request.getParameter( "idCidade" ) );
                */
                DVD d = new DVD();
                /*d.setId( idCidade );
                
                Cliente c = new Cliente();
                c.setNome( nome );
                c.setSobrenome( sobrenome );
                
                if (verificarData(dataNascimento, dtf)){
                    c.setDataNascimento( Date.valueOf(LocalDate.parse( dataNascimento, dtf ) ) );
                    
                } else {
                    String erro = "Data de nascimento ecolhida não pôde ser aceita" ;
                    
                    request.setAttribute("erro", erro);
                    disp = request.getRequestDispatcher("/formularios/clientes/erro.jsp") ;
                }
                
                if (verificarCpf(cpf)) {
                    c.setCpf( cpf );
                } else {
                    String erro = "CPF digitado está fora do formato esperado" ;
                    
                    request.setAttribute("erro", erro);
                    disp = request.getRequestDispatcher("/formularios/clientes/erro.jsp") ;
                }
                if (verificarEmail(email)){
                    c.setEmail( email );
                } else {
                    String erro = "Email digitado está fora do formato esperado" ;
                    
                    request.setAttribute("erro", erro);
                    disp = request.getRequestDispatcher("/formularios/clientes/erro.jsp") ;
                }
                c.setLogradouro( logradouro );
                c.setNumero( numero );
                c.setBairro( bairro );
                if (verificarCep(cep)){
                    c.setCep( cep );
                }else {
                    String erro = "Cep digitado está fora do formato esperado" ;
                    
                    request.setAttribute("erro", erro);
                    disp = request.getRequestDispatcher("/formularios/clientes/erro.jsp") ;
                }
                c.setCidade( d );
                */
                dao.salvar( d );
                
                disp = request.getRequestDispatcher("/formularios/DVDs/listagem.jsp" );
                
            } else if (acao.equals("alterar")) {
                
                /*int id = Integer.parseInt(request.getParameter( "id" ));
                String nome = request.getParameter( "nome" );
                String sobrenome = request.getParameter( "sobrenome" );
                String dataNascimento = request.getParameter( "dataNascimento");
                String cpf = request.getParameter( "cpf" );
                String email = request.getParameter( "email" );
                String logradouro = request.getParameter( "logradouro" );
                String numero = request.getParameter( "numero" );
                String bairro = request.getParameter( "bairro" );
                String cep = request.getParameter( "cep" );
                int idCidade = Integer.parseInt(request.getParameter( "idCidade" ) );
                */
                DVD d = new DVD();
                /*d.setId( idCidade );
                
                Cliente c = new Cliente();
                c.setId( id );
                c.setNome( nome );
                c.setSobrenome( sobrenome );
                if (verificarData(dataNascimento, dtf)){
                    c.setDataNascimento( Date.valueOf(LocalDate.parse( dataNascimento, dtf ) ) );
                    
                } else {
                    String erro = "Data de nascimento ecolhida não pôde ser aceita" ;
                    
                    request.setAttribute("erro", erro);
                    disp = request.getRequestDispatcher("/formularios/clientes/erro.jsp") ;
                }
                
                if (verificarCpf(cpf)) {
                    c.setCpf( cpf );
                } else {
                    String erro = "CPF digitado está fora do formato esperado" ;
                    
                    request.setAttribute("erro", erro);
                    disp = request.getRequestDispatcher("/formularios/clientes/erro.jsp") ;
                }
                if (verificarEmail(email)){
                    c.setEmail( email );
                } else {
                    String erro = "Email digitado está fora do formato esperado" ;
                    
                    request.setAttribute("erro", erro);
                    disp = request.getRequestDispatcher("/formularios/clientes/erro.jsp") ;
                }
                c.setLogradouro( logradouro );
                c.setNumero( numero );
                c.setBairro( bairro );
                if (verificarCep(cep)){
                    c.setCep( cep );
                }else {
                    String erro = "Cep digitado está fora do formato esperado" ;
                    
                    request.setAttribute("erro", erro);
                    disp = request.getRequestDispatcher("/formularios/clientes/erro.jsp") ;
                }
                c.setCidade( d );
                */
                dao.atualizar( d );
                
                disp = request.getRequestDispatcher("/formularios/DVDs/listagem.jsp" );
                
            } else if (acao.equals("excluir")) {
                int id = Integer.parseInt(request.getParameter( "id" ));
                
                DVD d = new DVD();
                d.setId( id );
                
                dao.excluir( d );
                
                disp = request.getRequestDispatcher("/formularios/DVDs/listagem.jsp" );
                
            } else {
                
                int id = Integer.parseInt(request.getParameter( "id" ));
                
                DVD c = dao.selecionarPorID(id);
                request.setAttribute( "cliente", c );
                
                if ( acao.equals( "prepararAlteracao" ) ) {
                    disp = request.getRequestDispatcher("/formularios/clientes/alterar.jsp" );
                    
                } else if ( acao.equals( "prepararExclusao" ) ) {
                    disp = request.getRequestDispatcher("/formularios/clientes/excluir.jsp" );
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
