/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managebeans;


import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Eps;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.services.ExcepcionServiciosPacientes;
import edu.eci.pdsw.samples.services.ServiciosHistorialPacientesFactory;
import edu.eci.pdsw.samples.services.ServiciosPacientes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 2106913
 */
@ManagedBean(name = "HistorialPacientes")
@SessionScoped
public class RegistroConsultaBean implements Serializable {

    private final ServiciosPacientes servicepacientes = ServiciosHistorialPacientesFactory.getInstance().getServiciosPaciente();
    int id;
    int idC;
    String tipoId;
    String nombre;
    String resumen;
    Date fechadeNacimiento;
    Date fechaConsulta;
    long costo;
    List<Eps> epses; 
    List<Consulta> consultas;
    String eps;
    List<Paciente> pacientes;
    
    int idPacienteActual;
    
    
    public String moveToRegistroConsulta() {
      return "registroconsultas";
   }
    
    public String moveToRegistroPacientes() {
      return "registropacientes";
   }

    public RegistroConsultaBean() {
        try{
            epses = servicepacientes.obtenerEPSsRegistradas();
            pacientes=servicepacientes.consultarPacientes();
            resetConsultas();
            
        }catch(ExcepcionServiciosPacientes e){
            e.printStackTrace();
        }
        
        
    }
    public void registrarPaciente(){        
        try{           
            servicepacientes.registrarNuevoPaciente(new Paciente(id,tipoId,nombre,fechadeNacimiento, comparar()));
            pacientes=servicepacientes.consultarPacientes();
        }catch(ExcepcionServiciosPacientes e){
            e.printStackTrace();
        }
    }
    
    public void registrarConsulta(){
        try{           
            Consulta c = new Consulta(fechaConsulta, resumen, costo);
            servicepacientes.agregarConsultaPaciente(idPacienteActual, "CC", c);
            consultas.add(c);
        }catch(ExcepcionServiciosPacientes e){
            e.printStackTrace();
        }
    }
    
    public void setIdP(int id){
        idPacienteActual = id;
        try{
            consultas.addAll(servicepacientes.consultarPaciente(idPacienteActual, "CC").getConsultas());
        }catch(ExcepcionServiciosPacientes e){
            e.printStackTrace();
        }
    }
    
    public void resetConsultas(){
        consultas = new ArrayList<Consulta>();
    }

    public void showMessage(String estado, String mensaje) {
        FacesMessage message;
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, estado, mensaje);
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }
    
    public Eps comparar(){
        Eps ep = null;
        for (Eps i:epses){
            if(i.getNombre().equals(eps)){
                ep = i;
            }
        }
        return ep;
    }
    public int getId (){
        return id;
    }
    public void setId (int id){
       this.id=id;
    }
    
    public long getCosto (){
        return costo;
    }
    
    public void setCosto (long costo){
       this.costo=costo;
    }
    
    public int getIdC (){
        return idC;
    }
    public void setIdC (int id){
       this.idC=id;
    }
    public String getTipoId (){
        return tipoId;
    }
    public void setTipoId (String tipoId){
       this.tipoId=tipoId;
    }
    public String getNombre (){
        return tipoId;
    }
    
    public void setNombre (String nombre){
       this.nombre=nombre;       
    }
    
    public String getResumen (){
        return resumen;
    }
    
    public void setResumen (String nombre){
       this.resumen=nombre;       
    }
    
    public Date getFechadeNacimiento (){
        return fechadeNacimiento;
    }
    public void setFechadeNacimiento (Date fechadeNacimiento){
       this.fechadeNacimiento=fechadeNacimiento;       
    }
    
    public Date getFechaConsulta (){
        return fechaConsulta;
    }
    public void setFechaConsulta (Date fechadeNacimiento){
       this.fechaConsulta=fechadeNacimiento;       
    }
    
    public List<Eps> getEpses (){
        return epses;
    }
    public void setEpses (List<Eps> epses){
       this.epses=epses;       
    }
    public String getEps (){
        return eps;
    }
    public void setEps (String eps){
       this.eps=eps;       
    }
    public List<Paciente> getPacientes (){
        return pacientes;
    }
    public void setPacientes (List<Paciente> pacientes){
       this.pacientes=pacientes;  
    }
    
    public List<Consulta> getConsultas (){
        return consultas;
    }
    public void setConsultas (List<Consulta> consultas){
       this.consultas = consultas;  
    }
    
    public int getidPacienteActual (){
        return idPacienteActual;
    }
    public void setidPacienteActual (int idPaciente){
       this.idPacienteActual = idPaciente;  
    }

}
