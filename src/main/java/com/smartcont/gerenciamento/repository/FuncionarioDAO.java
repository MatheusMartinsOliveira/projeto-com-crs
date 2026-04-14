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

/**
 *
 * @author farma
 */
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
                
                        
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return dados;
    }
}
