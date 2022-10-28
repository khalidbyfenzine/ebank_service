package org.sid.ebankservice.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.ebankservice.enums.AccountType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount {
    @Id
    private String id;
    private Date createdAt;
    private Double balance;
    private AccountType type;
    private String currency;
    @ManyToOne
    private Customer customer;
}
