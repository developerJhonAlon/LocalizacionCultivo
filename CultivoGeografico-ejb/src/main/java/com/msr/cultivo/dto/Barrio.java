/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.dto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jhonny
 */
@Entity
@Table(name = "barrio")
@XmlRootElement
public class Barrio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BAR_CODIGO")
    private Short barCodigo;
    @Size(max = 50)
    @Column(name = "BAR_NOMBRE")
    private String barNombre;
    @Size(max = 10)
    @Column(name = "BAR_LATITUD")
    private String barLatitud;
    @Size(max = 10)
    @Column(name = "BAR_LONGITUD")
    private String barLongitud;
    @JoinColumn(name = "PAR_CODIGO", referencedColumnName = "PAR_CODIGO")
    @ManyToOne(optional = false)
    private Parroquia parCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "barCodigo")
    private List<Produccion> produccionList;

    public Barrio() {
    }

    public Barrio(Short barCodigo) {
        this.barCodigo = barCodigo;
    }

    public Short getBarCodigo() {
        return barCodigo;
    }

    public void setBarCodigo(Short barCodigo) {
        this.barCodigo = barCodigo;
    }

    public String getBarNombre() {
        return barNombre;
    }

    public void setBarNombre(String barNombre) {
        this.barNombre = barNombre;
    }

    public String getBarLatitud() {
        return barLatitud;
    }

    public void setBarLatitud(String barLatitud) {
        this.barLatitud = barLatitud;
    }

    public String getBarLongitud() {
        return barLongitud;
    }

    public void setBarLongitud(String barLongitud) {
        this.barLongitud = barLongitud;
    }

    public Parroquia getParCodigo() {
        return parCodigo;
    }

    public void setParCodigo(Parroquia parCodigo) {
        this.parCodigo = parCodigo;
    }

    @XmlTransient
    public List<Produccion> getProduccionList() {
        return produccionList;
    }

    public void setProduccionList(List<Produccion> produccionList) {
        this.produccionList = produccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (barCodigo != null ? barCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barrio)) {
            return false;
        }
        Barrio other = (Barrio) object;
        if ((this.barCodigo == null && other.barCodigo != null) || (this.barCodigo != null && !this.barCodigo.equals(other.barCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.msr.cultivo.dto.Barrio[ barCodigo=" + barCodigo + " ]";
    }
    
}
