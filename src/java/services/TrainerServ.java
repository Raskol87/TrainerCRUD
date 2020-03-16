/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAO.DAOInt;
import DAO.TrainerDAO;
import entities.Trainer;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author kyrik
 */
public class TrainerServ implements ServiceInt<Trainer> {

    protected DAOInt<Trainer> trainerDAO = new TrainerDAO();

    @Override
    public void create(Trainer tr) {
        trainerDAO.create(tr);
    }

    @Override
    public void create(List<Trainer> listOfTr) {
        listOfTr.forEach(tr -> trainerDAO.create(tr));
    }

    @Override
    public void delete(Trainer tr) {
        trainerDAO.delete(tr);
    }

    @Override
    public void delete(List<Trainer> listOfTr) {
        listOfTr.forEach(tr -> trainerDAO.delete(tr));
    }

    @Override
    public void update(Trainer tr) {
        trainerDAO.update(tr);
    }

    @Override
    public void update(List<Trainer> listOfTr) {
        listOfTr.forEach(tr -> trainerDAO.update(tr));
    }

    @Override
    public List<Trainer> getAll() {
        return trainerDAO.getAll();
    }

    @Override
    public boolean isSimilar(Trainer tr) {

        Map trainerCheckMapping = new HashMap<String, String>();
        trainerCheckMapping.put(TrainerDAO.FNAME, tr.getFirstName());
        trainerCheckMapping.put(TrainerDAO.LNAME, tr.getLastName());

        List<Trainer> queryResult = trainerDAO.getQueryResult(
                trainerCheckMapping);

        return (queryResult.size() > 0)
               ? true
               : false;
    }

    public List<Trainer> filterBeans(List<Trainer> updatedValues,
                                     List<Trainer> toBeUpdated) {
        Set<Integer> ids = updatedValues.stream().map(tr -> tr.getIdTrainer()).
                collect(Collectors.toSet());
        return toBeUpdated.stream().
                filter(tr -> ids.contains(tr.getIdTrainer())).collect(
                Collectors.toList());

    }

}
