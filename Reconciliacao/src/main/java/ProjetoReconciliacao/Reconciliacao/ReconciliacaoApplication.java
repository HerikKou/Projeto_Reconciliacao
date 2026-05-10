package ProjetoReconciliacao.Reconciliacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class ReconciliacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReconciliacaoApplication.class, args);
	}

}