package com.erros.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.erros.DTO.AvaliacaoDTO;
import com.erros.service.AvaliacaoService;

import lombok.AllArgsConstructor;

@RequestMapping("/avaliacao")
@RestController
@AllArgsConstructor
public class AvaliacaoController {

    AvaliacaoService avaliacaoServico;

    @PostMapping(produces =  MediaType.APPLICATION_PDF_VALUE)
    public  byte[] cadastrar(@RequestBody AvaliacaoDTO body) {
        try {           
           // System.out.println(avaliacao.getNome());
            var result = avaliacaoServico.create(body);            
            return result;
        } catch (Exception ex) {
            System.out.println("ERRO" + ex);
            return null;
        }

    }

}
