package de.exxcellent.challenge.service;

import de.exxcellent.challenge.bo.BaseBO;

import java.util.List;

public interface Reader {
    List<BaseBO> read(String data, String objectType);
}
