/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.persistance.EPSDAO;
import edu.eci.pdsw.persistence.impl.mappers.EPSMapper;
import edu.eci.pdsw.samples.entities.Eps;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.persistence.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author 2118270
 */
public class EPSDAOMyBATIS implements EPSDAO{
    @Inject
    EPSDAO emapper;

    @Override
    public List<Eps> loadAll() {
        try{
            List<Eps> epses = emapper.loadAll();
            return epses;
        }catch(Exception e){
            throw new PersistenceException("Error cargar EPS",e);
        }
    }

    @Override
    public void load() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadByID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
