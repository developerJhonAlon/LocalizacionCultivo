/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.servicio;

import com.msr.cultivo.dto.AgricultorDTO;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public interface AgricultorServicio {
    
    public boolean transGuardarAgricultor(AgricultorDTO agricultor);
   
    public List<AgricultorDTO> transListarAgricultores();
    
    public boolean transUpdateAgricultor(AgricultorDTO agricultor);
    
    public void transEliminarAgricultor(AgricultorDTO agricultor);
}
