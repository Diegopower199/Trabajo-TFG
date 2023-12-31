package tfg.backend.models;



import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "tipos_estados")
@Entity
@ToString
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoEstadoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_estado", nullable = false)
    private int id_tipo_estado;

    @Column(name = "tipo_estado", unique = true, nullable = false)
    private String tipo_estado;

    @JsonIgnore
    @OneToMany(mappedBy = "tipo_estado", cascade = CascadeType.REMOVE) // En el mappedBy debo poner la variable que he
                                                                       // puesto en usuario, en lo del private
    private List<BajaLaboralEmpleadoModel> bajasLaboralesEmpleados;

    @JsonIgnore
    @OneToMany(mappedBy = "tipo_estado", cascade = CascadeType.REMOVE) // En el mappedBy debo poner la variable que he
                                                                       // puesto en usuario, en lo del private
    private List<SolicitudEmpleadoModel> solicitudesEmpleados;

    @JsonIgnore
    @OneToMany(mappedBy = "tipo_estado", cascade = CascadeType.REMOVE) // En el mappedBy debo poner la variable que he
                                                                       // puesto en usuario, en lo del private
    private List<AyudaEmpleadoModel> ayudasEmpleados;

    @JsonIgnore
    @OneToMany(mappedBy = "tipo_estado", cascade = CascadeType.REMOVE) // En el mappedBy debo poner la variable que he
                                                                       // puesto en usuario, en lo del private
    private List<VacacionEmpleadoModel> vacacionesEmpleados;

    public Map<String, Object> toMap() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id_tipo_estado", id_tipo_estado);
        map.put("tipo_estado", tipo_estado);
        return map;
    }
}
