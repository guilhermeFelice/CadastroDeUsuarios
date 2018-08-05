package mvc.logica;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.model.UsuarioDao;
import org.json.simple.JSONObject;

public class ListarUsuariosCommand implements Command{

	@Override
	public String execute(HttpServletRequest rq, HttpServletResponse rs)
			throws ServletException {
		
		//Buscando arquivo com lista de contatos
        ServletContext context = rq.getServletContext();
        String arquivo = context.getRealPath("/WEB-INF/DOCS/nomes.txt");
		    
		//Passando a conexão no construtor		
		List<String> usuarios =  new UsuarioDao(arquivo).getLista();
		
		/*for (String s : usuarios ) {
			System.out.println(s);
		}*/		
		
		//instancia um novo JSONObject
        JSONObject jsonObject = new JSONObject();
        //Armazena dados em um Objeto JSON
        jsonObject.put("usuarios", usuarios);

		return jsonObject.toJSONString();
	}

}

