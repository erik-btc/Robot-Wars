package com.btcag.bootcamp.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity(name = "Map")
@Table(name = "map")
public class Map {
    @Column(name = "map_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "row_length")
    private int rowLength;
    @Column(name = "size")
    private int size;
    @Column(name = "max-player-count")
    private int maxPlayerCount;
    @OneToMany(mappedBy = "map", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MapItem> mapItems;
    @OneToMany(mappedBy = "map", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Game> games = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRowLength() {
        return rowLength;
    }

    public void setRowLength(int rowLength) {
        this.rowLength = rowLength;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMaxPlayerCount() {
        return maxPlayerCount;
    }

    public void setMaxPlayerCount(int maxPlayerCount) {
        this.maxPlayerCount = maxPlayerCount;
    }

    public List<MapItem> getMapItems() {
        return mapItems;
    }

    public void setMapItems(List<MapItem> mapItems) {
        this.mapItems = mapItems;
    }

    public List<Game> getGames() {
        return games;
    }

    public void addGame(Game game) {
        this.games.add(game);
        game.setMap(this);
    }
}
