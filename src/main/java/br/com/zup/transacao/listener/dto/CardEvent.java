package br.com.zup.transacao.listener.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

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
}
