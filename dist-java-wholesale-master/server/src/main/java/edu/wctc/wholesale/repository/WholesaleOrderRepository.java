package edu.wctc.wholesale.repository;

import edu.wctc.wholesale.entity.WholesaleOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WholesaleOrderRepository extends JpaRepository<WholesaleOrder, Integer> {
}
