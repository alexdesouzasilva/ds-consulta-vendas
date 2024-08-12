package br.com.devsenior.ds_consulta_vendas.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.devsenior.ds_consulta_vendas.dto.ReportMinDTO;
import br.com.devsenior.ds_consulta_vendas.dto.SaleMinDTO;
import br.com.devsenior.ds_consulta_vendas.dto.SaleSummaryDTO;
import br.com.devsenior.ds_consulta_vendas.entities.Sale;
import br.com.devsenior.ds_consulta_vendas.repositories.SaleRepository;
import br.com.devsenior.ds_consulta_vendas.services.exceptions.ResourceNotFoundException;

@Service
public class SaleService {
    
    @Autowired
    private SaleRepository repository;

    @Transactional(readOnly = true)
    public SaleMinDTO findById(Long id) {
        Sale sale = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
        return new SaleMinDTO(sale);
    }

    @Transactional(readOnly = true)
    public List<SaleSummaryDTO> getSummary(String minDate, String maxDate) {
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
       LocalDate endDate = maxDate == "" || maxDate.isEmpty() ? LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault()) : LocalDate.parse(maxDate, formatter);
       LocalDate startDate = minDate == "" || minDate.isEmpty() ? endDate.minusYears(1L) : LocalDate.parse(minDate, formatter);
       return repository.sumary(startDate, endDate);
    }


    @Transactional(readOnly = true)
    public List<ReportMinDTO> getReport(String minDate, String maxDate, String name) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
       LocalDate endDate = maxDate == "" || maxDate.isEmpty() ? LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault()) : LocalDate.parse(maxDate, formatter);
       LocalDate startDate = minDate == "" || minDate.isEmpty() ? endDate.minusYears(1L) : LocalDate.parse(minDate, formatter);
        return repository.report(startDate, endDate, name);
    }

    

  
}
