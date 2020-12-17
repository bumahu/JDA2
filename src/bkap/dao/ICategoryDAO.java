/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao;

import bkap.entities.Category;
import java.util.List;

/**
 *
 * @author light
 */
public interface ICategoryDAO {
    List<Category> toList();
    Category find(int id);
    void add(Category entity);
    void edit(Category entity);
    void remove(int id);
}
