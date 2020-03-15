/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import java.util.List;
import java.util.Map;

/**
 *
 * @author kyrik
 */
public interface ServiceInt<T> {
       
    public void create(T obj);

    public void create(List<T> listOfT);

    public void delete(T obj);

    public void delete(List<T> listOfT);

    public void update(T obj);

    public void update(List<T> listOfT);

    public List<T> getAll();

    public boolean isSimilar(T obj);
    
}
