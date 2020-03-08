/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.servicio;

import com.msr.cultivo.dto.BarrioDTO;
import com.msr.cultivo.dto.CultivoDTO;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public interface CultivoServicio {
    
    public boolean transGuardarCultivo(CultivoDTO cultivo);
   
    public List<CultivoDTO> transListarCultivos();
    
    public boolean transUpdateCultivos(CultivoDTO cultivo);
    
    public void transEliminarCultivos(CultivoDTO cultivo);
}
