package com.devsuperior.backend.repositories;

import com.devsuperior.backend.entities.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    // personalizar qualquer operação

    @Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC") // JPQL
    Page<Sale> findSales(LocalDate min, LocalDate max, Pageable pageable);
}
