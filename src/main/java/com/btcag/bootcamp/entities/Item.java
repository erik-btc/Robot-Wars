package com.btcag.bootcamp.entities;
import com.btcag.bootcamp.enums.ItemType;
import jakarta.persistence.*;


@Entity(name = "Item")
@Table(name = "item")
public class Item {
    @Column(name = "item_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "item_type")
    @Enumerated(EnumType.STRING)
    private ItemType itemType;
    @Column(name = "manipulation_value")
    private int manipulationValue;
    @Column(name = "duration")
    private int duration;
    @ManyToOne
    @JoinColumn(name = "robot_manipulator_id", nullable = false)
    private RobotManipulator robotManipulator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public int getManipulationValue() {
        return manipulationValue;
    }

    public void setManipulationValue(int manipulationValue) {
        this.manipulationValue = manipulationValue;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public RobotManipulator getRobotManipulator() {
        return robotManipulator;
    }

    public void setRobotManipulator(RobotManipulator robotManipulator) {
        this.robotManipulator = robotManipulator;
    }

}
