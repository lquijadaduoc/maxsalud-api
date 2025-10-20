package cl.duoc.backend.maxsalud.dto;

import java.math.BigDecimal;

public class ReporteCompletoDTO {
    
    private Long runPaciente;
    private String dv;
    private String nombrePaciente;
    private Integer edad;
    private String descuentoEdad;
    private String sistemaSalud;
    private String tipoSalud;
    private Long totalAtenciones;
    private BigDecimal totalGastado;
    private BigDecimal totalDescuento;
    private Long atencionesMorosas;
    private BigDecimal totalMultas;

    public ReporteCompletoDTO() {
    }

    public ReporteCompletoDTO(Long runPaciente, String dv, String nombrePaciente, Integer edad, 
                              String descuentoEdad, String sistemaSalud, String tipoSalud, 
                              Long totalAtenciones, BigDecimal totalGastado, BigDecimal totalDescuento,
                              Long atencionesMorosas, BigDecimal totalMultas) {
        this.runPaciente = runPaciente;
        this.dv = dv;
        this.nombrePaciente = nombrePaciente;
        this.edad = edad;
        this.descuentoEdad = descuentoEdad;
        this.sistemaSalud = sistemaSalud;
        this.tipoSalud = tipoSalud;
        this.totalAtenciones = totalAtenciones;
        this.totalGastado = totalGastado;
        this.totalDescuento = totalDescuento;
        this.atencionesMorosas = atencionesMorosas;
        this.totalMultas = totalMultas;
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

    public String getDescuentoEdad() {
        return descuentoEdad;
    }

    public void setDescuentoEdad(String descuentoEdad) {
        this.descuentoEdad = descuentoEdad;
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
}
