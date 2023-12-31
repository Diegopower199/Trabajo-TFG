package tfg.backend.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "vacaciones_empleados")
@Entity
@ToString
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VacacionEmpleadoModel implements Serializable {

    // Aqui esta la tabla hecha:
    // https://chat.openai.com/share/7a57f8fe-6a3f-4ba4-bb29-2455bd25cbc3

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vacacion_empleado", nullable = false)
    private int id_vacacion_empleado;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fecha_inicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fecha_fin;

    @Column(name = "dias_solicitados", nullable = false)
    private int dias_solicitados;

    @Column(name = "dias_disfrutados", nullable = false)
    private int dias_disfrutados;

    @Column(name = "dias_restantes", nullable = false)
    private int dias_restantes;

    @Column(name = "comentarios", nullable = true)
    private String comentarios;

    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private PersonaModel persona;

    @ManyToOne
    @JoinColumn(name = "id_tipo_estado", nullable = false)
    private TipoEstadoModel tipo_estado;

    public Map<String, Object> toMap() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id_vacacion_empleado", id_vacacion_empleado);
        map.put("fecha_inicio", fecha_inicio);
        map.put("fecha_fin", fecha_fin);
        map.put("dias_solicitados", dias_solicitados);
        map.put("dias_disfrutados", dias_disfrutados);
        map.put("dias_restantes", dias_restantes);
        map.put("comentarios", comentarios);
        return map;
    }
}

/*
 * 
 * Controlar que las fechas no se solapen, es decir si esta selecciona el
 * 2-12-2023 hasta el 10-12-2023, que no pueda coger unas vacaciones del
 * 5-12-2023 al 13-12-2023 y salga el error "fechas solapadas"
 * - ID de Vacaciones (Clave Primaria)
 * - ID de Persona (Clave Externa que se relaciona con la tabla de Gestión de
 * Personas)
 * - Año
 * - Fecha de Inicio
 * - Fecha de Finalización
 * - Días Disponibles
 * - Días Disfrutados
 * - Días Restantes
 */
