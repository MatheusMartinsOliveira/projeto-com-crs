/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcont.gerenciamento.repository;

import com.smartcont.gerenciamento.model.FuncionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author farma
 */
@Repository
public class FuncionarioDAO {

    public List<FuncionarioDTO> lerTodos() {
        List<FuncionarioDTO> dados = new ArrayList();
        
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("select * from funcionario");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                FuncionarioDTO funcionario = new FuncionarioDTO();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setDepartamento(rs.getString("departamento"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setDataContratacao(rs.getDate("data_contratacao"));
                dados.add(funcionario);
                        
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return dados;
    }
    public FuncionarioDTO lerPorID(int id) {
        FuncionarioDTO funcionario = new FuncionarioDTO();
        
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("select * from funcionario where id = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setDepartamento(rs.getString("departamento"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setDataContratacao(rs.getDate("data_contratacao"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }return funcionario;
    }
    public void editarFuncionario(FuncionarioDTO funcionario){
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
  
            
            stmt = conn.prepareStatement("update funcionario set nome = ?, cargo = ?, departamento = ?, email = ?, data_contratacao = ? where id = ?");
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setString(3, funcionario.getDepartamento());
            stmt.setString(4, funcionario.getEmail());
            stmt.setDate(5, funcionario.getDataContratacao());
            stmt.setInt(6, funcionario.getId());
            stmt.executeUpdate();
           
        }catch(SQLException e){
            e.printStackTrace();
        }
            
    }
    public void criarFuncionario(FuncionarioDTO funcionario) {
        try{
        Connection conn = Conexao.conectar();
        PreparedStatement stmt = null;
        
        stmt = conn.prepareStatement("insert into funcionario (nome, cargo, departamento, email, data_contratacao) values (?, ?, ?, ?, ?)");
        stmt.setString(1, funcionario.getNome());
        stmt.setString(2, funcionario.getCargo());
        stmt.setString(3, funcionario.getDepartamento());
        stmt.setString(4, funcionario.getEmail());
        stmt.setDate(5, funcionario.getDataContratacao());
        stmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
