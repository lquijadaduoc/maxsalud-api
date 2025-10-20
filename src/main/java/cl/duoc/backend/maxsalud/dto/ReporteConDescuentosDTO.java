package cl.duoc.backend.maxsalud.dto;

import java.math.BigDecimal;

public class ReporteConDescuentosDTO {
    
    private Long runPaciente;
    private String dv;
    private String nombrePaciente;
    private Integer edad;
    private String descuentoAplicado;
    private String sistemaSalud;
    private String tipoSalud;
    private Long totalAtenciones;
    private BigDecimal totalGastado;
    private BigDecimal totalDescuento;

    public ReporteConDescuentosDTO() {
    }

    public ReporteConDescuentosDTO(Long runPaciente, String dv, String nombrePaciente, Integer edad, 
                                   String descuentoAplicado, String sistemaSalud, String tipoSalud, 
                                   Long totalAtenciones, BigDecimal totalGastado, BigDecimal totalDescuento) {
        this.runPaciente = runPaciente;
        this.dv = dv;
        this.nombrePaciente = nombrePaciente;
        this.edad = edad;
        this.descuentoAplicado = descuentoAplicado;
        this.sistemaSalud = sistemaSalud;
        this.tipoSalud = tipoSalud;
        this.totalAtenciones = totalAtenciones;
        this.totalGastado = totalGastado;
        this.totalDescuento = totalDescuento;
    }

    // Getters and Setters
    public Long getRunPaciente() {
        return runPaciente;
    }

    public void setRunPaciente(Long runPaciente) {
        this.runPaciente = runPaciente;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDescuentoAplicado() {
        return descuentoAplicado;
    }

    public void setDescuentoAplicado(String descuentoAplicado) {
        this.descuentoAplicado = descuentoAplicado;
    }

    public String getSistemaSalud() {
        return sistemaSalud;
    }

    public void setSistemaSalud(String sistemaSalud) {
        this.sistemaSalud = sistemaSalud;
    }

    public String getTipoSalud() {
        return tipoSalud;
    }

    public void setTipoSalud(String tipoSalud) {
        this.tipoSalud = tipoSalud;
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

    public BigDecimal getTotalDescuento() {
        return totalDescuento;
    }

    public void setTotalDescuento(BigDecimal totalDescuento) {
        this.totalDescuento = totalDescuento;
    }
}
