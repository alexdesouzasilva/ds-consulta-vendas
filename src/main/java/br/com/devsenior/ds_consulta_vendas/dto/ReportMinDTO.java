package br.com.devsenior.ds_consulta_vendas.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportMinDTO {

    private Long id;
    private LocalDate date;
    private Double amount;
    private String sellerName;

}
