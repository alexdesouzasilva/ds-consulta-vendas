package br.com.devsenior.ds_consulta_vendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.devsenior.ds_consulta_vendas.dto.ReportMinDTO;
import br.com.devsenior.ds_consulta_vendas.dto.SaleMinDTO;
import br.com.devsenior.ds_consulta_vendas.dto.SaleSummaryDTO;
import br.com.devsenior.ds_consulta_vendas.services.SaleService;

@RestController
@RequestMapping(value = "sales")
public class SaleController {

    @Autowired
    private SaleService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
        SaleMinDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/summary")
    public ResponseEntity<List<SaleSummaryDTO>> getSummary(
        @RequestParam(defaultValue = "") String minDate,
        @RequestParam(defaultValue = "") String maxDate) {
            List<SaleSummaryDTO> dto = service.getSummary(minDate, maxDate);
            return ResponseEntity.ok(dto);
    }


    @GetMapping(value = "/report")
    public ResponseEntity<List<ReportMinDTO>> getReport(
        @RequestParam(defaultValue = "") String minDate,
        @RequestParam(defaultValue = "") String maxDate,
        @RequestParam(defaultValue = "") String name) {
            List<ReportMinDTO> reportDTO = service.getReport(minDate, maxDate, name);
            return ResponseEntity.ok(reportDTO);
        }
    
}
