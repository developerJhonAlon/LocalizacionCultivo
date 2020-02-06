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
@Table(name = "agricultor")
@XmlRootElement
public class AgricultorDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AGR_CODIGO")
    private Short agrCodigo;
    @Size(max = 11)
    @Column(name = "AGR_CEDULA")
    private String agrCedula;
    @Size(max = 50)
    @Column(name = "AGR_NOMBRE")
    private String agrNombre;
    @Size(max = 50)
    @Column(name = "AGR_APELLIDO")
    private String agrApellido;
    @Column(name = "AGR_EDAD")
    private Short agrEdad;
    @Size(max = 11)
    @Column(name = "AGR_TELEFONO")
    private String agrTelefono;
    @Size(max = 5)
    @Column(name = "AGR_GENERO")
    private String agrGenero;
    @Size(max = 50)
    @Column(name = "AGR_TIPO_AGRICULTOR")
    private String agrTipoAgricultor;
    @Size(max = 50)
    @Column(name = "AGR_PARTICIPACION")
    private String agrParticipacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agrCodigo")
    private List<Produccion> produccionList;

    public AgricultorDTO() {
    }

    public AgricultorDTO(Short agrCodigo) {
        this.agrCodigo = agrCodigo;
    }

    public Short getAgrCodigo() {
        return agrCodigo;
    }

    public void setAgrCodigo(Short agrCodigo) {
        this.agrCodigo = agrCodigo;
    }

    public String getAgrCedula() {
        return agrCedula;
    }

    public void setAgrCedula(String agrCedula) {
        this.agrCedula = agrCedula;
    }

    public String getAgrNombre() {
        return agrNombre;
    }

    public void setAgrNombre(String agrNombre) {
        this.agrNombre = agrNombre;
    }

    public String getAgrApellido() {
        return agrApellido;
    }

    public void setAgrApellido(String agrApellido) {
        this.agrApellido = agrApellido;
    }

    public Short getAgrEdad() {
        return agrEdad;
    }

    public void setAgrEdad(Short agrEdad) {
        this.agrEdad = agrEdad;
    }

    public String getAgrTelefono() {
        return agrTelefono;
    }

    public void setAgrTelefono(String agrTelefono) {
        this.agrTelefono = agrTelefono;
    }

    public String getAgrGenero() {
        return agrGenero;
    }

    public void setAgrGenero(String agrGenero) {
        this.agrGenero = agrGenero;
    }

    public String getAgrTipoAgricultor() {
        return agrTipoAgricultor;
    }

    public void setAgrTipoAgricultor(String agrTipoAgricultor) {
        this.agrTipoAgricultor = agrTipoAgricultor;
    }

    public String getAgrParticipacion() {
        return agrParticipacion;
    }

    public void setAgrParticipacion(String agrParticipacion) {
        this.agrParticipacion = agrParticipacion;
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
        hash += (agrCodigo != null ? agrCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgricultorDTO)) {
            return false;
        }
        AgricultorDTO other = (AgricultorDTO) object;
        if ((this.agrCodigo == null && other.agrCodigo != null) || (this.agrCodigo != null && !this.agrCodigo.equals(other.agrCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.msr.cultivo.dto.Agricultor[ agrCodigo=" + agrCodigo + " ]";
    }
    
}
