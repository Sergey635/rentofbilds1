package edu.ale.rentofbilds.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Build {
    private String id;
    private String name;
    private String description;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;

    public Build() {
    }

    public Build(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Build(String name, String description, LocalDateTime created_at, LocalDateTime modified_at) {
        this.name = name;
        this.description = description;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    public Build(String id, String name, String description, LocalDateTime created_at, LocalDateTime modified_at) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getModified_at() {
        return modified_at;
    }

    public void setModified_at(LocalDateTime modified_at) {
        this.modified_at = modified_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Build build = (Build) o;
        return getId().equals(build.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Build{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", created_at=" + created_at +
                ", modified_at=" + modified_at +
                '}';
    }
}
