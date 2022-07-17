package com.futuereh;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.futuereh.dto.DroneDto;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class DroneTest {

  @Test
  @DisplayName("1 - Testa se o drone é criado corretamente.")
  public void create() {
    DroneDto droneDto = new DroneDto();
    
    droneDto.setName("Drone 1");
    droneDto.setDroneStatus("disponivel");
    
    given()
      .contentType(ContentType.JSON)
      .body(droneDto)
      .when()
      .post("/drone")
      .then()
        .statusCode(204);
  }
}
