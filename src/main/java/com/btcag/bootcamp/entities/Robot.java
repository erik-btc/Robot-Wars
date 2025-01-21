package com.btcag.bootcamp.entities;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Robot")
@Table(name = "robot")
public class Robot {
    @Column(name = "robot_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "health")
    private int health;
    @Column(name = "attack_damage")
    private int attackDamage;
    @Column(name = "attack_range")
    private int attackRange;
    @Column(name = "movement_range")
    private int movementRange;
    @OneToMany(mappedBy = "robot", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RobotManipulator> robotManipulator = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public int getMovementRange() {
        return movementRange;
    }

    public void setMovementRange(int movementRange) {
        this.movementRange = movementRange;
    }

    public List<RobotManipulator> getRobotManipulator() {
        return robotManipulator;
    }

    public void setRobotManipulator(List<RobotManipulator> robotManipulator) {
        this.robotManipulator = robotManipulator;
    }
}
