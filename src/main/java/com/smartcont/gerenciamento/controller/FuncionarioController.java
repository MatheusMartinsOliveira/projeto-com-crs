/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcont.gerenciamento.controller;

import com.smartcont.gerenciamento.model.FuncionarioDTO;
import com.smartcont.gerenciamento.repository.FuncionarioDAO;
import com.smartcont.gerenciamento.service.FuncionarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author farma
 */
@Controller
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService service;
    @GetMapping("/funcionarios")
    public String getFuncionarios(Model model) {
        List<FuncionarioDTO> lista = service.lerTodos();
        model.addAttribute("lista", lista);
        return "funcionarios";
    }
    
    @GetMapping("/perfil")
    public String abrirEdicao(@RequestParam int id, Model model) {
        FuncionarioDTO f = service.lerPorID(id);
        model.addAttribute("funcionario", f);
        return "perfil";
    }
    
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute FuncionarioDTO funcionario) {
        service.editarFuncionario(funcionario);
        return "redirect:/funcionarios";
    }
    @PostMapping("/adicionar")
    public String adicionar(@ModelAttribute FuncionarioDTO funcionario) {
        service.editarFuncionario(funcionario);
        return "redirect:/funcionarios";
    }
}
