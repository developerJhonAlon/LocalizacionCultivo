package com.msr.cultivo.dto;

import com.msr.cultivo.dto.ParroquiaDTO;
import com.msr.cultivo.dto.ProduccionDTO;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-21T23:16:18")
@StaticMetamodel(BarrioDTO.class)
public class BarrioDTO_ { 

    public static volatile SingularAttribute<BarrioDTO, Float> barLongitud;
    public static volatile SingularAttribute<BarrioDTO, ParroquiaDTO> parCodigo;
    public static volatile SingularAttribute<BarrioDTO, Float> barLatitud;
    public static volatile SingularAttribute<BarrioDTO, Integer> barCodigo;
    public static volatile SingularAttribute<BarrioDTO, String> barNombre;
    public static volatile ListAttribute<BarrioDTO, ProduccionDTO> produccionDTOList;

}