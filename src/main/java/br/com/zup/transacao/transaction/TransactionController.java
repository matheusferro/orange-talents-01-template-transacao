package br.com.zup.transacao.transaction;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class TransactionController {

    private TransactionsRepository transactionsRepository;

    public TransactionController(TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }

    @GetMapping("/v1/transaction/{cardId}")
    public ResponseEntity consultTransactions(@PathVariable("cardId") Long cardId){
        Optional<Set<Transactions>> transactionsList = transactionsRepository.findTop10ByIdOrderByEffectiveOnDesc(cardId);
        if(transactionsList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        List transactionResponseList = new ArrayList<>();
        transactionsList.get().forEach(transaction ->
                transactionResponseList.add(new TransactionsResponse(transaction))
        );
        return ResponseEntity.ok(transactionResponseList);
    }
}
