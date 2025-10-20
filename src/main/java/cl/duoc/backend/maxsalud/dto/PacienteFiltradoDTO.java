package cl.duoc.backend.maxsalud.dto;

import java.math.BigDecimal;

public class PacienteFiltradoDTO {
    private Long run;
    private String dv;
    private String nombre;
    private Integer edad;
    private BigDecimal descuentoPorEdad;
    private String tipoSalud;
    private String planSalud;
    private Long totalAtenciones;
    private BigDecimal totalGastado;
    private Long atencionesMorosas;
    private BigDecimal totalMultas;
    private String estado;

    // Constructors
    public PacienteFiltradoDTO() {
    }

    // Getters and Setters
    public Long getRun() {
        return run;
    }

    public void setRun(Long run) {
        this.run = run;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public BigDecimal getDescuentoPorEdad() {
        return descuentoPorEdad;
    }

    public void setDescuentoPorEdad(BigDecimal descuentoPorEdad) {
        this.descuentoPorEdad = descuentoPorEdad;
    }

    public String getTipoSalud() {
        return tipoSalud;
    }

    public void setTipoSalud(String tipoSalud) {
        this.tipoSalud = tipoSalud;
    }

    public String getPlanSalud() {
        return planSalud;
    }

    public void setPlanSalud(String planSalud) {
        this.planSalud = planSalud;
    }

    public Long getTotalAtenciones() {
        return totalAtenciones;
    }

    public void setTotalAtenciones(Long totalAtenciones) {
        this.totalAtenciones = totalAtenciones;
    }

    public BigDecimal getTotalGastado() {
        return totalGastado;
    }

    public void setTotalGastado(BigDecimal totalGastado) {
        this.totalGastado = totalGastado;
    }

    public Long getAtencionesMorosas() {
        return atencionesMorosas;
    }

    public void setAtencionesMorosas(Long atencionesMorosas) {
        this.atencionesMorosas = atencionesMorosas;
    }

    public BigDecimal getTotalMultas() {
        return totalMultas;
    }

    public void setTotalMultas(BigDecimal totalMultas) {
        this.totalMultas = totalMultas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
