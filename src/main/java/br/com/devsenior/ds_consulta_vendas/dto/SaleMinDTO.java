package br.com.devsenior.ds_consulta_vendas.dto;

import java.time.LocalDate;

import br.com.devsenior.ds_consulta_vendas.entities.Sale;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleMinDTO {

    private Long id;
    private Double amount;
    private LocalDate date;

    public SaleMinDTO(Sale sale) {
        this.id = sale.getId();
        this.amount = sale.getAmount();
        this.date = sale.getDate();
    }
    
}
