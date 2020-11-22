package de.exxcellent.challenge.service.readers;

import de.exxcellent.challenge.bo.BaseBO;
import de.exxcellent.challenge.constants.Domain;

import java.util.List;

public interface Reader {
    List<? extends BaseBO> read(String data, Domain domain);
}
