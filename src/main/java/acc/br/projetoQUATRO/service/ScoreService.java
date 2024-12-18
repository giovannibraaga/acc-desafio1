package acc.br.projetoQUATRO.service;

import acc.br.projetoQUATRO.model.Score;
import acc.br.projetoQUATRO.repositories.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    /**
     * Tenta recuperar o score do repositório. Se não existir, cria um novo score com os valores zerados.
     *
     * @return o score recuperado ou criado
     */
    @Transactional
    public Score score() {
        Score score;
        try {
            score = scoreRepository.findById(1).get();
        } catch (Exception e) {
            score = new Score(0, 0, 0);
            scoreRepository.save(score);
        }
        return score;
    }

    /**
     * Zera o score do jogador.
     * */
    @Transactional
    public void zerarScore() {
        Score score = scoreRepository.findById(1).get();
        score.setDerrotas(0);
        score.setEmpates(0);
        score.setVitorias(0);
        scoreRepository.save(score);
    }
}
