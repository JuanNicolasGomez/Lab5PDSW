/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.services.ExcepcionServiciosPacientes;
import edu.eci.pdsw.samples.services.impl.ServiciosPacientesMock;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Diseño de pruebas 
 * 
 * Clases de equivalencia:
 *     
 *      CE1:paciente no esta registrado
 *          Resultado esperado: ExcepcionServiciosPacientes
 * 
 *      CE2:paciente esta registrado
 *          Resultado:no se lanza ninguna excepcion
 * 
 *      CE3: agregar paciante cuando ya registrado
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
    @Test (expected = ExcepcionServiciosPacientes.class)
    public void testClaseDeEquivalencia1() throws ExcepcionServiciosPacientes{
        Consulta consul=new Consulta ();
        ServiciosPacientesMock servi= new ServiciosPacientesMock();
        servi.agregarConsultaPaciente(5645464,"C.C",consul);
    }
    
    @Test
    public void testEquivalencia4() throws ExcepcionServiciosPacientes{
        try{
        Paciente pac = new Paciente();
        ServiciosPacientesMock servi= new ServiciosPacientesMock();
        servi.registrarNuevoPaciente(pac);
        }catch (ExcepcionServiciosPacientes e){
            fail("Lanzo ExcepcionServiciosPacientes");
        }
    }
    
    
}
