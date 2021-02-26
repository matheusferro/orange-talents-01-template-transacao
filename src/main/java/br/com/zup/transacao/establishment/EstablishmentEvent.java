package br.com.zup.transacao.establishment;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

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

    public Establishment toModel(EstablishmentRepository establishmentRepository) {
        Optional<Establishment> establishmentOptional = establishmentRepository.findByEstablishmentNameAndEstablishmentCityAndEstablishmentAddress(this.name, this.city, this.address);
        if(establishmentOptional.isEmpty()) {
            return new Establishment(this.name, this.city, this.address);
        }
        return establishmentOptional.get();
    }
}
