package br.com.zup.transacao.transaction;

import br.com.zup.transacao.card.CardEvent;
import br.com.zup.transacao.card.CardRepository;
import br.com.zup.transacao.establishment.EstablishmentEvent;
import br.com.zup.transacao.establishment.EstablishmentRepository;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionEvent {

    @JsonProperty("id")
    private String id;

    @JsonProperty("valor")
    private BigDecimal value;

    @JsonProperty("estabelecimento")
    private EstablishmentEvent establishment;

    @JsonProperty("cartao")
    private CardEvent card;

    @JsonProperty("efetivadaEm")
    private LocalDateTime effectiveOn;

    @Override
    public String toString() {
        return "TransactionEvent{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                ", establishment=" + establishment +
                ", card=" + card +
                ", effectiveOn=" + effectiveOn +
                '}';
    }

    public String getId() {
        return id;
    }

    public Transactions toModel(CardRepository cardRepository, EstablishmentRepository establishmentRepository) {
        return new Transactions(UUID.fromString(this.id),
                this.value,
                this.establishment.toModel(establishmentRepository),
                this.card.toModel(cardRepository),
                effectiveOn);
    }
}
