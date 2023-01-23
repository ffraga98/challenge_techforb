package com.techforb.challenge.mapper;

import com.techforb.challenge.dto.command.SaleCDto;
import com.techforb.challenge.dto.query.SaleQDto;
import com.techforb.challenge.entity.Sale;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Component("saleMapper")
public class SaleMapper implements Mapper<Sale, SaleCDto, SaleQDto> {
    final String DATE_FORMAT = "dd/MM/uuuu";
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
    @Override
    public Sale createEntity(SaleCDto dto){
        Sale s = new Sale();
        s.setDate(LocalDate.parse(dto.getDate(), formatter));
        return s;
    }

    @Override
    public SaleQDto createDTO(Sale sale){
        return new SaleQDto();
    }
}
