package mvc.logica;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import mvc.model.UsuarioDao;

public class CadastrarUsuariosCommand implements Command{

	@Override
	public String execute(HttpServletRequest rq, HttpServletResponse rs)
			throws ServletException {
		ServletContext context = rq.getServletContext();
        String arquivo = context.getRealPath("/WEB-INF/DOCS/nomes.txt");
		
		String nome = rq.getParameter("name");
		
		new UsuarioDao(arquivo).adiciona(nome);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", "200" );
		
		//return "/WEB-INF/jsp/cadastrar-usuarios.jsp";
		return jsonObject.toJSONString();
	}
}
