package model;

import java.util.Date;
import java.util.Objects;

public class Speaker {


    private Long id;
    private String name;
    private Position position;
    private Date createdAt;


    public static enum Position {
        JUNIOR,
        MID,
        SENIOR
    }

    public Speaker() {
    }

    public Speaker(Long id, String name, Position position, Date createdAt) {
        this.id = id;
        this.name = name;

        this.position = position;
        this.createdAt = createdAt;
    }

    public Speaker(String name, Position position, Date createdAt) {
        this.name = name;
        this.position = position;
        this.createdAt = createdAt;
    }

    public Speaker(Position position, Date createdAt) {
        this.position = position;
        this.createdAt = createdAt;
    }

    public Speaker(String name, Date createdAt) {
        this.name = name;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Speaker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
