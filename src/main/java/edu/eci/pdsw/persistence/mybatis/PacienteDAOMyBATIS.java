/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.persistance.PacienteDAO;
import edu.eci.pdsw.persistence.impl.mappers.EPSMapper;
import edu.eci.pdsw.persistence.impl.mappers.PacienteMapper;
import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Eps;
import edu.eci.pdsw.samples.entities.Paciente;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author 2118270
 */
public class PacienteDAOMyBATIS implements PacienteDAO {
    
    @Inject
    PacienteMapper pmapper;

    @Override
    public void loadAll() {
        
    }

    @Override
    public void load() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Paciente loadByID(int id , String tipoid) {
        Paciente p;
        try{
            p = pmapper.loadPacienteById(id, tipoid);
            return p;
            
        }catch(Exception e){
            throw new PersistenceException("Error al consultar paciente: " + id,e);
        }
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Transactional
    @Override
    public void update(Paciente p) throws PersistenceException{
        try{
            pmapper.updatePaciente(p);

        }catch(Exception e){
            throw new PersistenceException("Error al actualizar el paciente "+ p.getId(),e);
        }
    }
    
    
    
}
