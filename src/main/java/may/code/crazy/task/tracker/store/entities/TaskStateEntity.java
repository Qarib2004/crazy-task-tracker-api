package may.code.crazy.task.tracker.store.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task_state")
public class TaskStateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @Column(unique = true)
    String name;

    Long ordinal;

    String description;
    @Builder.Default
    Instant createdAt = Instant.now();
    @Builder.Default
    @OneToMany
    @JoinColumn(name = "task_state_id",referencedColumnName = "id")
    List<TaskStateEntity> taskStates = new ArrayList<>();


    @Override
    public String toString() {
        return "TaskStateEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ordinal=" + ordinal +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", taskStates=" + taskStates +
                '}';
    }
}
