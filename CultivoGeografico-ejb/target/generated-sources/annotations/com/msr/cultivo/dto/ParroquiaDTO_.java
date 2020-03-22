package com.msr.cultivo.dto;

import com.msr.cultivo.dto.BarrioDTO;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-08T04:00:41")
@StaticMetamodel(ParroquiaDTO.class)
public class ParroquiaDTO_ { 

    public static volatile SingularAttribute<ParroquiaDTO, Integer> parCodigo;
    public static volatile SingularAttribute<ParroquiaDTO, String> parNombre;
    public static volatile ListAttribute<ParroquiaDTO, BarrioDTO> barrioDTOList;

}