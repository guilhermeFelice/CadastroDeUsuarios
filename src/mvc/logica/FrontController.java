package mvc.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FrontController", urlPatterns = {"/mvc"})
public class FrontController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String op = request.getParameter("cmd");
        CommandFactory commFact = new CommandFactory();
        Command c = commFact.getCommand(op);
        String resultado = c.execute(request, response);
        //request.getRequestDispatcher(resultado).forward(request, response);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(resultado);
        
    }
}