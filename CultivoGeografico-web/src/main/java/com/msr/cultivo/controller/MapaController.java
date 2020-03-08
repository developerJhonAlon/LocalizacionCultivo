/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.controller;

import com.msr.cultivo.dto.ProduccionDTO;
import com.msr.cultivo.servicio.ProduccionServicio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author Kleber
 */
@ManagedBean
@ViewScoped
public class MapaController implements Serializable {

    @EJB
    private ProduccionServicio produccionServicio;

    private MapModel simpleModel1 = new DefaultMapModel();
    private List<ProduccionDTO> items1;

    public MapaController(){}
    
    @PostConstruct
    public void init() {
        
        items1 = produccionServicio.transListarProducciones();
        for (ProduccionDTO prod : items1) {
            LatLng coord1 = new LatLng(prod.getBarCodigo().getBarLatitud(), prod.getBarCodigo().getBarLongitud());
            simpleModel1.addOverlay(new Marker(coord1, prod.getBarCodigo().getParCodigo().getParNombre() + "\n Barrio: " + prod.getBarCodigo().getBarNombre() + "\n Agricultor: " + prod.getAgrCodigo().getAgrNombre() + " " + prod.getAgrCodigo().getAgrApellido() + "\n Cultivo: " + prod.getCulCodigo().getCulNombre() + "\n Cantidad: " ));

        }
    }

    public MapModel getSimpleModel1() {
        return simpleModel1;
    }

    public void setSimpleModel1(MapModel simpleModel1) {
        this.simpleModel1 = simpleModel1;
    }

}
