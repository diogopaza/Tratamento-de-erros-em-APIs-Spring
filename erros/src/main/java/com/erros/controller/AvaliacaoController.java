package com.erros.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erros.DTO.AvaliacaoDTO;
import com.erros.service.AvaliacaoService;

import lombok.AllArgsConstructor;

@RequestMapping("/avaliacao")
@RestController
@AllArgsConstructor
public class AvaliacaoController {

    AvaliacaoService avaliacaoServico;

    @PostMapping
    public String cadastrar(@RequestBody AvaliacaoDTO avaliacao){
        try{
            System.out.println(avaliacao.getNome());
            var result = avaliacaoServico.create(avaliacao);
           // return ResponseEntity.status(HttpStatus.OK).body(null);
           return result;
        }catch(Exception ex){
            System.out.println("ERRO" + ex);
            //ResponseEntity.badRequest().build();
            return "erro";
           
        }
    }
    
}
