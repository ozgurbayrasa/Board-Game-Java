package main.java.it.unibz.inf.pp.clash.model.snapshot.impl;

import main.java.it.unibz.inf.pp.clash.model.snapshot.Board;
import main.java.it.unibz.inf.pp.clash.model.snapshot.Hero;
import main.java.it.unibz.inf.pp.clash.model.snapshot.Snapshot;

import java.util.Optional;

import static main.java.it.unibz.inf.pp.clash.model.snapshot.Board.TileCoordinates;

public abstract class AbstractSnapshot implements Snapshot {

    protected final Board board;
    private final Hero firstHero;
    private final Hero secondHero;

    private Player activeplayer;
    private int actionsRemaining;
    protected TileCoordinates ongoingMove;

    public AbstractSnapshot(Hero firstHero, Hero secondHero, Board board, Player activeplayer, int actionsRemaining,
                            TileCoordinates ongoingMove) {
        this.board = board;
        this.firstHero = firstHero;
        this.secondHero = secondHero;
        this.activeplayer = activeplayer;
        this.actionsRemaining = actionsRemaining;
        this.ongoingMove = ongoingMove;
    }

    public Board getBoard() {
        return board;
    }

    @Override
    public Hero getHero(Player player) {
        return switch (player) {
            case FIRST -> firstHero;
            case SECOND -> secondHero;
        };
    }

    @Override
    public Player getActivePlayer() {
        return activeplayer;
    }

    @Override
    public Optional<TileCoordinates> getOngoingMove() {
        return Optional.ofNullable(ongoingMove);
    }

    @Override
    public int getNumberOfRemainingActions() {
        return actionsRemaining;
    }

}
