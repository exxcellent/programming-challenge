package de.exxcellent.challenge.service.readers;

import de.exxcellent.challenge.bo.BaseBO;
import de.exxcellent.challenge.constants.Domain;
import de.exxcellent.challenge.factory.BaseBOFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CsvReader implements Reader {

    @Override
    public List<BaseBO> read(String csvDataFile, Domain domain) {
        String[] csvData = csvDataFile.split(System.lineSeparator());
        return Arrays.stream(csvData).skip(1)
                .map(dataItem -> BaseBOFactory.getBaseObject(dataItem, domain))
                .collect(Collectors.toList());
    }
}
