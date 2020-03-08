/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.servicio;

import com.msr.cultivo.dto.ParroquiaDTO;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public interface ParroquiaServicio {
    
    public boolean transGuardarParroquia(ParroquiaDTO parroquia);
   
    public List<ParroquiaDTO> transListarParroquia();
    
    public boolean transUpdateParroquia(ParroquiaDTO parroquia);
    
    public void transEliminarParroquia(ParroquiaDTO parroquia);
}
