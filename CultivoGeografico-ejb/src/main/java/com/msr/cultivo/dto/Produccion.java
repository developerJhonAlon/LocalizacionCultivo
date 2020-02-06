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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jhonny
 */
@Entity
@Table(name = "produccion")
@XmlRootElement
public class Produccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROD_CODIGO")
    private Short prodCodigo;
    @Column(name = "PROD_FECHA")
    @Temporal(TemporalType.DATE)
    private Date prodFecha;
    @Column(name = "PROD_CANTIDAD")
    private Integer prodCantidad;
    @Column(name = "PROD_AREA")
    private Integer prodArea;
    @JoinColumn(name = "CUL_CODIGO", referencedColumnName = "CUL_CODIGO")
    @ManyToOne(optional = false)
    private Cultivo culCodigo;
    @JoinColumn(name = "AGR_CODIGO", referencedColumnName = "AGR_CODIGO")
    @ManyToOne(optional = false)
    private AgricultorDTO agrCodigo;
    @JoinColumn(name = "BAR_CODIGO", referencedColumnName = "BAR_CODIGO")
    @ManyToOne(optional = false)
    private Barrio barCodigo;

    public Produccion() {
    }

    public Produccion(Short prodCodigo) {
        this.prodCodigo = prodCodigo;
    }

    public Short getProdCodigo() {
        return prodCodigo;
    }

    public void setProdCodigo(Short prodCodigo) {
        this.prodCodigo = prodCodigo;
    }

    public Date getProdFecha() {
        return prodFecha;
    }

    public void setProdFecha(Date prodFecha) {
        this.prodFecha = prodFecha;
    }

    public Integer getProdCantidad() {
        return prodCantidad;
    }

    public void setProdCantidad(Integer prodCantidad) {
        this.prodCantidad = prodCantidad;
    }

    public Integer getProdArea() {
        return prodArea;
    }

    public void setProdArea(Integer prodArea) {
        this.prodArea = prodArea;
    }

    public Cultivo getCulCodigo() {
        return culCodigo;
    }

    public void setCulCodigo(Cultivo culCodigo) {
        this.culCodigo = culCodigo;
    }

    public AgricultorDTO getAgrCodigo() {
        return agrCodigo;
    }

    public void setAgrCodigo(AgricultorDTO agrCodigo) {
        this.agrCodigo = agrCodigo;
    }

    public Barrio getBarCodigo() {
        return barCodigo;
    }

    public void setBarCodigo(Barrio barCodigo) {
        this.barCodigo = barCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prodCodigo != null ? prodCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produccion)) {
            return false;
        }
        Produccion other = (Produccion) object;
        if ((this.prodCodigo == null && other.prodCodigo != null) || (this.prodCodigo != null && !this.prodCodigo.equals(other.prodCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.msr.cultivo.dto.Produccion[ prodCodigo=" + prodCodigo + " ]";
    }
    
}
