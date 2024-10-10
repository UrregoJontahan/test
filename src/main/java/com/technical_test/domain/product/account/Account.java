package com.technical_test.domain.product.account;

import com.technical_test.domain.client.Client;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

@Entity
@Data
@Table(name = "accounts", uniqueConstraints = {@UniqueConstraint(columnNames = "number_account")})
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_account", nullable = false)
    private String typeAccount;

    @Column(name = "number_account", nullable = false, length = 10, unique = true)
    private String numberAccount;

    @Enumerated(EnumType.STRING)
    @Column(name = "state_account", nullable = false)
    private AccountState stateAccount;

    @Column(nullable = false)
    private BigDecimal balance;

    @Column(nullable = false)
    private boolean exemptFromGMF;

    @Column(nullable = false)
    private LocalDate creationDate;

    @Column(nullable = false)
    private LocalDate modificationDate;

    @Column(nullable = false)
    private String user;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    public Account() {
        this.creationDate = LocalDate.now();
        this.modificationDate = LocalDate.now();
        this.stateAccount = AccountState.ACTIVE;
        this.balance = BigDecimal.ZERO;
    }

    public void deactivate() {
        this.stateAccount = AccountState.INACTIVE;
    }

    public void cancel() {
        this.stateAccount = AccountState.CANCELLED;
    }

    public void updateBalance(BigDecimal amount) {
        this.balance = balance.add(amount);
        this.modificationDate = LocalDate.now();
    }

    // Generar el número de cuenta usando el typeAccount
    public static String generateAccountNumber(String accountType) {
        String prefix = accountType.equalsIgnoreCase("ahorros") ? "53" : "33";
        // Ajustar el número para que, junto con el prefijo, tenga un total de 10 caracteres
        String number = String.format("%08d", new Random().nextInt(100000000)); // 8 dígitos en lugar de 9
        return prefix + number; // Total: 2 (prefijo) + 8 = 10 caracteres
    }
}
