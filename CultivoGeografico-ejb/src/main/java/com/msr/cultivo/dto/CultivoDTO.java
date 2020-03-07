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
@Table(name = "cultivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CultivoDTO.findAll", query = "SELECT c FROM CultivoDTO c"),
    @NamedQuery(name = "CultivoDTO.findByCulCodigo", query = "SELECT c FROM CultivoDTO c WHERE c.culCodigo = :culCodigo"),
    @NamedQuery(name = "CultivoDTO.findByCulNombre", query = "SELECT c FROM CultivoDTO c WHERE c.culNombre = :culNombre"),
    @NamedQuery(name = "CultivoDTO.findByCulTipo", query = "SELECT c FROM CultivoDTO c WHERE c.culTipo = :culTipo"),
    @NamedQuery(name = "CultivoDTO.findByCulTiempocosecha", query = "SELECT c FROM CultivoDTO c WHERE c.culTiempocosecha = :culTiempocosecha")})
public class CultivoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CUL_CODIGO")
    private Integer culCodigo;
    @Size(max = 50)
    @Column(name = "CUL_NOMBRE")
    private String culNombre;
    @Size(max = 30)
    @Column(name = "CUL_TIPO")
    private String culTipo;
    @Column(name = "CUL_TIEMPOCOSECHA")
    private Integer culTiempocosecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "culCodigo")
    private List<ProduccionDTO> produccionDTOList;

    public CultivoDTO() {
    }

    public CultivoDTO(Integer culCodigo) {
        this.culCodigo = culCodigo;
    }

    public Integer getCulCodigo() {
        return culCodigo;
    }

    public void setCulCodigo(Integer culCodigo) {
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
    public List<ProduccionDTO> getProduccionDTOList() {
        return produccionDTOList;
    }

    public void setProduccionDTOList(List<ProduccionDTO> produccionDTOList) {
        this.produccionDTOList = produccionDTOList;
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
        if (!(object instanceof CultivoDTO)) {
            return false;
        }
        CultivoDTO other = (CultivoDTO) object;
        if ((this.culCodigo == null && other.culCodigo != null) || (this.culCodigo != null && !this.culCodigo.equals(other.culCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.msr.cultivo.dto.CultivoDTO[ culCodigo=" + culCodigo + " ]";
    }
    
}
