package com.depwypbal.deposit.repo;

import com.depwypbal.deposit.model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositRepository extends JpaRepository<Deposit,Long> {
}
