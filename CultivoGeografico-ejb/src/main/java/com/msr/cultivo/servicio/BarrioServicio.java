/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.servicio;

import com.msr.cultivo.dto.BarrioDTO;
import java.util.List;

/**
 *
 * @author Kleber
 */
public interface BarrioServicio {
    
    public boolean transGuardarBarrio(BarrioDTO barrio);
    
    public List<BarrioDTO> transListarBarrios();
    
    public boolean transUpdateBarrio(BarrioDTO barrio);
    
    public void transEliminaBarrio(BarrioDTO barrio);
}
