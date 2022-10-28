package org.sid.ebankservice.repository;

import org.sid.ebankservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;
import org.sid.ebankservice.enums.AccountType;
import org.springframework.data.rest.core.annotation.RestResource;


@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount,String>{
    @RestResource(path ="/byType")
    List<BankAccount> findByType(@Param("t") AccountType type);
}
