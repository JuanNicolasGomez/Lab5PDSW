/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.mybatis;

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

    @Override
    public void loadAll() {
        
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
    
    @Transactional
    @Override
    public void update(PacienteMapper pmap, Paciente p) throws PersistenceException{
        try{
            
            PacienteDAO.updatePaciente(p);
            Set<Consulta> consp= p.getConsultas();
            for (Consulta i: consp){
                if (i.getId()==0){
                    System.out.println("looool");
                    pmapper.insertConsulta(i,p.getId(),p.getTipoId(),i.getCosto());
                }
            }


        }catch(Exception e){
            throw new PersistenceException("Error al actualizar el paciente "+ p.getId(),e);
        }
    }
    
    
    /**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getLocalizedMessage(),e);
            }
        }
        return sqlSessionFactory;
    }
    
    
}
