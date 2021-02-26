package br.com.zup.transacao.establishment;

import br.com.zup.transacao.transaction.Transactions;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Establishment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String establishmentName;
    @NotBlank
    private String establishmentCity;
    @NotBlank
    private String establishmentAddress;
    @OneToMany(mappedBy = "establishment", cascade = CascadeType.ALL)
    private Set<Transactions> transactionsSet = new HashSet<>();

    @Deprecated
    Establishment(){}

    public Establishment(@NotBlank String name, @NotBlank String city, @NotBlank String address) {
        this.establishmentName = name;
        this.establishmentCity = city;
        this.establishmentAddress = address;
    }
}
