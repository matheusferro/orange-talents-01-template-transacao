package br.com.zup.transacao.transaction;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
    Optional<Transactions> findByTransactionId(UUID transactionId);

    Optional<Set<Transactions>> findTop10ByIdOrderByEffectiveOnDesc(Long id);
}
