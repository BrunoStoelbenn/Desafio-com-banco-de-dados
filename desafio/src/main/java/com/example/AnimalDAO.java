package com.example;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnimalDAO {
    public static Connection estabelecerConexao(){
        Connection connection = null;
        try {
            // Estabelece a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/animal", "postgres", "root");
            System.out.println("Banco de dados conectado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Não foi possível conectar ao banco de dados!");
            e.printStackTrace();
        }
        return connection; 
    }

    public static void createTableBovino(Connection connection){
        try {
            // Verifica se a tabela já existe
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getTables(null, null, "bovino", null);
            if (resultSet.next()) {
                System.out.println("A tabela 'bovino' já existe.");
                return;
            }
            
            // Prepara a instrução SQL para inserir um novo animal na tabela
            String sql = "CREATE TABLE bovino (\r\n" + //
                                "    id SERIAL PRIMARY KEY,\r\n" + //
                                "    altura FLOAT NOT NULL,\r\n" + //
                                "    comprimento FLOAT NOT NULL,\r\n" + //
                                "    largura FLOAT NOT NULL,\r\n" + //
                                "    peso FLOAT NOT NULL,\r\n" + //
                                "    status VARCHAR(50) NOT NULL,\r\n" + //
                                "    precoVenda FLOAT\r\n" + //
                                ");\r\n" + //
                                "";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Executa a instrução SQL
            statement.executeUpdate();
            System.out.println("Tabela 'bovino' criada com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela 'bovino':" + e.getMessage());
        }
    }

    public static void adicionarBovinoDAO(Bovino bovino, Connection connection) {
        try {
            // Prepara a instrução SQL para inserir um novo animal na tabela
            String sql = "INSERT INTO bovino (altura, comprimento, largura, peso, status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setFloat(1, bovino.getAltura());
            statement.setFloat(2, bovino.getComprimento());
            statement.setFloat(3, bovino.getLargura());
            statement.setFloat(4, bovino.getPeso());
            statement.setString(5, bovino.getStatus());

            // Executa a instrução SQL
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void avaliarBovinoDAO(int id, float novaAltura, float novoComprimento, float novaLargura, float novoPeso, Connection connection) {
        try {
            String sql = "UPDATE bovino SET altura = ?, comprimento = ?, largura = ?, peso = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setFloat(1, novaAltura);
            statement.setFloat(2, novoComprimento);
            statement.setFloat(3, novaLargura);
            statement.setFloat(4, novoPeso);
            statement.setInt(5, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Bovino atualizado com sucesso no banco de dados.");
            } else {
                System.out.println("Nenhum bovino encontrado com o ID especificado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o bovino no banco de dados: " + e.getMessage());
        }
    }
}
