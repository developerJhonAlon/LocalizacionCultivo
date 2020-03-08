/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.controller;

import com.msr.cultivo.dto.CultivoDTO;
import com.msr.cultivo.servicio.CultivoServicio;
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
public class CultivoController implements Serializable {

    @EJB
    private CultivoServicio cultivoServicio;
    private List<CultivoDTO> cultivos;
    private CultivoDTO cultivo, cultivoSelected;

    public CultivoController(){}
    
    public CultivoServicio getCultivoServicio() {
        return cultivoServicio;
    }

    public void setCultivoServicio(CultivoServicio cultivoServicio) {
        this.cultivoServicio = cultivoServicio;
    }

    public List<CultivoDTO> getCultivos() {
        return cultivos;
    }

    public void setCultivos(List<CultivoDTO> cultivos) {
        this.cultivos = cultivos;
    }

    public CultivoDTO getCultivo() {
        return cultivo;
    }

    public void setCultivo(CultivoDTO cultivo) {
        this.cultivo = cultivo;
    }

    public CultivoDTO getCultivoSelected() {
        return cultivoSelected;
    }

    public void setCultivoSelected(CultivoDTO cultivoSelected) {
        this.cultivoSelected = cultivoSelected;
    }

    @PostConstruct
    public void init() {
        cultivos = cultivoServicio.transListarCultivos();
    }

    public void nuevoCultivo() {
        cultivoSelected = new CultivoDTO();
    }

    public void grabarCultivo() {
        boolean resultado;
        if (cultivoSelected.getCulCodigo() == null) {
            resultado = cultivoServicio.transGuardarCultivo(cultivoSelected);
        } else {
            resultado = cultivoServicio.transUpdateCultivos(cultivoSelected);
        }
        if (resultado) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        }
        cancelarEdicionCultivo(true);
    }

    public void cancelarEdicionCultivo(boolean ocultarPanelEdicion) {
        if (ocultarPanelEdicion) {
            cultivoSelected = null;
        }
        cultivos = cultivoServicio.transListarCultivos();
    }

    public void eliminarCultivo() {
        try {
            cultivoServicio.transEliminarCultivos(cultivoSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
            Logger.getLogger(CultivoController.class.getName()).log(Level.INFO, null, "El registro ha sido eliminado exitosamente");
        } catch (Exception ex) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarEdicionCultivo(true);
        }
    }

}
