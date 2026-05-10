package ProjetoReconciliacao.Reconciliacao.DTO;

import java.math.BigDecimal;

import ProjetoReconciliacao.Reconciliacao.Enum.AntifraudeStatus;
import ProjetoReconciliacao.Reconciliacao.Enum.PagamentoStatus;


public class ReconciliacaoRespostaDTO {
    private Long transacaoId;
    private PagamentoStatus status_Pagamento;
    private AntifraudeStatus status_anitfraude;
    private BigDecimal valor_transacao;
    private String detalhes;
    public ReconciliacaoRespostaDTO() {
}
 public ReconciliacaoRespostaDTO(Long transacaoId, PagamentoStatus status_Pagamento, AntifraudeStatus status_anitfraude, BigDecimal valor_transacao, String detalhes) {
    this.transacaoId = transacaoId;
    this.status_Pagamento = status_Pagamento;
    this.status_anitfraude = status_anitfraude;
    this.valor_transacao = valor_transacao;
    this.detalhes = detalhes;

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
 public AntifraudeStatus getStatus_Anitfraude() {
    return status_anitfraude;
 }
 public void setStatus_Anitfraude(AntifraudeStatus status_anitfraude) {
    this.status_anitfraude = status_anitfraude;
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
