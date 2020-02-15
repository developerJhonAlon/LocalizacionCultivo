/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.servicio;

import com.msr.cultivo.dto.ProduccionDTO;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public interface ProduccionServicio {
    
    public boolean transGuardarProduccion(ProduccionDTO produccion);
    
    public List<ProduccionDTO> transListarProducciones();
    
    public boolean transUpdateProduccion(ProduccionDTO produccion);
    
    public void transEliminarProduccion(ProduccionDTO produccion);
}
