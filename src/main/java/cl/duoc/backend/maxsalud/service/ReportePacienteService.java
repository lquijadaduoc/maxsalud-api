package cl.duoc.backend.maxsalud.service;

import cl.duoc.backend.maxsalud.dto.PacienteFiltradoDTO;
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

    /**
     * Busca pacientes con filtros personalizados
     * @param edadDesde Edad mínima
     * @param edadHasta Edad máxima
     * @param tipoSalud Tipo de salud (puede ser null)
     * @param tieneMorosidad 'SI', 'NO', 'TODOS'
     * @return Lista de pacientes filtrados
     */
    @Transactional(readOnly = true)
    public List<PacienteFiltradoDTO> buscarPacientesFiltrados(
            Integer edadDesde,
            Integer edadHasta,
            String tipoSalud,
            String tieneMorosidad) {
        
        // Validar parámetros
        if (edadDesde != null && edadDesde < 0) {
            throw new IllegalArgumentException("La edad desde no puede ser negativa");
        }
        
        if (edadHasta != null && edadHasta > 120) {
            throw new IllegalArgumentException("La edad hasta no puede ser mayor a 120");
        }
        
        if (edadDesde != null && edadHasta != null && edadDesde > edadHasta) {
            throw new IllegalArgumentException("La edad desde no puede ser mayor que la edad hasta");
        }
        
        // Validar tieneMorosidad
        if (tieneMorosidad != null && !tieneMorosidad.isEmpty()) {
            String morosidadNormalizada = tieneMorosidad.toUpperCase().trim();
            if (!morosidadNormalizada.equals("SI") && 
                !morosidadNormalizada.equals("NO") && 
                !morosidadNormalizada.equals("TODOS")) {
                throw new IllegalArgumentException(
                    "Valor de morosidad inválido. Valores permitidos: SI, NO, TODOS"
                );
            }
        }
        
        return reporteRepository.buscarPacientesFiltrados(
            edadDesde,
            edadHasta,
            tipoSalud,
            tieneMorosidad
        );
    }
}
