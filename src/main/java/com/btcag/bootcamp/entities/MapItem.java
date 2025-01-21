package com.btcag.bootcamp.entities;
import com.btcag.bootcamp.enums.MapItemType;
import jakarta.persistence.*;

@Entity(name = "MapItem")
@Table(name = "map_item")
public class MapItem {
    @Column(name = "map_item_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "type")
    private MapItemType type;
    @Column(name = "index")
    private int index;
    @ManyToOne
    @JoinColumn(name="map_id", nullable=false)
    private Map map;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MapItemType getType() {
        return type;
    }

    public void setType(MapItemType type) {
        this.type = type;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
