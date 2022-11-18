package com.devsuperior.backend.repositories;

import com.devsuperior.backend.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    // personalizar qualquer operação
}
