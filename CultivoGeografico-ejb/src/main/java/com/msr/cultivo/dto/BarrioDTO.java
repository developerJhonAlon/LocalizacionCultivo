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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "barrio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BarrioDTO.findAll", query = "SELECT b FROM BarrioDTO b"),
    @NamedQuery(name = "BarrioDTO.findByBarCodigo", query = "SELECT b FROM BarrioDTO b WHERE b.barCodigo = :barCodigo"),
    @NamedQuery(name = "BarrioDTO.findByBarNombre", query = "SELECT b FROM BarrioDTO b WHERE b.barNombre = :barNombre"),
    @NamedQuery(name = "BarrioDTO.findByBarLatitud", query = "SELECT b FROM BarrioDTO b WHERE b.barLatitud = :barLatitud"),
    @NamedQuery(name = "BarrioDTO.findByBarLongitud", query = "SELECT b FROM BarrioDTO b WHERE b.barLongitud = :barLongitud")})
public class BarrioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BAR_CODIGO")
    private Integer barCodigo;
    @Size(max = 50)
    @Column(name = "BAR_NOMBRE")
    private String barNombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BAR_LATITUD")
    private Float barLatitud;
    @Column(name = "BAR_LONGITUD")
    private Float barLongitud;
    @JoinColumn(name = "PAR_CODIGO", referencedColumnName = "PAR_CODIGO")
    @ManyToOne(optional = false)
    private ParroquiaDTO parCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "barCodigo")
    private List<ProduccionDTO> produccionDTOList;

    public BarrioDTO() {
    }

    public BarrioDTO(Integer barCodigo) {
        this.barCodigo = barCodigo;
    }

    public Integer getBarCodigo() {
        return barCodigo;
    }

    public void setBarCodigo(Integer barCodigo) {
        this.barCodigo = barCodigo;
    }

    public String getBarNombre() {
        return barNombre;
    }

    public void setBarNombre(String barNombre) {
        this.barNombre = barNombre;
    }

    public Float getBarLatitud() {
        return barLatitud;
    }

    public void setBarLatitud(Float barLatitud) {
        this.barLatitud = barLatitud;
    }

    public Float getBarLongitud() {
        return barLongitud;
    }

    public void setBarLongitud(Float barLongitud) {
        this.barLongitud = barLongitud;
    }

    public ParroquiaDTO getParCodigo() {
        return parCodigo;
    }

    public void setParCodigo(ParroquiaDTO parCodigo) {
        this.parCodigo = parCodigo;
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
        hash += (barCodigo != null ? barCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BarrioDTO)) {
            return false;
        }
        BarrioDTO other = (BarrioDTO) object;
        if ((this.barCodigo == null && other.barCodigo != null) || (this.barCodigo != null && !this.barCodigo.equals(other.barCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.msr.cultivo.dto.BarrioDTO[ barCodigo=" + barCodigo + " ]";
    }
    
}
