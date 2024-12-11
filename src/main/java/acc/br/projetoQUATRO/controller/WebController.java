package acc.br.projetoQUATRO.controller;

import acc.br.projetoQUATRO.model.Score;
import acc.br.projetoQUATRO.service.GameService;
import acc.br.projetoQUATRO.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    @Autowired
    private GameService gameService;

    @Autowired
    private ScoreService scoreService;

    /**
     * Endpoint para recuperar o score atual
     *
     * @return o score atual
     */
    @ResponseBody
    @GetMapping("/score")
    public Score score() {
        return scoreService.score();
    }

    /**
     * Endpoint para jogar o jogo
     *
     * @param aEscolha a escolha feita pelo jogador
     * @param model    o modelo para adicionar os atributos necessários para a view
     * @return a view "resultado" com os dados
     */
    @GetMapping("/teste")
    public String teste(@RequestParam(name = "escolha") String aEscolha, Model model) {
        return gameService.game(aEscolha, model);
    }

    /**
     * Funcao para zerar o score
     *
     * @return A view "resultado"
     */
    @DeleteMapping("/zerar")
    public String zerar() {
        scoreService.zerarScore();
        return "resultado";
    }
}
