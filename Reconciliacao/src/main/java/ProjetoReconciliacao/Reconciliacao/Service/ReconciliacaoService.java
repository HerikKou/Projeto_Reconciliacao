package ProjetoReconciliacao.Reconciliacao.Service;

import org.springframework.stereotype.Service;

import ProjetoReconciliacao.Reconciliacao.DTO.ReconciliacaoEntradaDto;
import ProjetoReconciliacao.Reconciliacao.DTO.ReconciliacaoRespostaDTO;
import ProjetoReconciliacao.Reconciliacao.Enum.AntifraudeStatus;
import ProjetoReconciliacao.Reconciliacao.Enum.PagamentoStatus;
import ProjetoReconciliacao.Reconciliacao.Exception.NaoEncontrado;
import ProjetoReconciliacao.Reconciliacao.Model.ReconciliacaoModel;
import ProjetoReconciliacao.Reconciliacao.Repository.ReconciliacaoRepository;
import org.springframework.cache.annotation.Cacheable;
@Service
public class ReconciliacaoService {
    private final ReconciliacaoRepository reconciliacaoRepository;
    public ReconciliacaoService(ReconciliacaoRepository reconciliacaoRepository) {
        this.reconciliacaoRepository = reconciliacaoRepository;
    }

    public ReconciliacaoRespostaDTO criarReconciliacao(ReconciliacaoEntradaDto entradaDto){
        ReconciliacaoModel model = new ReconciliacaoModel();
        model.setTransacaoId(entradaDto.getTransacaoId());
        model.setStatus_Pagamento(entradaDto.getStatus_Pagamento());
        model.setStatus_Antifraude(entradaDto.getStatus_Antifraude());
	model.setValor_transacao(entradaDto.getValor_transacao());
        model.setDetalhes(gerarDetalhes(entradaDto.getStatus_Antifraude(), entradaDto.getStatus_Pagamento()));
        ReconciliacaoModel salvar = reconciliacaoRepository.save(model);
        return new ReconciliacaoRespostaDTO(salvar.getTransacaoId(), salvar.getStatus_Pagamento(), salvar.getStatus_Antifraude(), salvar.getValor_transacao(), salvar.getDetalhes());
    } 


    private String gerarDetalhes(AntifraudeStatus antifraude , PagamentoStatus pagamento){
        if(antifraude == AntifraudeStatus.APROVADO && pagamento == PagamentoStatus.CONCLUIDO){
            return "Transação aprovada e concluída com sucesso.";
        } else if(antifraude == AntifraudeStatus.REJEITADO && pagamento == PagamentoStatus.CANCELADO){
            return "Transação rejeitada e cancelada devido a suspeita de fraude.";
        } else if(antifraude == AntifraudeStatus.PENDENTE && pagamento == PagamentoStatus.PENDENTE){
            return "Transação em análise, aguardando resultado da verificação antifraude.";
        } return "Status de transação não reconhecido.";
}


     @Cacheable(value = "reconciliacoes", key = "#transacaoId")
    public ReconciliacaoRespostaDTO obterReconciliacaoPorTransacaoId(Long transacaoId){
        ReconciliacaoModel model = reconciliacaoRepository.findByTransacaoId(transacaoId)
                .orElseThrow(() -> new NaoEncontrado("Reconciliacao não encontrada para o ID da transação: " + transacaoId));
     
        return new ReconciliacaoRespostaDTO(model.getTransacaoId(), model.getStatus_Pagamento(), model.getStatus_Antifraude(), model.getValor_transacao(), model.getDetalhes());
    }
}
