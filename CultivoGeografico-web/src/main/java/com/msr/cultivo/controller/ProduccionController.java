/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.controller;

import com.msr.cultivo.dto.AgricultorDTO;
import com.msr.cultivo.dto.BarrioDTO;
import com.msr.cultivo.dto.CultivoDTO;
import com.msr.cultivo.dto.ProduccionDTO;
import com.msr.cultivo.servicio.AgricultorServicio;
import com.msr.cultivo.servicio.BarrioServicio;
import com.msr.cultivo.servicio.CultivoServicio;
import com.msr.cultivo.servicio.ProduccionServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Jhonny
 */
@ManagedBean
@ViewScoped
public class ProduccionController implements Serializable{
    
    @EJB
    private ProduccionServicio produccionServicio;
    @EJB
    private AgricultorServicio agricultorServicio;
    @EJB
    private BarrioServicio barrioServicio;
    @EJB
    private CultivoServicio cultivoServicio;
    
    private List<ProduccionDTO> producciones;
    private List<CultivoDTO> cultivoList;
    private List<BarrioDTO> barrioList;
    private ProduccionDTO produccion, produccionSelected;
    private AgricultorDTO agricultorSelected;
    private String nomAgricultorBusqueda;
    
    public ProduccionController(){}

    public List<CultivoDTO> getCultivoList() {
        return cultivoList;
    }

    public void setCultivoList(List<CultivoDTO> cultivoList) {
        this.cultivoList = cultivoList;
    }

    public List<BarrioDTO> getBarrioList() {
        return barrioList;
    }

    public void setBarrioList(List<BarrioDTO> barrioList) {
        this.barrioList = barrioList;
    }
    
    

    public String getNomAgricultorBusqueda() {
        return nomAgricultorBusqueda;
    }

    public void setNomAgricultorBusqueda(String nomAgricultorBusqueda) {
        this.nomAgricultorBusqueda = nomAgricultorBusqueda;
    }
    
    public AgricultorDTO getAgricultorSelected() {
        return agricultorSelected;
    }

    public void setAgricultorSelected(AgricultorDTO agricultorSelected) {
        this.agricultorSelected = agricultorSelected;
    }       

  
    public List<ProduccionDTO> getProducciones() {
        return producciones;
    }

    public void setProducciones(List<ProduccionDTO> producciones) {
        this.producciones = producciones;
    }  

    public ProduccionDTO getProduccion() {
        return produccion;
    }

    public void setProduccion(ProduccionDTO produccion) {
        this.produccion = produccion;
    }

    public ProduccionDTO getProduccionSelected() {
        return produccionSelected;
    }

    public void setProduccionSelected(ProduccionDTO produccionSelected) {
        this.produccionSelected = produccionSelected;
    }
    
    
    @PostConstruct
    public void init() {
        producciones = produccionServicio.transListarProducciones();
        cultivoList = cultivoServicio.transListarCultivos();
        barrioList = barrioServicio.transListarBarrios();
    }
    
    
    public void nuevoProduccion() {
        produccionSelected = new ProduccionDTO();

    }
    
     public void grabarProduccion() {
        boolean resultado;
        if (produccionSelected.getProdCodigo()== null) {
            resultado = produccionServicio.transGuardarProduccion(produccionSelected);
        } else {
            resultado = produccionServicio.transUpdateProduccion(produccionSelected);
        }
        if(resultado){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        }            
        cancelarEdicionProduccion(true);
    }


    public void cancelarEdicionProduccion(boolean ocultarPanelEdicion) {
        if (ocultarPanelEdicion) {
            produccionSelected = null;

        }
        producciones = produccionServicio.transListarProducciones();
    }
    
    public void eliminarProduccion() {
        try {
            produccionServicio.transEliminarProduccion(produccionSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
            Logger.getLogger(AgricultorController.class.getName()).log(Level.INFO, null, "El registro ha sido eliminado exitosamente");
        } catch (Exception ex) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarEdicionProduccion(true);
        }

    }
    
    public void onItemSelect(SelectEvent event){
        llenarDatosAgricultorXNombres(event.getObject().toString());
        //obtener informacion en relacion al agricultor seleccionado
    }
    
    private void llenarDatosAgricultorXNombres(String nombresApellidos){
        List<AgricultorDTO> listaAgricultor = agricultorServicio.transFindByName(nombresApellidos);
        agricultorSelected = listaAgricultor.get(0);
        produccionSelected.setAgrCodigo(agricultorSelected);
    }
    
    
    public List<String> completeText(String query){
        List<AgricultorDTO> listaAgricultor = agricultorServicio.transFindByName(query);
        List<String> results = new ArrayList<String>();
        for (AgricultorDTO listaAgricultor1 : listaAgricultor) {
            results.add(listaAgricultor1.getAgrNombre() + " " + listaAgricultor1.getAgrApellido());
        }
        return results;
    }
}


