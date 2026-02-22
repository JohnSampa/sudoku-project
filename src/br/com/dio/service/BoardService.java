package br.com.dio.service;

import br.com.dio.model.Board;
import br.com.dio.model.Space;
import br.com.dio.model.enums.GameStatusEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BoardService {

    private final static int BOARD_LIMIT = 9;

    private final Board board;

    public BoardService(Map<String,String> gameConfig) {
        this.board = new Board(initBoard(gameConfig));
    }

    public List<List<Space>> getSpaces() {
        return this.board.getSpaces();
    }

    public void reset(){
        this.board.reset();
    }

    public boolean hasErros() {
        return this.board.hasErros();
    }

    public GameStatusEnum getStatus() {
        return this.board.getStatus();
    }

    public boolean gameIsFinished() {
        return this.board.gameIsFinished();
    }

    private List<List<Space>> initBoard(Map<String, String> gameConfig) {
        List<List<Space>> spaces = new ArrayList<>();

        for (int i = 0; i < BOARD_LIMIT; i++) {
            spaces.add(new ArrayList<>());
            for (int j = 0; j < BOARD_LIMIT; j++) {
                String positionConfig = gameConfig.get("%s,%s".formatted(i,j));
                int expected = Integer.parseInt(positionConfig.split(",")[0]);
                boolean fixed = Boolean.parseBoolean(positionConfig.split(",")[1]);

                spaces.get(i).add(new Space(expected, fixed));
            }
        }

        return spaces;
    }
}
