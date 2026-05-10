package ProjetoReconciliacao.Reconciliacao.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjetoReconciliacao.Reconciliacao.DTO.ReconciliacaoEntradaDto;
import ProjetoReconciliacao.Reconciliacao.DTO.ReconciliacaoRespostaDTO;
import ProjetoReconciliacao.Reconciliacao.Service.ReconciliacaoService;

@RestController
@RequestMapping("/reconciliacao")
public class ReconciliacaoContoller {
    
    private final ReconciliacaoService reconciliacaoService;
    public ReconciliacaoContoller(ReconciliacaoService reconciliacaoService) {
        this.reconciliacaoService = reconciliacaoService;
    }

    @PostMapping("/criar")
    public ResponseEntity<ReconciliacaoRespostaDTO> reconciliar(@RequestBody ReconciliacaoEntradaDto entradaDto) {
        ReconciliacaoRespostaDTO resposta = reconciliacaoService.criarReconciliacao(entradaDto);
        return ResponseEntity.status(201).body(resposta);
    }

    @GetMapping("/transacao/{transacaoId}")
    public ResponseEntity<ReconciliacaoRespostaDTO> obterReconciliacaoPorTransacaoId(@PathVariable Long transacaoId) {
        ReconciliacaoRespostaDTO resposta = reconciliacaoService.obterReconciliacaoPorTransacaoId(transacaoId);
        return ResponseEntity.ok(resposta);
    }

}
