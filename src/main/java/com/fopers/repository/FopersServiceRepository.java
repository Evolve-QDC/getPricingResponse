package com.fopers.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import com.fopers.model.Order;

@Repository
public interface FopersServiceRepository extends JpaRepository<Order, Long> {

	// Mobile App API Ends
}
