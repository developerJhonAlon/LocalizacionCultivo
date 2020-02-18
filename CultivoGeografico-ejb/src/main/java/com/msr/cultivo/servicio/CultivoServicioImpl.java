/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.servicio;

import com.msr.cultivo.dto.BarrioDTO;
import com.msr.cultivo.dto.CultivoDTO;
import com.msr.cultivo.eis.BarrioDAO;
import com.msr.cultivo.eis.CultivoDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Jhonny
 */
@Stateless
public class CultivoServicioImpl implements CultivoServicio{
    
    @EJB
    private CultivoDAO cultivoDAO;
        
    @Override
    public List<CultivoDTO> transListarCultivos() {
        return cultivoDAO.listarCultivos();
    }
}
