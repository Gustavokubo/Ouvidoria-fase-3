package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Pessoa {

	private String nome;
	private String cpf;

	public Pessoa(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + "]";
	}

	//Método para inserir os dados cadastrais do usuário no banco de dados. 
	public void inserir(Connection con) {
		try {
			Statement s = con.createStatement();
			String sql = "insert into pessoa (nome, cpf) values ('" + this.nome + "','" + this.cpf + "')";
			s.executeUpdate(sql);
			System.out.println("Dados inseridos no banco");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	//Método para pegar o ID da tabela pessoa no MySQL. 
	public int getPessoaID(Connection con) {
		String sql = "select ID from pessoa where cpf = (?)";
		try {
			PreparedStatement s = con.prepareStatement(sql);
			s.setString (1, this.cpf);
			ResultSet resultado = s.executeQuery();
			resultado.next();
			return resultado.getInt("ID");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void listar(Connection con) {
		String sql = "select * from pessoa";
		try {
			Statement s = con.createStatement();
			ResultSet resultado = s.executeQuery(sql);
			while (resultado.next()) {
				System.out.printf("ID: %d, nome: %s, cpf: %s%n", 
						resultado.getInt("ID"), 
						resultado.getString("nome"),
						resultado.getString("cpf"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	//Método para listar os dados cadastrais do usuário.
	public static String listarPessoabyID (Connection con, int id) {
		String sql = "select * from pessoa where id = (?)";
		try {
			PreparedStatement s = con.prepareStatement(sql);
			s.setInt(1, id);
			ResultSet resultado = s.executeQuery();
			resultado.next();
			return "Nome: " + resultado.getString("Nome") + ", CPF: " + resultado.getString("cpf");
					
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return "";
	}
	
}