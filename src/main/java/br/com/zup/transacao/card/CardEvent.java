package br.com.zup.transacao.card;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public class CardEvent {

    @JsonProperty("id")
    private String id;

    @JsonProperty("email")
    private String email;

    @Override
    public String toString() {
        return "CardEvent{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Card toModel(CardRepository cardRepository) {
        Optional<Card> card = cardRepository.findByCardNumber(this.id);
        if(card.isEmpty()){
            System.out.println("Não existe cartão");
            return new Card(this.id, this.email);
        }
        return card.get();
    }
}
