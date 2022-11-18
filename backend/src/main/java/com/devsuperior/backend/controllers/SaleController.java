package com.devsuperior.backend.controllers;

import com.devsuperior.backend.entities.Sale;
import com.devsuperior.backend.services.SaleService;
import com.devsuperior.backend.services.SmsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

   private SaleService service;

   private SmsService smsService;

    public SaleController(SaleService service, SmsService smsService) {
        this.service = service;
        this.smsService = smsService;
    }

    @GetMapping
    public Page<Sale> findSale(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
       return service.findSales(minDate, maxDate, pageable);
   }

   @GetMapping("/{id}/notification")
   public void notifySms(@PathVariable Long id) {
      smsService.sendSms(id);
   }
}
