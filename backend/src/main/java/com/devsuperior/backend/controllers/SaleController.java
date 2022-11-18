package com.devsuperior.backend.controllers;

import com.devsuperior.backend.entities.Sale;
import com.devsuperior.backend.services.SaleService;
import org.apache.el.util.Validation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

   private SaleService service;

    public SaleController(SaleService service) {
        this.service = service;
    }

    @GetMapping
    public Page<Sale> findSale(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
       return service.findSales(minDate, maxDate, pageable);
   }
}
