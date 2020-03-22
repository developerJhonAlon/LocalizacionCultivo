package com.msr.cultivo.dto;

import com.msr.cultivo.dto.ProduccionDTO;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-21T23:16:17")
@StaticMetamodel(CultivoDTO.class)
public class CultivoDTO_ { 

    public static volatile SingularAttribute<CultivoDTO, Integer> culCodigo;
    public static volatile SingularAttribute<CultivoDTO, String> culTipo;
    public static volatile SingularAttribute<CultivoDTO, String> culNombre;
    public static volatile ListAttribute<CultivoDTO, ProduccionDTO> produccionDTOList;
    public static volatile SingularAttribute<CultivoDTO, Integer> culTiempocosecha;

}