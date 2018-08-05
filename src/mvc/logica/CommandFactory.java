package mvc.logica;

import java.util.HashMap;

public class CommandFactory {
    
    private HashMap< String, Command> comandos;

    public CommandFactory() {
        
        // recuperar esses dados de um arquivo 
        //  properties ou XML
        this.comandos = new HashMap<>() ;
        comandos.put("listar", new ListarUsuariosCommand() );
        comandos.put("cadastrar", new CadastrarUsuariosCommand());
    }

    public Command getCommand(String op) {
       return comandos.get(op);
    }

}
