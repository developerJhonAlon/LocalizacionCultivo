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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@NamedQueries({
    @NamedQuery(name = "ParroquiaDTO.findAll", query = "SELECT p FROM ParroquiaDTO p")})
public class ParroquiaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PAR_CODIGO")
    private Integer parCodigo;
    @Size(max = 50)
    @Column(name = "PAR_NOMBRE")
    private String parNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parCodigo")
    private List<BarrioDTO> barrioDTOList;

    public ParroquiaDTO() {
    }

    public ParroquiaDTO(Integer parCodigo) {
        this.parCodigo = parCodigo;
    }

    public Integer getParCodigo() {
        return parCodigo;
    }

    public void setParCodigo(Integer parCodigo) {
        this.parCodigo = parCodigo;
    }

    public String getParNombre() {
        return parNombre;
    }

    public void setParNombre(String parNombre) {
        this.parNombre = parNombre;
    }

    @XmlTransient
    public List<BarrioDTO> getBarrioDTOList() {
        return barrioDTOList;
    }

    public void setBarrioDTOList(List<BarrioDTO> barrioDTOList) {
        this.barrioDTOList = barrioDTOList;
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
        if (!(object instanceof ParroquiaDTO)) {
            return false;
        }
        ParroquiaDTO other = (ParroquiaDTO) object;
        if ((this.parCodigo == null && other.parCodigo != null) || (this.parCodigo != null && !this.parCodigo.equals(other.parCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.msr.cultivo.dto.ParroquiaDTO[ parCodigo=" + parCodigo + " ]";
    }
    
}
