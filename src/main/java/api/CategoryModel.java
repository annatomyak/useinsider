package api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class CategoryModel {
    @JsonProperty("id")
    private Integer id;
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

    public CategoryModel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryModel() {

    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryModel that = (CategoryModel) o;
        return id == that.id && Objects.equals(name, that.name);
    }
}
