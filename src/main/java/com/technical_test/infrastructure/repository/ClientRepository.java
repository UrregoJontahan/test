package com.technical_test.infrastructure.repository;

import com.technical_test.domain.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository <Client, Long> {

}
