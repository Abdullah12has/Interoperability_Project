package model;


import java.util.Date;

public class Lecture {
    private Long id;
    private String title;
    private Type type;
    private String contents;
    private boolean publish;
    private Date createdAt;
    private Speaker speaker;



    public Lecture() {
    }

    public Lecture(String title, Type type) {
        this.title = title;
        this.type = type;
    }

    public Lecture(String title, Type type, String contents, boolean publish) {
        this.title = title;
        this.type = type;
        this.contents = contents;
        this.publish = publish;
    }

    public Lecture(String title, Type type, String contents) {
        this.title = title;
        this.type = type;
        this.contents = contents;
    }

    public Lecture(Long id, String title, Type type, String contents) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.contents = contents;
    }

    public Lecture(String title, Type type, String contents, boolean publish, Date createdAt) {
        this.title = title;
        this.type = type;
        this.contents = contents;
        this.publish = publish;
        this.createdAt = createdAt;
    }

    public Lecture(Long id, String title, Type type, String contents, boolean publish, Date createdAt) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.contents = contents;
        this.publish = publish;
        this.createdAt = createdAt;
    }

    public Lecture(Long id, String title, Type type, String contents, boolean publish, Date createdAt, Speaker speaker) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.contents = contents;
        this.publish = publish;
        this.createdAt = createdAt;
        this.speaker = speaker;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public boolean isPublish() {
        return publish;
    }

    public void setPublish(boolean publish) {
        this.publish = publish;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", contents='" + contents + '\'' +
                ", publish=" + publish +
                ", createdAt=" + createdAt +
                ", speaker=" + speaker +
                '}';
    }

    public static enum Type{
        PRESENTATION,
        WORKSHOP
    }
}
