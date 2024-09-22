package may.code.crazy.task.tracker.store.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
@Entity
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "project")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(unique = true)
    String name;

    @Builder.Default
    Instant createdAt = Instant.now();

    @Builder.Default
    Instant updateAt = Instant.now();

     @Builder.Default
     @OneToMany
     @JoinColumn(name = "project_id",referencedColumnName = "id")
     List<TaskStateEntity> taskStates = new ArrayList<>();


    @Override
    public String toString() {
        return "ProjectEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                ", taskStates=" + taskStates +
                '}';
    }
}
