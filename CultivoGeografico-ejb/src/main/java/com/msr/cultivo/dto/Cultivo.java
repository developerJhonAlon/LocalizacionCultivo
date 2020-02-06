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
@Table(name = "cultivo")
@XmlRootElement
public class Cultivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUL_CODIGO")
    private Short culCodigo;
    @Size(max = 50)
    @Column(name = "CUL_NOMBRE")
    private String culNombre;
    @Size(max = 30)
    @Column(name = "CUL_TIPO")
    private String culTipo;
    @Column(name = "CUL_TIEMPOCOSECHA")
    private Integer culTiempocosecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "culCodigo")
    private List<Produccion> produccionList;

    public Cultivo() {
    }

    public Cultivo(Short culCodigo) {
        this.culCodigo = culCodigo;
    }

    public Short getCulCodigo() {
        return culCodigo;
    }

    public void setCulCodigo(Short culCodigo) {
        this.culCodigo = culCodigo;
    }

    public String getCulNombre() {
        return culNombre;
    }

    public void setCulNombre(String culNombre) {
        this.culNombre = culNombre;
    }

    public String getCulTipo() {
        return culTipo;
    }

    public void setCulTipo(String culTipo) {
        this.culTipo = culTipo;
    }

    public Integer getCulTiempocosecha() {
        return culTiempocosecha;
    }

    public void setCulTiempocosecha(Integer culTiempocosecha) {
        this.culTiempocosecha = culTiempocosecha;
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
        hash += (culCodigo != null ? culCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cultivo)) {
            return false;
        }
        Cultivo other = (Cultivo) object;
        if ((this.culCodigo == null && other.culCodigo != null) || (this.culCodigo != null && !this.culCodigo.equals(other.culCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.msr.cultivo.dto.Cultivo[ culCodigo=" + culCodigo + " ]";
    }
    
}
