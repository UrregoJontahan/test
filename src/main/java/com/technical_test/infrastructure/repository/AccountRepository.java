package com.technical_test.infrastructure.repository;

import com.technical_test.domain.product.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
