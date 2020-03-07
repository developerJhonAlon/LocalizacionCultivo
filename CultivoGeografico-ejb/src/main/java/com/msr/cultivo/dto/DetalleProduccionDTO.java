/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jhonny
 */
@Entity
@Table(name = "prod_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleProduccionDTO.findAll", query = "SELECT d FROM DetalleProduccionDTO d"),
    @NamedQuery(name = "DetalleProduccionDTO.findByDetCodigo", query = "SELECT d FROM DetalleProduccionDTO d WHERE d.detCodigo = :detCodigo"),
    @NamedQuery(name = "DetalleProduccionDTO.findByDetFecha", query = "SELECT d FROM DetalleProduccionDTO d WHERE d.detFecha = :detFecha"),
    @NamedQuery(name = "DetalleProduccionDTO.findByDetCantidad", query = "SELECT d FROM DetalleProduccionDTO d WHERE d.detCantidad = :detCantidad")})
public class DetalleProduccionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DET_CODIGO")
    private Integer detCodigo;
    @Column(name = "DET_FECHA")
    @Temporal(TemporalType.DATE)
    private Date detFecha;
    @Column(name = "DET_CANTIDAD")
    private Integer detCantidad;
    @JoinColumn(name = "PROD_CODIGO", referencedColumnName = "PROD_CODIGO")
    @ManyToOne(optional = false)
    private ProduccionDTO prodCodigo;

    public DetalleProduccionDTO() {
    }

    public DetalleProduccionDTO(Integer detCodigo) {
        this.detCodigo = detCodigo;
    }

    public Integer getDetCodigo() {
        return detCodigo;
    }

    public void setDetCodigo(Integer detCodigo) {
        this.detCodigo = detCodigo;
    }

    public Date getDetFecha() {
        return detFecha;
    }

    public void setDetFecha(Date detFecha) {
        this.detFecha = detFecha;
    }

    public Integer getDetCantidad() {
        return detCantidad;
    }

    public void setDetCantidad(Integer detCantidad) {
        this.detCantidad = detCantidad;
    }

    public ProduccionDTO getProdCodigo() {
        return prodCodigo;
    }

    public void setProdCodigo(ProduccionDTO prodCodigo) {
        this.prodCodigo = prodCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detCodigo != null ? detCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleProduccionDTO)) {
            return false;
        }
        DetalleProduccionDTO other = (DetalleProduccionDTO) object;
        if ((this.detCodigo == null && other.detCodigo != null) || (this.detCodigo != null && !this.detCodigo.equals(other.detCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.msr.cultivo.dto.DetalleProduccionDTO[ detCodigo=" + detCodigo + " ]";
    }
    
}
