package br.com.zup.transacao.listener.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EstablishmentEvent {

    @JsonProperty("nome")
    private String name;

    @JsonProperty("cidade")
    private String city;

    @JsonProperty("endereco")
    private String address;

    @Override
    public String toString() {
        return "EstablishmentEvent{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
