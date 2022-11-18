package com.devsuperior.backend.services;

import com.devsuperior.backend.entities.Sale;
import com.devsuperior.backend.repositories.SaleRepository;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;

@Service
public class SmsService {

    @Value("${twilio.sid}")
    private String twilioSid;

    @Value("${twilio.key}")
    private String twilioKey;

    @Value("${twilio.phone.from}")
    private String twilioPhoneFrom;

    @Value("${twilio.phone.to}")
    private String twilioPhoneTo;

    private SaleRepository saleRepository;

    public SmsService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public void sendSms(Long saleId) {

        Sale sale = saleRepository.findById(saleId).get();

        String date = sale.getDate().getMonthValue() + "/" + sale.getDate().getYear();

        String msg = "O Vendedor " + sale.getSellerName() + " foi destaque em " + date + " com um total de R$ " + sale.getAmount();

        Twilio.init(twilioSid, twilioKey);

        PhoneNumber to = new PhoneNumber(twilioPhoneTo);
        PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

        Message message = Message.creator(to, from, msg).create();

        System.out.println(message.getSid());
    }
}
