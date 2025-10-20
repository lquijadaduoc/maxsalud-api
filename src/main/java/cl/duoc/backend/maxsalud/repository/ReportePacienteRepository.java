package cl.duoc.backend.maxsalud.repository;

import cl.duoc.backend.maxsalud.dto.ReporteCompletoDTO;
import cl.duoc.backend.maxsalud.dto.ReporteConDescuentosDTO;
import cl.duoc.backend.maxsalud.dto.ReporteMorososDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReportePacienteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Ejecuta el procedimiento almacenado GENERAR_REPORTE_PACIENTES
     * @param tipoReporte Tipo de reporte: COMPLETO, CON_DESCUENTOS, MOROSOS
     * @return Lista de objetos según el tipo de reporte
     */
    public List<?> generarReportePacientes(String tipoReporte) {
        
        // Crear la llamada al procedimiento almacenado
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("GENERAR_REPORTE_PACIENTES");
        
        // Registrar parámetros por POSICIÓN (más compatible)
        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(2, void.class, ParameterMode.REF_CURSOR);
        
        // Establecer el parámetro de entrada
        query.setParameter(1, tipoReporte);
        
        // Ejecutar el procedimiento
        query.execute();
        
        // Obtener los resultados
        @SuppressWarnings("unchecked")
        List<Object[]> resultados = query.getResultList();
        
        // Convertir según el tipo de reporte
        switch (tipoReporte.toUpperCase()) {
            case "CON_DESCUENTOS":
                return convertirAReporteConDescuentos(resultados);
            case "MOROSOS":
                return convertirAReporteMorosos(resultados);
            default: // COMPLETO
                return convertirAReporteCompleto(resultados);
        }
    }

    private List<ReporteCompletoDTO> convertirAReporteCompleto(List<Object[]> resultados) {
        List<ReporteCompletoDTO> reportes = new ArrayList<>();
        
        for (Object[] fila : resultados) {
            ReporteCompletoDTO dto = new ReporteCompletoDTO();
            dto.setRunPaciente(toLong(fila[0]));
            dto.setDv(toString(fila[1]));
            dto.setNombrePaciente(toString(fila[2]));
            dto.setEdad(toInteger(fila[3]));
            dto.setDescuentoEdad(toString(fila[4]));
            dto.setSistemaSalud(toString(fila[5]));
            dto.setTipoSalud(toString(fila[6]));
            dto.setTotalAtenciones(toLong(fila[7]));
            dto.setTotalGastado(toBigDecimal(fila[8]));
            dto.setTotalDescuento(toBigDecimal(fila[9]));
            dto.setAtencionesMorosas(toLong(fila[10]));
            dto.setTotalMultas(toBigDecimal(fila[11]));
            
            reportes.add(dto);
        }
        
        return reportes;
    }
    
    // Métodos auxiliares para conversión segura de tipos
    private String toString(Object value) {
        if (value == null) return null;
        if (value instanceof String) return (String) value;
        if (value instanceof Character) return value.toString();
        return value.toString();
    }
    
    private Long toLong(Object value) {
        if (value == null) return 0L;
        if (value instanceof Long) return (Long) value;
        if (value instanceof Integer) return ((Integer) value).longValue();
        if (value instanceof BigDecimal) return ((BigDecimal) value).longValue();
        if (value instanceof Number) return ((Number) value).longValue();
        return Long.parseLong(value.toString());
    }
    
    private Integer toInteger(Object value) {
        if (value == null) return 0;
        if (value instanceof Integer) return (Integer) value;
        if (value instanceof Long) return ((Long) value).intValue();
        if (value instanceof BigDecimal) return ((BigDecimal) value).intValue();
        if (value instanceof Number) return ((Number) value).intValue();
        return Integer.parseInt(value.toString());
    }
    
    private BigDecimal toBigDecimal(Object value) {
        if (value == null) return BigDecimal.ZERO;
        if (value instanceof BigDecimal) return (BigDecimal) value;
        if (value instanceof Integer) return BigDecimal.valueOf((Integer) value);
        if (value instanceof Long) return BigDecimal.valueOf((Long) value);
        if (value instanceof Double) return BigDecimal.valueOf((Double) value);
        if (value instanceof Number) return BigDecimal.valueOf(((Number) value).doubleValue());
        return new BigDecimal(value.toString());
    }

    private List<ReporteConDescuentosDTO> convertirAReporteConDescuentos(List<Object[]> resultados) {
        List<ReporteConDescuentosDTO> reportes = new ArrayList<>();
        
        for (Object[] fila : resultados) {
            ReporteConDescuentosDTO dto = new ReporteConDescuentosDTO();
            dto.setRunPaciente(toLong(fila[0]));
            dto.setDv(toString(fila[1]));
            dto.setNombrePaciente(toString(fila[2]));
            dto.setEdad(toInteger(fila[3]));
            dto.setDescuentoAplicado(toString(fila[4]));
            dto.setSistemaSalud(toString(fila[5]));
            dto.setTipoSalud(toString(fila[6]));
            dto.setTotalAtenciones(toLong(fila[7]));
            dto.setTotalGastado(toBigDecimal(fila[8]));
            dto.setTotalDescuento(toBigDecimal(fila[9]));
            
            reportes.add(dto);
        }
        
        return reportes;
    }

    private List<ReporteMorososDTO> convertirAReporteMorosos(List<Object[]> resultados) {
        List<ReporteMorososDTO> reportes = new ArrayList<>();
        
        for (Object[] fila : resultados) {
            ReporteMorososDTO dto = new ReporteMorososDTO();
            dto.setRunPaciente(toLong(fila[0]));
            dto.setDv(toString(fila[1]));
            dto.setNombrePaciente(toString(fila[2]));
            dto.setAtencionId(toLong(fila[3]));
            dto.setEspecialidad(toString(fila[4]));
            dto.setCostoOriginal(toBigDecimal(fila[5]));
            dto.setMultaAplicada(toBigDecimal(fila[6]));
            dto.setDiasRetraso(toLong(fila[7]));
            
            // Convertir fechas de SQL Date a LocalDate
            if (fila[8] != null) {
                dto.setFechaVencimiento(((Date) fila[8]).toLocalDate());
            }
            if (fila[9] != null) {
                dto.setFechaPagoReal(((Date) fila[9]).toLocalDate());
            }
            
            dto.setTotalAPagar(toBigDecimal(fila[10]));
            
            reportes.add(dto);
        }
        
        return reportes;
    }
}
