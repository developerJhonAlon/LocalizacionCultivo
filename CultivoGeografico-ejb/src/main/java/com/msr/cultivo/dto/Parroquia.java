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
@Table(name = "parroquia")
@XmlRootElement
public class Parroquia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAR_CODIGO")
    private Short parCodigo;
    @Size(max = 50)
    @Column(name = "PAR_NOMBRE")
    private String parNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parCodigo")
    private List<Barrio> barrioList;

    public Parroquia() {
    }

    public Parroquia(Short parCodigo) {
        this.parCodigo = parCodigo;
    }

    public Short getParCodigo() {
        return parCodigo;
    }

    public void setParCodigo(Short parCodigo) {
        this.parCodigo = parCodigo;
    }

    public String getParNombre() {
        return parNombre;
    }

    public void setParNombre(String parNombre) {
        this.parNombre = parNombre;
    }

    @XmlTransient
    public List<Barrio> getBarrioList() {
        return barrioList;
    }

    public void setBarrioList(List<Barrio> barrioList) {
        this.barrioList = barrioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parCodigo != null ? parCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parroquia)) {
            return false;
        }
        Parroquia other = (Parroquia) object;
        if ((this.parCodigo == null && other.parCodigo != null) || (this.parCodigo != null && !this.parCodigo.equals(other.parCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.msr.cultivo.dto.Parroquia[ parCodigo=" + parCodigo + " ]";
    }
    
}
