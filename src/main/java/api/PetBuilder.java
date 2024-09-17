package api;

import java.util.Collections;
import java.util.List;


import static io.restassured.RestAssured.given;

public class PetBuilder {
    public final static String URL = "https://petstore.swagger.io/v2/";

    public static PetModel createPetObject() {
        CategoryModel category = new CategoryModel(1, "Alaskan Malamute");
        List<String> photoUrls = Collections.singletonList("https://www.akc.org/dog-breeds/alaskan-malamute/");
        TagModel tag = new TagModel(1, "dog");
        List<TagModel> tags = Collections.singletonList(tag);
        return new PetModel(1, category, "doggie", photoUrls, tags, "available");
    }

    public static PetModel createPetByAPI(PetModel petModel) {
        return given()
                .when()
                .body(petModel)
                .post(URL + "pet")
                .then()
                .log().all()
                .extract().as(PetModel.class);
    }
}
