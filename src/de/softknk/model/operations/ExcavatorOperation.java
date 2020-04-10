package de.softknk.model.operations;

import de.softknk.main.SoftknkioApp;
import de.softknk.model.util.Loader;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class ExcavatorOperation extends Operation {

    public static final String DEFAULT = "operations/excavator.png";
    private int points_per_second;

    public ExcavatorOperation(int currentLevel) {
        super(Loader.loadImage(DEFAULT), currentLevel);
        doOperation();
    }

    @Override
    public void init() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), actionEvent -> SoftknkioApp.matchfield.getPlayer().increaseScore(points_per_second)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    @Override
    public int getPrice() {
        return (super.getLevel() + 1) * 8000;
    }

    @Override
    public void doOperation() {
        points_per_second = super.getLevel() * 50;
    }

    @Override
    public String operationName() {
        return "EXCAVATOR";
    }

    public int getPointsPerSecond() {
        return points_per_second;
    }
}