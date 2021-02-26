package br.com.zup.transacao.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionsResponse {

    /**
     * Verificar se realmente vai ser mostrado esses dados.
     */
    @JsonProperty("id")
    private String transactionId;
    @JsonProperty("valor")
    private BigDecimal transactionValue;
    @JsonProperty("estabelecimento")
    private String establishment;
    @JsonProperty("cartao")
    private String cardNumber;
    @JsonProperty("efetivadaEm")
    private LocalDateTime effectiveOn;

    public TransactionsResponse(Transactions transactions) {
        this.transactionId = transactions.getTransactionId().toString();
        this.transactionValue = transactions.getTransactionValue();
        this.establishment = transactions.getEstablishment().getEstablishmentName();
        this.cardNumber = transactions.getCard().getCardNumber();
        this.effectiveOn = transactions.getEffectiveOn();
    }
}
