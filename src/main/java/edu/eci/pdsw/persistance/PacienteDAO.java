/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistance;

/**
 *
 * @author 2118270
 */
public interface PacienteDAO {
    public void loadAll();
    public void load();
    public void loadByID();
    public void save();
    public void update();
}
