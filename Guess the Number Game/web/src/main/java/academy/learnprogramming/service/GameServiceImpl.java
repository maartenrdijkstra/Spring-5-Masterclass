package academy.learnprogramming.service;

import academy.learnprogramming.Game;
import academy.learnprogramming.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class GameServiceImpl implements GameService {

    // == constructor ==
    @Autowired
    public GameServiceImpl(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    // == fields ==
    public final Game game;
    public final MessageGenerator messageGenerator;

    // == public methods ==
    @PostConstruct
    public void init() {
        log.info("number = {}",game.getNumber());
        log.info("mainMessage = {}", messageGenerator.getMainMessage());

    }

    @Override
    public boolean isGameOver() {
        if(game.isGameWon() || game.isGameLost()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getMainMessage() {
        return messageGenerator.getMainMessage();
    }

    @Override
    public String getResultMessage() {
        return messageGenerator.getResultMessage();
    }

    @Override
    public void checkGuess(int guess) {
        game.setGuess(guess);
        game.check();
    }

    @Override
    public void reset() {
        game.reset();
    }
}
