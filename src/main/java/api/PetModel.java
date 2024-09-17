package api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PetModel {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("category")
    private CategoryModel category;
    @JsonProperty("name")
    private String name;
    @JsonProperty("photoUrls")
    private List<String> photoUrls;
    @JsonProperty("tags")
    private List<TagModel> tags;
    @JsonProperty("status")
    private String status;

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

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

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(ArrayList<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<TagModel> getTags() {
        return tags;
    }

    public void setTags(ArrayList<TagModel> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PetModel(Integer id, CategoryModel category, String name, List<String> photoUrls, List<TagModel> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public PetModel() {

    }

    @Override
    public String toString() {
        return "PetModel{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetModel petModel = (PetModel) o;
        return id == petModel.id &&
                Objects.equals(category, petModel.category) &&
                Objects.equals(name, petModel.name) &&
                Objects.equals(photoUrls, petModel.photoUrls) &&
                Objects.equals(tags, petModel.tags) &&
                Objects.equals(status, petModel.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCategory(), getName(), getPhotoUrls(), getTags(), getStatus());
    }
}
