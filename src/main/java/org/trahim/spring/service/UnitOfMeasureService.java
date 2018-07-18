package org.trahim.spring.service;

import org.trahim.spring.commands.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {
    Set<UnitOfMeasureCommand> listOfAllUoms();
}
