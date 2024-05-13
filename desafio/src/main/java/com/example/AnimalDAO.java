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

    public static void createTableSuino(Connection connection){
        try {
            // Verifica se a tabela já existe
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getTables(null, null, "suino", null);
            if (resultSet.next()) {
                System.out.println("A tabela 'suino' já existe.");
                return;
            }
            
            // Prepara a instrução SQL para inserir um novo animal na tabela
            String sql = "CREATE TABLE suino (\r\n" + //
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
            System.out.println("Tabela 'suino' criada com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela 'suino':" + e.getMessage());
        }
    }

    public static void createTableEquino(Connection connection){
        try {
            // Verifica se a tabela já existe
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getTables(null, null, "equino", null);
            if (resultSet.next()) {
                System.out.println("A tabela 'equino' já existe.");
                return;
            }
            
            // Prepara a instrução SQL para inserir um novo animal na tabela
            String sql = "CREATE TABLE equino (\r\n" + //
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
            System.out.println("Tabela 'equino' criada com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela 'equino':" + e.getMessage());
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

    public static void adicionarSuinoDAO(Suino suino, Connection connection) {
        try {
            // Prepara a instrução SQL para inserir um novo animal na tabela
            String sql = "INSERT INTO suino (altura, comprimento, largura, peso, status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setFloat(1, suino.getAltura());
            statement.setFloat(2, suino.getComprimento());
            statement.setFloat(3, suino.getLargura());
            statement.setFloat(4, suino.getPeso());
            statement.setString(5, suino.getStatus());

            // Executa a instrução SQL
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void adicionarEquinoDAO(Equino equino, Connection connection) {
        try {
            // Prepara a instrução SQL para inserir um novo animal na tabela
            String sql = "INSERT INTO equino (altura, comprimento, largura, peso, status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setFloat(1, equino.getAltura());
            statement.setFloat(2, equino.getComprimento());
            statement.setFloat(3, equino.getLargura());
            statement.setFloat(4, equino.getPeso());
            statement.setString(5, equino.getStatus());

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

    public static void avaliarSuinoDAO(int id, float novaAltura, float novoComprimento, float novaLargura, float novoPeso, Connection connection) {
        try {
            String sql = "UPDATE suino SET altura = ?, comprimento = ?, largura = ?, peso = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setFloat(1, novaAltura);
            statement.setFloat(2, novoComprimento);
            statement.setFloat(3, novaLargura);
            statement.setFloat(4, novoPeso);
            statement.setInt(5, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Suino atualizado com sucesso no banco de dados.");
            } else {
                System.out.println("Nenhum suino encontrado com o ID especificado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o suino no banco de dados: " + e.getMessage());
        }
    }

    public static void avaliarEquinoDAO(int id, float novaAltura, float novoComprimento, float novaLargura, float novoPeso, Connection connection) {
        try {
            String sql = "UPDATE equino SET altura = ?, comprimento = ?, largura = ?, peso = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setFloat(1, novaAltura);
            statement.setFloat(2, novoComprimento);
            statement.setFloat(3, novaLargura);
            statement.setFloat(4, novoPeso);
            statement.setInt(5, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Equino atualizado com sucesso no banco de dados.");
            } else {
                System.out.println("Nenhum equino encontrado com o ID especificado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o equino no banco de dados: " + e.getMessage());
        }
    }

    public static void registrarVendaBovinoDAO(int id, String novoStatus, float precoVenda, Connection connection) {
        try {
            String sql = "UPDATE bovino SET status = ?, precovenda = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, novoStatus);
            statement.setFloat(2, precoVenda);
            statement.setInt(3, id);
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

    public static void registrarVendaSuinoDAO(int id, String novoStatus, float precoVenda, Connection connection) {
        try {
            String sql = "UPDATE suino SET status = ?, precovenda = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, novoStatus);
            statement.setFloat(2, precoVenda);
            statement.setInt(3, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Suino atualizado com sucesso no banco de dados.");
            } else {
                System.out.println("Nenhum suino encontrado com o ID especificado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o suino no banco de dados: " + e.getMessage());
        }
    }

    public static void registrarVendaEquinoDAO(int id, String novoStatus, float precoVenda, Connection connection) {
        try {
            String sql = "UPDATE equino SET status = ?, precovenda = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, novoStatus);
            statement.setFloat(2, precoVenda);
            statement.setInt(3, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Equino atualizado com sucesso no banco de dados.");
            } else {
                System.out.println("Nenhum equino encontrado com o ID especificado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o equino no banco de dados: " + e.getMessage());
        }
    }

    public static void registrarPerdaBovinoDAO(int id, String novoStatus, float precoVenda, Connection connection) {
        try {
            String sql = "UPDATE bovino SET status = ?, precovenda = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, novoStatus);
            statement.setFloat(2, precoVenda);
            statement.setInt(3, id);
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

    public static void registrarPerdaSuinoDAO(int id, String novoStatus, float precoVenda, Connection connection) {
        try {
            String sql = "UPDATE suino SET status = ?, precovenda = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, novoStatus);
            statement.setFloat(2, precoVenda);
            statement.setInt(3, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Suino atualizado com sucesso no banco de dados.");
            } else {
                System.out.println("Nenhum suino encontrado com o ID especificado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o suino no banco de dados: " + e.getMessage());
        }
    }

    public static void registrarPerdaEquinoDAO(int id, String novoStatus, float precoVenda, Connection connection) {
        try {
            String sql = "UPDATE equino SET status = ?, precovenda = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, novoStatus);
            statement.setFloat(2, precoVenda);
            statement.setInt(3, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Equino atualizado com sucesso no banco de dados.");
            } else {
                System.out.println("Nenhum equino encontrado com o ID especificado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o equino no banco de dados: " + e.getMessage());
        }
    }
}
