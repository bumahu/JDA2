/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao;

import bkap.entities.Category;
import bkap.util.SqlConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author light
 */
public class CategoryDAOImp implements ICategoryDAO{

    @Override
    public List<Category> toList() {
        List<Category> data = new ArrayList<>();
        ResultSet rs = SqlConnection.execute("SELECT * FROM Category", null);
        try {
            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setStatus(rs.getBoolean("status"));
                data.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    @Override
    public Category find(int id) {
        ResultSet rs = SqlConnection.execute("SELECT * FROM Category WHERE id = ?", id);
        try {
            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setStatus(rs.getBoolean("status"));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void add(Category entity) {
        SqlConnection.executeUpdate("INSERT INTO Category VALUES(?,?)", entity.getName(), entity.isStatus());
    }

    @Override
    public void edit(Category entity) {
        SqlConnection.executeUpdate("UPDATE Category SET name = ?, status = ? WHERE id = ?", entity.getName(), entity.isStatus(), entity.getId());
    }

    @Override
    public void remove(int id) {
        SqlConnection.executeUpdate("DELETE Category WHERE id = ?", id);
    }
    
}
