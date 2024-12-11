package acc.br.projetoQUATRO.service;

import acc.br.projetoQUATRO.model.Score;
import acc.br.projetoQUATRO.repositories.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class GameService {

    @Autowired
    private ScoreRepository scoreRepository;

    public String game(String aEscolha, Model model) {
        Score score = scoreRepository.findById(1).orElse(new Score(0, 0, 0));
        String saida = "";
        switch (aEscolha) {
            case "pedra":
                saida = "empate";
                score.setEmpates(score.getEmpates() + 1);
                break;
            case "papel":
                saida = "vitoria";
                score.setVitorias(score.getVitorias() + 1);
                break;
            case "tesoura":
                saida = "derrota";
                score.setDerrotas(score.getDerrotas() + 1);
                break;
        }
        model.addAttribute("saida", saida);
        model.addAttribute("aEscolha", aEscolha);
        model.addAttribute("vitorias", score.getVitorias());
        model.addAttribute("empates", score.getEmpates());
        model.addAttribute("derrotas", score.getDerrotas());
        scoreRepository.save(score);
        return "resultado";
    }
}
