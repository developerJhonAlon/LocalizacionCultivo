/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.eis;

import com.msr.cultivo.dto.AgricultorDTO;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public interface AgricultorDAO {
    
    public List<AgricultorDTO> listarAgricultores();
    
    public boolean insertarAgricultor(AgricultorDTO agricultor);
    
    public boolean updateAgricultor(AgricultorDTO agricultor);
    
    public void eliminarAgricultor(AgricultorDTO agricultor);
    
    
}
