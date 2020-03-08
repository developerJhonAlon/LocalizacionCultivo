/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.controller;

import com.msr.cultivo.dto.ParroquiaDTO;
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
public class ParroquiaController implements Serializable {

    @EJB
    private ParroquiaServicio parroquiaServicio;
    private List<ParroquiaDTO> parroquias;
    private ParroquiaDTO parroquiaSelected, parroquia;

    public List<ParroquiaDTO> getParroquias() {
        return parroquias;
    }

    public void setParroquias(List<ParroquiaDTO> parroquias) {
        this.parroquias = parroquias;
    }

    public ParroquiaServicio getParroquiaServicio() {
        return parroquiaServicio;
    }

    public void setParroquiaServicio(ParroquiaServicio parroquiaServicio) {
        this.parroquiaServicio = parroquiaServicio;
    }

    public ParroquiaDTO getParroquiaSelected() {
        return parroquiaSelected;
    }

    public void setParroquiaSelected(ParroquiaDTO parroquiaSelected) {
        this.parroquiaSelected = parroquiaSelected;
    }

    public ParroquiaDTO getParroquia() {
        return parroquia;
    }

    public void setParroquia(ParroquiaDTO parroquia) {
        this.parroquia = parroquia;
    }

    @PostConstruct
    public void init() {
        parroquias = parroquiaServicio.transListarParroquia();
    }

    public void nuevaParroquia() {
        parroquiaSelected = new ParroquiaDTO();
    }

    public void grabarParroquia() {
        boolean resultado;
        if (parroquiaSelected.getParCodigo() == null) {
            resultado = parroquiaServicio.transGuardarParroquia(parroquiaSelected);
        } else {
            resultado = parroquiaServicio.transUpdateParroquia(parroquiaSelected);
        }
        if (resultado) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        }
        cancelarEdicionParroquia(true);
    }

    public void cancelarEdicionParroquia(boolean ocultarPanelEdicion) {
        if (ocultarPanelEdicion) {
            parroquiaSelected = null;

        }
        parroquias = parroquiaServicio.transListarParroquia();
    }

    public void eliminarParroquia() {
        try {
            parroquiaServicio.transEliminarParroquia(parroquiaSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
            Logger.getLogger(CultivoController.class.getName()).log(Level.INFO, null, "El registro ha sido eliminado exitosamente");
        } catch (Exception ex) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarEdicionParroquia(true);
        }

    }

}
