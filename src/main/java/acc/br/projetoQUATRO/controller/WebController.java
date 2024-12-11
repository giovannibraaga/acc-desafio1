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

    @ResponseBody
    @GetMapping("/score")
    public Score score() {
        return scoreService.score();
    }

    @GetMapping("/teste")
    public String teste(@RequestParam(name = "escolha") String aEscolha, Model model) {
        return gameService.game(aEscolha, model);
    }

    @DeleteMapping("/zerar")
    public String zerar() {
        scoreService.zerarScore();
        return "resultado";
    }
}
