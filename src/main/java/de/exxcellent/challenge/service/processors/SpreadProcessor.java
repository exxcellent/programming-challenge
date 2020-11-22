package de.exxcellent.challenge.service.processors;

import de.exxcellent.challenge.bo.BaseBO;

import java.util.List;

public interface SpreadProcessor {
    BaseBO calculateSpread(List<? extends BaseBO> baseObjects);

    default int getDifference(Integer num1, Integer num2) {
        return Math.abs(num1 - num2);
    }
}
