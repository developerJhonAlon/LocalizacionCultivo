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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jhonny
 */
@Entity
@Table(name = "produccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProduccionDTO.findAll", query = "SELECT p FROM ProduccionDTO p"),
    @NamedQuery(name = "ProduccionDTO.findByProdCodigo", query = "SELECT p FROM ProduccionDTO p WHERE p.prodCodigo = :prodCodigo"),
    @NamedQuery(name = "ProduccionDTO.findByProdArea", query = "SELECT p FROM ProduccionDTO p WHERE p.prodArea = :prodArea")})
public class ProduccionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PROD_CODIGO")
    private Integer prodCodigo;
    @Column(name = "PROD_AREA")
    private Integer prodArea;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prodCodigo")
    private List<DetalleProduccionDTO> detalleProduccionDTOList;
    @JoinColumn(name = "CUL_CODIGO", referencedColumnName = "CUL_CODIGO")
    @ManyToOne(optional = false)
    private CultivoDTO culCodigo;
    @JoinColumn(name = "AGR_CODIGO", referencedColumnName = "AGR_CODIGO")
    @ManyToOne(optional = false)
    private AgricultorDTO agrCodigo;
    @JoinColumn(name = "BAR_CODIGO", referencedColumnName = "BAR_CODIGO")
    @ManyToOne(optional = false)
    private BarrioDTO barCodigo;

    public ProduccionDTO() {
    }

    public ProduccionDTO(Integer prodCodigo) {
        this.prodCodigo = prodCodigo;
    }

    public Integer getProdCodigo() {
        return prodCodigo;
    }

    public void setProdCodigo(Integer prodCodigo) {
        this.prodCodigo = prodCodigo;
    }

    public Integer getProdArea() {
        return prodArea;
    }

    public void setProdArea(Integer prodArea) {
        this.prodArea = prodArea;
    }

    @XmlTransient
    public List<DetalleProduccionDTO> getDetalleProduccionDTOList() {
        return detalleProduccionDTOList;
    }

    public void setDetalleProduccionDTOList(List<DetalleProduccionDTO> detalleProduccionDTOList) {
        this.detalleProduccionDTOList = detalleProduccionDTOList;
    }

    public CultivoDTO getCulCodigo() {
        return culCodigo;
    }

    public void setCulCodigo(CultivoDTO culCodigo) {
        this.culCodigo = culCodigo;
    }

    public AgricultorDTO getAgrCodigo() {
        return agrCodigo;
    }

    public void setAgrCodigo(AgricultorDTO agrCodigo) {
        this.agrCodigo = agrCodigo;
    }

    public BarrioDTO getBarCodigo() {
        return barCodigo;
    }

    public void setBarCodigo(BarrioDTO barCodigo) {
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
        if (!(object instanceof ProduccionDTO)) {
            return false;
        }
        ProduccionDTO other = (ProduccionDTO) object;
        if ((this.prodCodigo == null && other.prodCodigo != null) || (this.prodCodigo != null && !this.prodCodigo.equals(other.prodCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.msr.cultivo.dto.ProduccionDTO[ prodCodigo=" + prodCodigo + " ]";
    }
    
}
