package cl.duoc.backend.maxsalud.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReporteMorososDTO {
    
    private Long runPaciente;
    private String dv;
    private String nombrePaciente;
    private Long atencionId;
    private String especialidad;
    private BigDecimal costoOriginal;
    private BigDecimal multaAplicada;
    private Long diasRetraso;
    private LocalDate fechaVencimiento;
    private LocalDate fechaPagoReal;
    private BigDecimal totalAPagar;

    public ReporteMorososDTO() {
    }

    public ReporteMorososDTO(Long runPaciente, String dv, String nombrePaciente, Long atencionId, 
                             String especialidad, BigDecimal costoOriginal, BigDecimal multaAplicada, 
                             Long diasRetraso, LocalDate fechaVencimiento, LocalDate fechaPagoReal, 
                             BigDecimal totalAPagar) {
        this.runPaciente = runPaciente;
        this.dv = dv;
        this.nombrePaciente = nombrePaciente;
        this.atencionId = atencionId;
        this.especialidad = especialidad;
        this.costoOriginal = costoOriginal;
        this.multaAplicada = multaAplicada;
        this.diasRetraso = diasRetraso;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaPagoReal = fechaPagoReal;
        this.totalAPagar = totalAPagar;
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

    public Long getAtencionId() {
        return atencionId;
    }

    public void setAtencionId(Long atencionId) {
        this.atencionId = atencionId;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public BigDecimal getCostoOriginal() {
        return costoOriginal;
    }

    public void setCostoOriginal(BigDecimal costoOriginal) {
        this.costoOriginal = costoOriginal;
    }

    public BigDecimal getMultaAplicada() {
        return multaAplicada;
    }

    public void setMultaAplicada(BigDecimal multaAplicada) {
        this.multaAplicada = multaAplicada;
    }

    public Long getDiasRetraso() {
        return diasRetraso;
    }

    public void setDiasRetraso(Long diasRetraso) {
        this.diasRetraso = diasRetraso;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public LocalDate getFechaPagoReal() {
        return fechaPagoReal;
    }

    public void setFechaPagoReal(LocalDate fechaPagoReal) {
        this.fechaPagoReal = fechaPagoReal;
    }

    public BigDecimal getTotalAPagar() {
        return totalAPagar;
    }

    public void setTotalAPagar(BigDecimal totalAPagar) {
        this.totalAPagar = totalAPagar;
    }
}
