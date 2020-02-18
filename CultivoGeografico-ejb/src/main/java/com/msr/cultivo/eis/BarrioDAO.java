/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.eis;

import com.msr.cultivo.dto.BarrioDTO;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public interface BarrioDAO {
    
    public List<BarrioDTO> listarBarrios();
}
