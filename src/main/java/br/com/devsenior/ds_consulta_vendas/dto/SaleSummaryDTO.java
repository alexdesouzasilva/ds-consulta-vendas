package br.com.devsenior.ds_consulta_vendas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleSummaryDTO {

    private String sellerName;
    private Double total;
    
}
