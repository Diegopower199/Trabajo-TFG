package tfg.backend.models;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "tipos_usuarios")
@Entity
@ToString
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoUsuarioModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_usuario", nullable = false)
    private int id_tipo_usuario;

    @Column(name = "tipo_usuario", unique = true, nullable = false)
    private String tipo_usuario;

    @JsonIgnore
    @OneToMany(mappedBy = "tipo_usuario", cascade = CascadeType.REMOVE)
    private List<UsuarioModel> usuarios;

    public Map<String, Object> toMap() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id_tipo_usuario", id_tipo_usuario);
        map.put("tipo_usuario", tipo_usuario);
        return map;
    }
}
