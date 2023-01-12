package com.erros.DTO;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AvaliacaoDTO {
    
    private String nome;
    private String nota;    
}
