package cl.duoc.week3.domain.models;

import cl.duoc.week3.domain.models.enums.EstadoEnvio;
import jakarta.persistence.*;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="ENVIOS")
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String direccion;
    @Column(nullable = false)
    private String pais;
    @Column(nullable = false)
    private String ciudad;
    @ManyToOne
    @JoinColumn(name = "emisor_id", nullable = false)
    private Cliente emisor;
    @ManyToOne
    @JoinColumn(name = "receptor_id", nullable = false)
    private Cliente receptor;
    @Column(nullable = false)
    private String longitud;
    @Column(nullable = false)
    private String latitud;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoEnvio estado;
    @JsonFormat(pattern= "dd-MM-yyyy HH:mm:ss")
    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    public Envio() {
    }
    public Envio(String direccion, String pais, String ciudad, Cliente emisor, Cliente receptor, String longitud, String latitud, EstadoEnvio estado, LocalDateTime fechaCreacion) {
        this.direccion = direccion;
        this.pais = pais;
        this.ciudad = ciudad;
        this.emisor = emisor;
        this.receptor = receptor;
        this.longitud = longitud;
        this.latitud = latitud;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public Cliente getEmisor() {
        return emisor;
    }
    public void setEmisor(Cliente emisor) {
        this.emisor = emisor;
    }
    public Cliente getReceptor() {
        return receptor;
    }
    public void setReceptor(Cliente receptor) {
        this.receptor = receptor;
    }
    public String getLongitud() {
        return longitud;
    }
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
    public String getLatitud() {
        return latitud;
    }   
    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }
    public EstadoEnvio getEstado() {
        return estado;
    }
    public void setEstado(EstadoEnvio estado) {
        this.estado = estado;
    }
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
