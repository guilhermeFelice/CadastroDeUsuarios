package mvc.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
	private String path;
	
	public UsuarioDao(String arquivo){
		this.path = arquivo;
	}
	
	private List<String> LerArquivo(){
		List<String> usuarios = new ArrayList<String>();
		try {
			FileReader arq = new FileReader(this.path);
			BufferedReader lerArq = new BufferedReader(arq);
			
			//Lista para armazenar os usuarios
			String linha = lerArq.readLine();
			while (linha != null){
				//Adicionando o usuarios à lista
				usuarios.add(linha);
				//System.out.printf("%s\n", linha);				
				linha = lerArq.readLine();
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
		return usuarios;
	}
	private void EscreverArquivo(List<String> lista){
		try {
		File file = new File(this.path);
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		/*writer.write("Arquivo gravado em : " + new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()));
		writer.newLine();
		writer.write("Caminho da gravação: " + path);
		writer.newLine();*/
		for(String s : lista){
			writer.write(s);
			writer.newLine();
		}
		//Criando o conteúdo do arquivo
		writer.flush();
		
		//Fechando conexão e escrita do arquivo.
		writer.close();
		} catch (IOException e) {
			System.err.printf("Erro na escrita do arquivo: %s.\n", e.getMessage());
		}
		System.out.println("Arquivo gravado em: " + path);
	}
	
	public void adiciona(String usuario){
		List<String> lista = this.LerArquivo();
		lista.add(usuario);
		this.EscreverArquivo(lista);
	}
	
	public List<String> getLista() {
		return this.LerArquivo();
	}
	
/*	public void altera(Contato contato){
		String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new DAOException(e);
		}
	}
	public void remove(Contato contato){
		try{
			PreparedStatement stmt = connection.prepareStatement("delete from contatos where id=?");
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new DAOException(e);
		}
	}*/
}
