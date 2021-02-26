package br.com.zup.transacao.transaction;

import br.com.zup.transacao.card.Card;
import br.com.zup.transacao.establishment.Establishment;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(unique = true, nullable = false)
    private UUID transactionId;

    @Positive
    @NotNull
    private BigDecimal transactionValue;

    @NotNull
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "establishment_id")
    private Establishment establishment;

    @NotNull
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "card_id")
    private Card card;

    @NotNull
    private LocalDateTime effectiveOn;

    @Deprecated
    Transactions(){}

    public Transactions(@NotNull UUID transactionId,
                        @Positive @NotNull BigDecimal transactionValue,
                        @NotNull Establishment establishment,
                        @NotNull Card card,
                        @NotNull LocalDateTime effectiveOn) {
        this.transactionId = transactionId;
        this.transactionValue = transactionValue;
        this.establishment = establishment;
        this.card = card;
        this.effectiveOn = effectiveOn;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public BigDecimal getTransactionValue() {
        return transactionValue;
    }

    public Establishment getEstablishment() {
        return establishment;
    }

    public Card getCard() {
        return card;
    }

    public LocalDateTime getEffectiveOn() {
        return effectiveOn;
    }
}
