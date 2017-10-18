/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Eps;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.services.ExcepcionServiciosPacientes;
import edu.eci.pdsw.samples.services.impl.ServiciosPacientesImpl;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Diseño de pruebas 
 * 
 * Clases de equivalencia:
 *     
 *      CE1:agregar consulta de un paciente no registrado
 *          Resultado esperado: ExcepcionServiciosPacientes
 * 
 *      CE2:agregar consulta de un paciente ya registrado
 *          Resultado:no se lanza ninguna excepcion
 * 
 *      CE3: agregar paciente cuando ya registrado
 *          Resultado: ExcepcionServiciosPacientes
 *      CE4 : agregar nuevo paciente cuando no registrado
 *          Resultado: no se lanza ninguna excepcion.
 * @author hcadavid
 */
public class ServiciosPacientesTest {
    
    public ServiciosPacientesTest() {
    }
    
    @Before
    public void setUp() {
    }
    /**@Test (expected = ExcepcionServiciosPacientes.class)
    public void testClaseDeEquivalencia1() throws ExcepcionServiciosPacientes{
        Consulta consul=new Consulta ();
        ServiciosPacientesImpl servi= new ServiciosPacientesImpl();
        servi.agregarConsultaPaciente(5645464,"C.C",consul);
    }
    @Test 
    public void testClaseDeEquivalencia2() throws ExcepcionServiciosPacientes{
        try{
        Paciente pac = new Paciente(5645464,"C.C","jasdjfqsa",new Date(), new Eps());
        Consulta consul=new Consulta ();
        ServiciosPacientesImpl servi= new ServiciosPacientesImpl();
        servi.registrarNuevoPaciente(pac);
        servi.agregarConsultaPaciente(5645464,"C.C",consul);
        }catch (ExcepcionServiciosPacientes e){
            fail("no deja registrar una consulta de un paciente ya registrado");
        }
    }
    @Test (expected = ExcepcionServiciosPacientes.class)
    public void testClaseDeEquivalencia3() throws ExcepcionServiciosPacientes{
        Paciente pac = new Paciente(5645464,"C.C","jasdjfqsa",new Date(), new Eps());
        ServiciosPacientesImpl servi= new ServiciosPacientesImpl();
        servi.registrarNuevoPaciente(pac);
        servi.registrarNuevoPaciente(pac);        
    }
    
    
    @Test
    public void testEquivalencia4() throws ExcepcionServiciosPacientes{
        try{
        Paciente pac = new Paciente();
        ServiciosPacientesImpl servi= new ServiciosPacientesImpl();
        servi.registrarNuevoPaciente(pac);
        }catch (ExcepcionServiciosPacientes e){
            fail("Lanzo ExcepcionServiciosPacientes");
        }
    }*/
    
    
}
