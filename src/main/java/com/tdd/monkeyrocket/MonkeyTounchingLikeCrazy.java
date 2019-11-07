package com.tdd.monkeyrocket;

import java.util.Random;

import static com.tdd.monkeyrocket.ControlJavaPanelSetup.*;

interface MonkeyTounchingLikeCrazy {
    default ControlJavaPanelSetup monkeyTouching() {
        Random random = new Random();
        switch (random.nextInt(4)) {
            case 0:
                return DefaultSetup;
            case 1:
                return MediumSetup;
            case 2:
                return ComplexSetup;
            case 3:
                return CrazySetup;
            default:
                monkeyTouching();
        }
        return null;
    }
}