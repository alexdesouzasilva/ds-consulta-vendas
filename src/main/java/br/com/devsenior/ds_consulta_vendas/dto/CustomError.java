package br.com.devsenior.ds_consulta_vendas.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomError {
    
    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;
}
