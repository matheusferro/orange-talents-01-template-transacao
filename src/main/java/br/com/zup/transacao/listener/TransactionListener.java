package br.com.zup.transacao.listener;

import br.com.zup.transacao.establishment.EstablishmentRepository;
import br.com.zup.transacao.transaction.TransactionEvent;
import br.com.zup.transacao.card.CardRepository;
import br.com.zup.transacao.transaction.Transactions;
import br.com.zup.transacao.transaction.TransactionsRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Component
public class TransactionListener {

    private CardRepository cardRepository;

    private TransactionsRepository transactionsRepository;

    private EstablishmentRepository establishmentRepository;
    public TransactionListener(TransactionsRepository transactionsRepository,
                               CardRepository cardRepository,
                               EstablishmentRepository establishmentRepository) {
        this.cardRepository = cardRepository;
        this.transactionsRepository = transactionsRepository;
        this.establishmentRepository = establishmentRepository;
    }

    @Transactional
    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void listener(TransactionEvent transactionEvent){
        Optional<Transactions> transactionsOptional = transactionsRepository.findByTransactionId(UUID.fromString(transactionEvent.getId()));
        if(transactionsOptional.isEmpty()) {
            Transactions transactions = transactionEvent.toModel(cardRepository, establishmentRepository);
            transactionsRepository.save(transactions);
        }
    }
}
