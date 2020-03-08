/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.controller;

import com.msr.cultivo.dto.BarrioDTO;
import com.msr.cultivo.dto.ParroquiaDTO;
import com.msr.cultivo.servicio.BarrioServicio;
import com.msr.cultivo.servicio.ParroquiaServicio;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Kleber
 */
@ManagedBean
@ViewScoped
public class BarrioController implements Serializable {

    @EJB
    private BarrioServicio barrioServicio;
    @EJB
    private ParroquiaServicio parroquiaServicio;

    private List<BarrioDTO> barrios;
    private List<ParroquiaDTO> parroquiaList;
    private BarrioDTO barrio, barrioSelected;
    
    public BarrioController(){}
    
    public List<BarrioDTO> getBarrios() {
        return barrios;
    }

    public void setBarrios(List<BarrioDTO> barrios) {
        this.barrios = barrios;
    }

    public List<ParroquiaDTO> getParroquiaList() {
        return parroquiaList;
    }

    public void setParroquiaList(List<ParroquiaDTO> parroquiaList) {
        this.parroquiaList = parroquiaList;
    }

    public BarrioDTO getBarrio() {
        return barrio;
    }

    public void setBarrio(BarrioDTO barrio) {
        this.barrio = barrio;
    }

    public BarrioDTO getBarrioSelected() {
        return barrioSelected;
    }

    public void setBarrioSelected(BarrioDTO barrioSelected) {
        this.barrioSelected = barrioSelected;
    }

    @PostConstruct
    public void init() {
        barrios = barrioServicio.transListarBarrios();
        parroquiaList = parroquiaServicio.transListarParroquia();
    }

    public void nuevoBarrio() {
        barrioSelected = new BarrioDTO();
    }

    public void grabarBarrio() {
        boolean resultado;
        if (barrioSelected.getBarCodigo() == null) {
            resultado = barrioServicio.transGuardarBarrio(barrioSelected);
        } else {
            resultado = barrioServicio.transUpdateBarrio(barrioSelected);
        }
        if (resultado) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        }
        cancelarEdicionBarrio(true);
    }

    public void cancelarEdicionBarrio(boolean ocultarPanelEdicion) {
        if (ocultarPanelEdicion) {
            barrioSelected = null;
        }
        barrios = barrioServicio.transListarBarrios();
    }

    public void eliminarBarrio() {
        try {
            barrioServicio.transEliminaBarrio(barrioSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
            Logger.getLogger(AgricultorController.class.getName()).log(Level.INFO, null, "El registro ha sido eliminado exitosamente");
        } catch (Exception ex) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarEdicionBarrio(true);
        }

    }
}
