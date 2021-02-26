package br.com.zup.transacao.card;

import br.com.zup.transacao.transaction.Transactions;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true, nullable = false)
    private String cardNumber;
    @NotBlank
    private String email;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private Set<Transactions> transactionsList = new HashSet<>();

    @Deprecated
    Card(){}

    public Card(@NotBlank String cardNumber, @NotBlank String email) {
        this.cardNumber = cardNumber;
        this.email = email;
    }
}
