package de.exxcellent.challenge.service;

import de.exxcellent.challenge.bo.BaseBO;
import de.exxcellent.challenge.factory.BaseBOFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CsvReader implements Reader {

    @Override
    public List<BaseBO> read(String dataFile, String objectType) {
        String[] data = dataFile.split(System.lineSeparator());
        return Arrays.stream(data).skip(1)
                .map(dataItem -> BaseBOFactory.getBaseObject(dataItem, objectType))
                .collect(Collectors.toList());
    }
}
