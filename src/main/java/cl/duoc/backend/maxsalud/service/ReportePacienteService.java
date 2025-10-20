package cl.duoc.backend.maxsalud.service;

import cl.duoc.backend.maxsalud.repository.ReportePacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReportePacienteService {

    @Autowired
    private ReportePacienteRepository reporteRepository;

    /**
     * Genera un reporte completo de pacientes
     * @return Lista de reportes completos
     */
    @Transactional(readOnly = true)
    public List<?> generarReporteCompleto() {
        return reporteRepository.generarReportePacientes("COMPLETO");
    }

    /**
     * Genera un reporte de pacientes con descuentos
     * @return Lista de reportes con descuentos
     */
    @Transactional(readOnly = true)
    public List<?> generarReporteConDescuentos() {
        return reporteRepository.generarReportePacientes("CON_DESCUENTOS");
    }

    /**
     * Genera un reporte de pacientes morosos
     * @return Lista de reportes de morosos
     */
    @Transactional(readOnly = true)
    public List<?> generarReporteMorosos() {
        return reporteRepository.generarReportePacientes("MOROSOS");
    }

    /**
     * Genera un reporte según el tipo especificado
     * @param tipoReporte Tipo de reporte (COMPLETO, CON_DESCUENTOS, MOROSOS)
     * @return Lista de reportes según el tipo
     */
    @Transactional(readOnly = true)
    public List<?> generarReportePorTipo(String tipoReporte) {
        // Validar tipo de reporte
        if (tipoReporte == null || tipoReporte.trim().isEmpty()) {
            tipoReporte = "COMPLETO";
        }
        
        String tipoNormalizado = tipoReporte.toUpperCase().trim();
        
        // Validar que sea un tipo válido
        if (!tipoNormalizado.equals("COMPLETO") && 
            !tipoNormalizado.equals("CON_DESCUENTOS") && 
            !tipoNormalizado.equals("MOROSOS")) {
            throw new IllegalArgumentException(
                "Tipo de reporte inválido. Valores permitidos: COMPLETO, CON_DESCUENTOS, MOROSOS"
            );
        }
        
        return reporteRepository.generarReportePacientes(tipoNormalizado);
    }
}
