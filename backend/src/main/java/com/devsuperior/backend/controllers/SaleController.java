package com.devsuperior.backend.controllers;

import com.devsuperior.backend.entities.Sale;
import com.devsuperior.backend.services.SaleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public List<Sale> findSale() {
       return service.findSales();
   }
}
