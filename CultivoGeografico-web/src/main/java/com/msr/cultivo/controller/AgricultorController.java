/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.controller;

import com.msr.cultivo.dto.AgricultorDTO;
import com.msr.cultivo.servicio.AgricultorServicio;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Jhonny
 */
@ManagedBean
@ViewScoped
public class AgricultorController implements Serializable {

    @Inject
    private AgricultorServicio agricultorServicio;

    private List<AgricultorDTO> agricultores;
    private AgricultorDTO agricultor, agricultorSelected;

    public AgricultorController() {
    }

    public List<AgricultorDTO> getAgricultores() {
        return agricultores;
    }

    public void setAgricultores(List<AgricultorDTO> agricultores) {
        this.agricultores = agricultores;
    }

    public AgricultorDTO getAgricultor() {
        return agricultor;
    }

    public void setAgricultor(AgricultorDTO agricultor) {
        this.agricultor = agricultor;
    }

    public AgricultorDTO getAgricultorSelected() {
        return agricultorSelected;
    }

    public void setAgricultorSelected(AgricultorDTO agricultorSelected) {
        this.agricultorSelected = agricultorSelected;
    }

    @PostConstruct
    public void init() {
        agricultores = agricultorServicio.transListarAgricultores();
    }

    public void nuevoAgricultor() {
        agricultorSelected = new AgricultorDTO();

    }

    public void grabarAgricultor() {
        boolean resultado;
        if (agricultorSelected.getAgrCodigo()== null) {
            resultado = agricultorServicio.transGuardarAgricultor(agricultorSelected);
        } else {
            resultado = agricultorServicio.transUpdateAgricultor(agricultorSelected);
        }
        if(resultado){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        }            
        cancelarEdicionAgricultor(true);
    }

    public void cancelarEdicionAgricultor(boolean ocultarPanelEdicion) {
        if (ocultarPanelEdicion) {
            agricultorSelected = null;

        }
        agricultores = agricultorServicio.transListarAgricultores();
    }

    public void eliminarAgricultor() {
        try {
            agricultorServicio.transEliminarAgricultor(agricultorSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
            Logger.getLogger(AgricultorController.class.getName()).log(Level.INFO, null, "El registro ha sido eliminado exitosamente");
        } catch (Exception ex) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarEdicionAgricultor(true);
        }

    }

}
