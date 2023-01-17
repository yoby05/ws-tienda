package com.tienda.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.tienda.dto.PricesDto;
import com.tienda.entity.Prices;
import com.tienda.enumApp.EnumFormatDate;
import com.tienda.repository.RepositoryPrices;
import com.tienda.response.PricesResponse;
import com.tienda.service.PricesService;
import com.tienda.utils.FechaUtil;

/**
 * @author Yoan Hernandez
 * @date 17 ene 2023
 */
@Service
public class PricesServiceImp implements PricesService {
    @Value("${rc.code.success}")
    private String codecSuccess;
    @Value("${rc.message.requestSuccess}")
    private String msgSuccess;
    @Autowired
    private RepositoryPrices repositoryPrice;

    @Override
    public PricesResponse salePrice(PricesDto entry) {
        PricesResponse response = new PricesResponse(this.codecSuccess, this.msgSuccess);
        Date dateAplication = FechaUtil.convertirStringFecha(entry.getDateAplication(), EnumFormatDate.FECHA_TIME_ENGLISH);
        List<Prices> listEntity = this.repositoryPrice.pricesByFilters(entry.getIdProduct(), entry.getIdBrand(), dateAplication);
        for (Prices bdd : listEntity) {
            response.setPrice(this.castToDto(bdd, entry.getDateAplication()));
            break;
        }
        return response;
    }

    private PricesDto castToDto(Prices entity, String dateAplication) {
        PricesDto dto = new PricesDto();
        dto.setDateAplication(dateAplication);
        dto.setStartAplication(FechaUtil.convertirFechaString(entity.getStartDate(), EnumFormatDate.FECHA_TIME_ENGLISH));
        dto.setEndAplication(FechaUtil.convertirFechaString(entity.getEndDate(), EnumFormatDate.FECHA_TIME_ENGLISH));
        dto.setIdProduct(entity.getJoinProduct().getIdProduct());
        dto.setIdBrand(entity.getJoinBrand().getIdBrand());
        dto.setPrice(entity.getPrice());
        dto.setRate(entity.getJoinRate().getName());
        return dto;
    }
}
