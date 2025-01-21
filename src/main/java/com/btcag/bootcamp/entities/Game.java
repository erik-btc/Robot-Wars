package com.btcag.bootcamp.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Game")
@Table(name = "game")
public class Game {
    @Column(name = "game_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "map_id", nullable = false)
    private Map map;
    @Column(name = "moves")
    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Move> moves = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void addMove(Move move) {
        this.moves.add(move);
        move.setGame(this);
    }
}
