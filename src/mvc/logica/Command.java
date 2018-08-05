package mvc.logica;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

    public String execute(HttpServletRequest rq, HttpServletResponse rs) throws ServletException;

}
