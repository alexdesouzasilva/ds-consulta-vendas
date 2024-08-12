package br.com.devsenior.ds_consulta_vendas.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.devsenior.ds_consulta_vendas.dto.ReportMinDTO;
import br.com.devsenior.ds_consulta_vendas.dto.SaleSummaryDTO;
import br.com.devsenior.ds_consulta_vendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {


    @Query("SELECT new br.com.devsenior.ds_consulta_vendas.dto.SaleSummaryDTO(s.seller.name, SUM(s.amount)) " + 
        "FROM Sale s " + 
        "WHERE s.date BETWEEN :minDate AND :maxDate " +
        "GROUP BY s.seller.name")
    List<SaleSummaryDTO> sumary(LocalDate minDate, LocalDate maxDate);


    @Query("SELECT new br.com.devsenior.ds_consulta_vendas.dto.ReportMinDTO(s.id, s.date, SUM(s.amount), sr.name) " + 
    "FROM Sale s " + 
    "INNER JOIN s.seller sr " +
    "WHERE s.date BETWEEN :minDate AND :maxDate " +
    "AND sr.name LIKE CONCAT('%', :name, '%') " +
    "GROUP BY s.id")
    List<ReportMinDTO> report(LocalDate minDate, LocalDate maxDate, String name);
    
}
