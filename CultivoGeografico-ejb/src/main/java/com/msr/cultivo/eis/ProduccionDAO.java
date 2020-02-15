/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.eis;

import com.msr.cultivo.dto.ProduccionDTO;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public interface ProduccionDAO {
    
    public List<ProduccionDTO> listarProducciones();
    
    public boolean insertarProduccion(ProduccionDTO produccion);
    
    public boolean updateProduccion(ProduccionDTO produccion);
    
    public void eliminarProduccion(ProduccionDTO produccion);
    
    
    
}
