package com.tienda.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tienda.entity.Prices;

/**
 * @author Yoan Hernandez
 * @date 17 ene 2023
 */
public interface RepositoryPrices extends JpaRepository<Prices, Long> {
    /**
     * Get by filter
     * @param idProduct
     * @param idBrand
     * @param dateAplication
     * @return List<Prices>
     */
    @Query("SELECT pri from Prices pri join fetch pri.joinBrand br"
            + " join fetch pri.joinProduct pro join fetch pri.joinRate rat"
            + " where pro.idProduct =:idProduct and br.idBrand =:idBrand"
            + " and (:dateAplication BETWEEN pri.startDate and pri.endDate) order by pri.priority DESC")
    List<Prices> pricesByFilters(Long idProduct, Long idBrand, Date dateAplication);
}
