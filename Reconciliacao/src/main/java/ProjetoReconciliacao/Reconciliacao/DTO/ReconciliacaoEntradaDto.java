package ProjetoReconciliacao.Reconciliacao.DTO;

import java.math.BigDecimal;

import ProjetoReconciliacao.Reconciliacao.Enum.AntifraudeStatus;
import ProjetoReconciliacao.Reconciliacao.Enum.PagamentoStatus;


import jakarta.validation.constraints.NotNull;

public class ReconciliacaoEntradaDto {
    @NotNull(message = "O campo transacaoId é obrigatório")
    private Long transacaoId;
    @NotNull(message = "O campo status_Pagamento é obrigatório")
    private PagamentoStatus status_Pagamento;
    @NotNull(message = "O campo status_Antifraude é obrigatório")
    private AntifraudeStatus status_Antifraude;
    @NotNull(message = "O campo valor_transacao é obrigatório")
    private BigDecimal valor_transacao;
    public ReconciliacaoEntradaDto() {
    }
    public ReconciliacaoEntradaDto(Long transacaoId, PagamentoStatus status_Pagamento, AntifraudeStatus status_Antifraude, BigDecimal valor_transacao) {
        this.transacaoId = transacaoId;
        this.status_Pagamento = status_Pagamento;
        this.status_Antifraude = status_Antifraude;
        this.valor_transacao = valor_transacao;
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
    
}
