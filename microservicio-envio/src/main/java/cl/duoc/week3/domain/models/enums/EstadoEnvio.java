package cl.duoc.week3.domain.models.enums;



public enum EstadoEnvio {
    PENDIENTE("Pendiente"),
    EN_CAMINO("En Camino"),
    ENTREGADO("Entregado");

    private String estado;
    
    EstadoEnvio(String estado) {
        this.estado = estado;
    }
    public String getEstado() {
        return estado;
    }
}
