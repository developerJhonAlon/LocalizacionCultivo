/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.eis;

import com.msr.cultivo.dto.ParroquiaDTO;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public interface ParroquiaDAO {

    public List<ParroquiaDTO> listarParroquias();

    public boolean insertarParroquia(ParroquiaDTO parroquia);

    public boolean updateParroquia(ParroquiaDTO parroquia);

    public void eliminarParroquia(ParroquiaDTO parroquia);
}
