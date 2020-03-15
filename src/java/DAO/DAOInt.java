/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author kyrik
 */
public interface DAOInt<T> {
  
    public void create(T obj);
    
    public void delete(T obj);
    
    public T getById (int id);
    
    public List<T> getAll();
    
    public void update(T obj);
    
    
}
