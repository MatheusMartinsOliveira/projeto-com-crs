/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcont.gerenciamento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author farma
 */
@Controller
public class FuncionarioController {
    
    @GetMapping("/funcionarios")
    public String getFuncionarios() {
        return "funcionarios";
    }
}
