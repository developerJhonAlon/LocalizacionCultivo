/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.eis;

import com.msr.cultivo.dto.CultivoDTO;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public interface CultivoDAO {
    
    public List<CultivoDTO> listarCultivos();
    
    public boolean insertarCultivo(CultivoDTO cultivo);
    
    public boolean updateCultivo(CultivoDTO cultivo);
    
    public void eliminarCultivo(CultivoDTO cultivo);
}
