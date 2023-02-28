package com.cydeo.config;

import com.cydeo.Currency;
import com.cydeo.account.Current;
import com.cydeo.account.Saving;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.math.BigDecimal;
import java.util.UUID;


@Configuration
public class Config {
    @Bean
    public Currency currency(){
        Currency currency = new Currency();
        currency.setName("name");
        currency.setCode("code");
        return currency;
    }

    @Bean
    public Current current(){
        Current current = new Current();
        current.setAccountId(UUID.randomUUID());
        current.setCurrency(currency());
        current.setAmount(BigDecimal.valueOf(235.7));
        return current;
    }
    @Bean
    public Saving saving(){
        Saving saving = new Saving();
        saving.setAccountId(UUID.randomUUID());
        saving.setCurrency(currency());
        saving.setAmount(BigDecimal.valueOf(430.5));
        return saving;
    }
}
