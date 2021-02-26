package br.com.zup.transacao.listener.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
}
