package br.com.dio.model;

import br.com.dio.model.enums.GameStatusEnum;

import java.util.Collection;
import java.util.List;

import static br.com.dio.model.enums.GameStatusEnum.COMPLETE;
import static br.com.dio.model.enums.GameStatusEnum.INCOMPLETE;
import static br.com.dio.model.enums.GameStatusEnum.NON_STARTED;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Board {

    private final List<List<Space>> spaces;

    public Board(List<List<Space>> spaces) {
        this.spaces = spaces;
    }

    public boolean changeValue(int col, int row, int value) {
        Space space = spaces.get(col).get(row);

        if(space.isFixed()) return false;

        space.setActual(value);
        return true;
    }

    public boolean clearValue(int col, int row) {
        Space space = spaces.get(col).get(row);

        if(space.isFixed()) return false;

        space.clearSpace();
        return true;
    }

    public void reset(){
        spaces.forEach(s -> s.forEach(Space::clearSpace));
    }

    public boolean gameIsFinished() {
        return !hasErros() && getStatus() == COMPLETE;
    }

    public boolean hasErros(){
        if(getStatus() == NON_STARTED)return false;

        return spaces.stream().flatMap(Collection::stream)
                .anyMatch(x -> nonNull(x.getActual()) && !x.getActual().equals(x.getExpected()));
    }

    public List<List<Space>> getSpaces() {
        return spaces;
    }

    public GameStatusEnum getStatus() {
        if(
                spaces.stream()
                        .flatMap(Collection::stream)
                        .noneMatch(x -> !x.isFixed()&& nonNull(x.getActual()))
        ){
            return NON_STARTED;
        }

        return spaces.stream()
                .flatMap(Collection::stream)
                .anyMatch(x -> isNull(x.getActual()))
                ?INCOMPLETE:COMPLETE;
    }
}
