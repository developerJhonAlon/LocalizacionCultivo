package com.msr.cultivo.dto;

import com.msr.cultivo.dto.AgricultorDTO;
import com.msr.cultivo.dto.BarrioDTO;
import com.msr.cultivo.dto.CultivoDTO;
import com.msr.cultivo.dto.DetalleProduccionDTO;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-21T23:16:18")
@StaticMetamodel(ProduccionDTO.class)
public class ProduccionDTO_ { 

    public static volatile SingularAttribute<ProduccionDTO, Integer> prodArea;
    public static volatile SingularAttribute<ProduccionDTO, CultivoDTO> culCodigo;
    public static volatile ListAttribute<ProduccionDTO, DetalleProduccionDTO> detalleProduccionDTOList;
    public static volatile SingularAttribute<ProduccionDTO, BarrioDTO> barCodigo;
    public static volatile SingularAttribute<ProduccionDTO, AgricultorDTO> agrCodigo;
    public static volatile SingularAttribute<ProduccionDTO, Integer> prodCodigo;

}