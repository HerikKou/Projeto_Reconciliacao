package ProjetoReconciliacao.Reconciliacao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import ProjetoReconciliacao.Reconciliacao.Model.ReconciliacaoModel;

@Repository
public interface ReconciliacaoRepository extends JpaRepository<ReconciliacaoModel, Long> {
    Optional<ReconciliacaoModel> findByTransacaoId(Long transacaoId);
}
