package opentracinglearning.simpleapi.model;

import java.time.LocalDateTime;

public class Note {

    private Long Id;
    private String description;
    private LocalDateTime createdAt;
    private String status;

    public Note() {}
    public Note(Long id, String description, LocalDateTime createdAt, String status) {
        Id = id;
        this.description = description;
        this.createdAt = createdAt;
        this.status = status;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Note{" +
                "Id=" + Id +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", status='" + status + '\'' +
                '}';
    }
}
