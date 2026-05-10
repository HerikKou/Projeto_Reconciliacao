package ProjetoReconciliacao.Reconciliacao.Model;

import java.math.BigDecimal;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import ProjetoReconciliacao.Reconciliacao.Enum.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@Table(name = "reconciliacao")
public class ReconciliacaoModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NotNull(message = "O campo transacaoId é obrigatório")
    private Long transacaoId;
   @NotNull(message = "O campo status_Pagamento é obrigatório")
    @Enumerated(EnumType.STRING)
    private PagamentoStatus status_Pagamento;
   @NotNull(message = "O campo status_Antifraude é obrigatório")
   @Enumerated(EnumType.STRING)

    private AntifraudeStatus status_Antifraude;
    @NotNull(message = "O campo valor_transacao é obrigatório")
    private BigDecimal valor_transacao;
    @NotBlank(message = "O campo detalhes é obrigatório")
    private String detalhes;
    public ReconciliacaoModel() {
    }
    public ReconciliacaoModel(Long id,Long transacaoId, PagamentoStatus status_Pagamento, AntifraudeStatus status_Antifraude, BigDecimal valor_transacao, String detalhes) {
        this.id = id;
        this.transacaoId = transacaoId;
        this.status_Pagamento = status_Pagamento;
        this.status_Antifraude = status_Antifraude;
        this.valor_transacao = valor_transacao;
        this.detalhes = detalhes;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getTransacaoId() {
        return transacaoId;
    }
    public void setTransacaoId(Long transacaoId) {
        this.transacaoId = transacaoId;
    }
    public PagamentoStatus getStatus_Pagamento() {
        return status_Pagamento;
    }
    public void setStatus_Pagamento(PagamentoStatus status_Pagamento) {
        this.status_Pagamento = status_Pagamento;
    }
    public AntifraudeStatus getStatus_Antifraude() {
        return status_Antifraude;
    }
    public void setStatus_Antifraude(AntifraudeStatus status_Antifraude) {
        this.status_Antifraude = status_Antifraude;
    }
    public BigDecimal getValor_transacao() {
        return valor_transacao;
    }
    public void setValor_transacao(BigDecimal valor_transacao) {
        this.valor_transacao = valor_transacao;
    }
    public String getDetalhes() {
        return detalhes;
    }
    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
    
   
}
