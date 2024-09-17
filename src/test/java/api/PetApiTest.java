package api;

import api.responseModels.ApiResponseModel;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static api.PetBuilder.createPetByAPI;
import static api.PetBuilder.createPetObject;
import static io.restassured.RestAssured.given;

public class PetApiTest {
    public final static String URL = "https://petstore.swagger.io/v2/";
    public final static String PET_PATH = "pet/";

    @Test
    public void checkGetPetByValidId() {
        Specification.installSpec(Specification.requestSpecification(URL), Specification.responseSpecificationOK200());
        PetModel createdPet = createPetByAPI(createPetObject());
        PetModel petFromGetResponse = given()
                .accept(ContentType.JSON)
                .when()
                .get(URL + PET_PATH + createdPet.getId())
                .then()
                .log().all()
                .extract().as(PetModel.class);
        Assertions.assertEquals(petFromGetResponse, createdPet);

    }

    @Test
    public void checkGetPetByInvalidId() {
        Specification.installSpec(Specification.requestSpecification(URL), Specification.responseSpecification404());
        ApiResponseModel expectedResponse = new ApiResponseModel(1, "error", "Pet not found");
        ApiResponseModel petResponseForInvalidId = given()
                .accept(ContentType.JSON)
                .when()
                .get(URL + PET_PATH + "100")
                .then()
                .log().all()
                .extract().as(ApiResponseModel.class);
        Assertions.assertEquals(petResponseForInvalidId, expectedResponse);

    }

    @Test
    public void createPetPOST() {
        Specification.installSpec(Specification.requestSpecification(URL), Specification.responseSpecificationOK200());
        PetModel pet = createPetObject();
        PetModel petActual = given()
                .when()
                .body(pet)
                .post(URL + PET_PATH)
                .then()
                .log().all()
                .extract().as(PetModel.class);
        Assertions.assertEquals(petActual, pet);

    }

    @Test
    public void createPetWithEmptyRequiredFieldsPOST() {
        PetModel pet = new PetModel(1, null, "", null, null, "status");
        given()
                .when()
                .contentType(ContentType.JSON)
                .body(pet)
                .post(URL + PET_PATH)
                .then()
                .log().all()
                .assertThat()
                .statusCode(400);


    }

    @Test
    public void deletePetWithValidIdDELETE() {
        Specification.installSpec(Specification.requestSpecification(URL), Specification.responseSpecificationOK200());
        PetModel pet = createPetObject();
        ApiResponseModel responseModel = new ApiResponseModel(200, "unknown", "1");
        ApiResponseModel actualResponseModel = given()
                .when()
                .delete(URL + PET_PATH + pet.getId())
                .then()
                .log().all()
                .extract().as(ApiResponseModel.class);
        Assertions.assertEquals(actualResponseModel, responseModel);


    }

    @Test
    public void editPetPUT() {
        Specification.installSpec(Specification.requestSpecification(URL), Specification.responseSpecificationOK200());
        PetModel pet = createPetObject();
        PetModel editedPet = new PetModel(pet.getId(), pet.getCategory(), "newName", pet.getPhotoUrls(), pet.getTags(), pet.getStatus());
        PetModel petFromResponse = given()
                .when()
                .body(editedPet)
                .put(URL + PET_PATH)
                .then()
                .log().all()
                .extract().as(PetModel.class);
        Assertions.assertEquals(petFromResponse, editedPet);
    }

    @Test
    public void editPetWithInvalidIDPUT() {
        PetModel pet = createPetObject();
        pet.setId(200);
        given()
                .when()
                .contentType(ContentType.JSON)
                .body(pet)
                .put(URL + PET_PATH)
                .then()
                .log().all()
                .assertThat()
                .statusCode(404);
    }
}
