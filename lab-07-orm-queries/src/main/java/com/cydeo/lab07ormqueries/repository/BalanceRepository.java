package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.Balance;
import com.cydeo.lab07ormqueries.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {

    //Write a derived query to check balance exists for specific customer
    boolean existsBalanceByCustomer(Customer customer);

    //Write a derived query to get balance for specific customer
    Balance getByCustomer_Id(Long id);

    //Write a native query to get top 5 max balance
    @Query(value = "select * from balance order by amount desc limit 5", nativeQuery = true)
    List<Balance> getTop5MaxAmount();

    //Write a derived query to get all balances greater than or equal specific balance amount
    List<Balance> getAllByAmountGreaterThanEqual(BigDecimal amount);
    //Write a native query to get all balances less than specific balance amount
}
