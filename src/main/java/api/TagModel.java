package api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class TagModel {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TagModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public TagModel() {

    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagModel that = (TagModel) o;
        return id == that.id && Objects.equals(name, that.name);
    }
}
