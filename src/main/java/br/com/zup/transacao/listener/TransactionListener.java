package br.com.zup.transacao.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionListener {

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void listener(TransactionEvent transactionEvent){
        System.out.println(transactionEvent);
    }
}
