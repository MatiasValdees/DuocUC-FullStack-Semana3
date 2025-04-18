package cl.duoc.week3.domain.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "VIAJES")
public class Viaje {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable= false)
    private String direccion;
    @Column(nullable= false)
    private String ciudad;
    @ManyToOne
    @JoinColumn(name = "id_chofer", nullable = false)
    private Usuario chofer;
    @ManyToOne
    @JoinColumn(name = "id_pasajero", nullable = false)
    private Usuario pasajero;
    @Column(name = "fecha_creacion", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime fechaCreacion;

    public Viaje() {
    }
    public Viaje(Long id, String direccion, String ciudad, Usuario chofer, Usuario pasajero, LocalDateTime fechaCreacion) {
        this.id = id;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.chofer = chofer;
        this.pasajero = pasajero;
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
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public Usuario getChofer() {
        return chofer;
    }
    public void setChofer(Usuario chofer) {
        this.chofer = chofer;
    }
    public Usuario getPasajero() {
        return pasajero;
    }
    public void setPasajero(Usuario pasajero) {
        this.pasajero = pasajero;
    }
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
