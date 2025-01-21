package com.btcag.bootcamp.entities;
import com.btcag.bootcamp.enums.Alignment;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "RobotManipulator")
@Table(name = "robot-manipulator")
public class RobotManipulator {
    @Column(name = "robot_manipulator_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "move_id", nullable = false)
    private Move move;
    @Column(name = "align")
    @Enumerated(EnumType.STRING)
    private Alignment align;
    @ManyToOne
    @JoinColumn(name = "robot_id", nullable = false)
    private Robot robot;
    @OneToMany(mappedBy = "robotManipulator", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items = new ArrayList<>();
    @Column(name = "health_manipulator")
    private int healthManipulator;
    @Column(name = "attack_damage_manipulator")
    private int attackDamageManipulator;
    @Column(name = "attack_range_manipulator")
    private int attackRangeManipulator;
    @Column(name = "movement_range_manipulator")
    private int movementRangeManipulator;
    @Column(name = "current_map_array_index")
    private int currentMapArrayIndex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public Alignment getAlign() {
        return align;
    }

    public void setAlign(Alignment align) {
        this.align = align;
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getHealthManipulator() {
        return healthManipulator;
    }

    public void setHealthManipulator(int healthManipulator) {
        this.healthManipulator = healthManipulator;
    }

    public int getAttackDamageManipulator() {
        return attackDamageManipulator;
    }

    public void setAttackDamageManipulator(int attackDamageManipulator) {
        this.attackDamageManipulator = attackDamageManipulator;
    }

    public int getAttackRangeManipulator() {
        return attackRangeManipulator;
    }

    public void setAttackRangeManipulator(int attackRangeManipulator) {
        this.attackRangeManipulator = attackRangeManipulator;
    }

    public int getMovementRangeManipulator() {
        return movementRangeManipulator;
    }

    public void setMovementRangeManipulator(int movementRangeManipulator) {
        this.movementRangeManipulator = movementRangeManipulator;
    }

    public int getCurrentMapArrayIndex() {
        return currentMapArrayIndex;
    }

    public void setCurrentMapArrayIndex(int currentMapArrayIndex) {
        this.currentMapArrayIndex = currentMapArrayIndex;
    }
}
