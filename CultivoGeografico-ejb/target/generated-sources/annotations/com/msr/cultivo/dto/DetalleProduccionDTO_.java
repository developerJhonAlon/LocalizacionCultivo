package com.msr.cultivo.dto;

import com.msr.cultivo.dto.ProduccionDTO;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-21T23:16:18")
@StaticMetamodel(DetalleProduccionDTO.class)
public class DetalleProduccionDTO_ { 

    public static volatile SingularAttribute<DetalleProduccionDTO, Integer> detCantidad;
    public static volatile SingularAttribute<DetalleProduccionDTO, Integer> detCodigo;
    public static volatile SingularAttribute<DetalleProduccionDTO, Date> detFecha;
    public static volatile SingularAttribute<DetalleProduccionDTO, ProduccionDTO> prodCodigo;

}