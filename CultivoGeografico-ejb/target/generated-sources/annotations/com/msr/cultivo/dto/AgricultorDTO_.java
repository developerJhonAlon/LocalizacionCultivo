package com.msr.cultivo.dto;

import com.msr.cultivo.dto.ProduccionDTO;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-21T23:16:17")
@StaticMetamodel(AgricultorDTO.class)
public class AgricultorDTO_ { 

    public static volatile SingularAttribute<AgricultorDTO, String> agrTelefono;
    public static volatile SingularAttribute<AgricultorDTO, String> agrNombre;
    public static volatile SingularAttribute<AgricultorDTO, String> agrCedula;
    public static volatile SingularAttribute<AgricultorDTO, String> agrTipoAgricultor;
    public static volatile SingularAttribute<AgricultorDTO, String> agrGenero;
    public static volatile SingularAttribute<AgricultorDTO, Integer> agrCodigo;
    public static volatile SingularAttribute<AgricultorDTO, String> agrApellido;
    public static volatile SingularAttribute<AgricultorDTO, Integer> agrEdad;
    public static volatile ListAttribute<AgricultorDTO, ProduccionDTO> produccionDTOList;
    public static volatile SingularAttribute<AgricultorDTO, String> agrParticipacion;

}