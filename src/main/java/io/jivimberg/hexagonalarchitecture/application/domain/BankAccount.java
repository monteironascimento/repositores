package io.jivimberg.hexagonalarchitecture.application.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bankAccount")
public class BankAccount {

    @Id
    @Column
    private Long id;

    @Column
    private BigDecimal balance;

    public BankAccount(){
        
    }

    public BankAccount(Long id, BigDecimal balance) {
        this.setId(id);
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean withdraw(BigDecimal amount) {
        if(balance.compareTo(amount) < 0) {
            return false;
        }

        balance = balance.subtract(amount);
        return true;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

}
