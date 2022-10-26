package com.xinelovoador.atletapresenca.persistence.DAOs;

import com.xinelovoador.atletapresenca.domain.Atleta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AtletaDAO {

    private String connectionString;
    private String username;
    private String password;

    public AtletaDAO(String connectionString, String username, String password) {
        this.connectionString = connectionString;
        this.username = username;
        this.password = password;
    }

    public void save(Atleta atleta) {
        String insertAtletaCommand = "INSERT INTO ATLETA (NOME_COMPLETO, DATA_NASCIMENTO, EMAIL, CELULAR) VALUES (?,?,?,?);";
        try (Connection connection = DriverManager.getConnection(connectionString);
            PreparedStatement preparedStatement = connection.prepareStatement(insertAtletaCommand)) {
            preparedStatement.setString(1, atleta.getNomeCompleto());
            preparedStatement.setDate(2, (Date) atleta.getDataNasciento());
            preparedStatement.setString(3, atleta.getEmail());
            preparedStatement.setString(4, atleta.getCelular());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Atleta getById(int id) {
        Atleta atleta = new Atleta();
        String getAtletaByIdQuery = "SELECT ID, NOME_COMPLETO, DATA_NASCIMENTO, EMAIL, CELULAR FROM ATLETA WHERE ID = ?;";
        try (Connection connection = DriverManager.getConnection(connectionString);
            PreparedStatement preparedStatement = connection.prepareStatement(getAtletaByIdQuery);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            atleta.setId(rs.getInt("ID"));
            atleta.setNomeCompleto(rs.getString("NOME_COMPLETO"));
            atleta.setDataNasciento(rs.getDate("DATA_NASCIMENTO"));
            atleta.setEmail(rs.getString("EMAIL"));
            atleta.setCelular(rs.getString("CELULAR"));
        } catch (SQLException e) {
            System.out.println(e);
        }
        return atleta;
    }

    public List<Atleta> listAll() {
        List<Atleta> atletas = new ArrayList<Atleta>();
        String getAtletasQuery = "SELECT ID, NOME_COMPLETO, DATA_NASCIMENTO, EMAIL, CELULAR FROM ATLETA;";
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(getAtletasQuery);) {
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                Atleta atleta = new Atleta();
                atleta.setId(rs.getInt("ID"));
                atleta.setNomeCompleto(rs.getString("NOME_COMPLETO"));
                atleta.setDataNasciento(rs.getDate("DATA_NASCIMENTO"));
                atleta.setEmail(rs.getString("EMAIL"));
                atleta.setCelular(rs.getString("CELULAR"));
                atletas.add(atleta);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return atletas;
    }
}
