package may.code.crazy.task.tracker.store.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    String name;

    @OneToOne
    TaskStateEntity leftTaskState;

    @OneToOne
    TaskStateEntity rightTaskState;

    String description;

    @Builder.Default
    Instant createdAt = Instant.now();

    @ManyToOne
    ProjectEntity project;

    @Builder.Default
    @OneToMany
    @JoinColumn(name = "task_state_id",referencedColumnName = "id")
    List<TaskEntity> tasks = new ArrayList<>();

    public Optional<TaskStateEntity> getLeftTaskState() {
        return Optional.ofNullable(leftTaskState);
    }

    public Optional<TaskStateEntity> getRightTaskState() {
        return Optional.ofNullable(rightTaskState);
    }


    @Override
    public String toString() {
        return "TaskStateEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", leftTaskState=" + leftTaskState +
                ", rightTaskState=" + rightTaskState +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", tasks=" + tasks +
                '}';
    }
}

