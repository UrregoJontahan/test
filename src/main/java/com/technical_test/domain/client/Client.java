package com.technical_test.domain.client;

import com.technical_test.domain.product.account.Account;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "type_id", nullable = false)
    private String typeId;

    @Column(name = "number_id", nullable = false, unique = true)
    private Integer numberId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "create_date", updatable = false)
    private LocalDate creationDate;

    @Column(name = "modification_date")
    private LocalDate modificationDate;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Account> accountList = new ArrayList<>();


    @PrePersist
    public void prePersist() {
        this.creationDate = LocalDate.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.modificationDate = LocalDate.now();
    }


}
