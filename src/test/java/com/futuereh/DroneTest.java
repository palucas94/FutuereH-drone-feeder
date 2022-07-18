package com.futuereh;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.futuereh.dto.DroneDto;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class DroneTest {

  @Test
  @DisplayName("1 - Criar drone.")
  public void deveCriarDrone() {
    DroneDto droneDto1 = new DroneDto();
    
    droneDto1.setName("Drone 1");
    droneDto1.setDroneStatus("disponivel");
    
    given()
      .contentType(ContentType.JSON)
      .body(droneDto1)
      .when()
      .post("/drone")
      .then()
        .statusCode(201)
        .body("name", is("Drone 1"))
        .body("droneStatus", is("disponivel"));
  }
  
  @Test
  @DisplayName("2 - Listar drones")
  public void deveListarDronesCriados() {
    DroneDto droneDto2 = new DroneDto();
    droneDto2.setName("Drone 2");
    droneDto2.setDroneStatus("disponivel");
    
    DroneDto droneDto3 = new DroneDto();
    droneDto3.setName("Drone 3");
    droneDto3.setDroneStatus("disponivel");

    given().contentType(ContentType.JSON).body(droneDto2).post("/drone");
    given().contentType(ContentType.JSON).body(droneDto3).post("/drone");

    given().when().get("/drone").then().statusCode(200).body("list.size()", is(3));
  }
  
  @Test
  @DisplayName("3 - Buscar drone por Id")
  public void deveRetornarBuscaPorId() {
    given()
    .when().get("/drone/2")
    .then().statusCode(200).body("name", is("Drone 1"));
  }
  
  @Test
  @DisplayName("4 - Atualizar drone")
  public void deveAtualizarDrone() {
    DroneDto droneDto = new DroneDto();
    droneDto.setName("Xhazam");
    droneDto.setDroneStatus("disponivel");
    
    given().contentType(ContentType.JSON).body(droneDto).post("/drone");
    
    DroneDto updatedDrone = new DroneDto();
    updatedDrone.setName("Master Blaster");
    updatedDrone.setDroneStatus("indisponivel");

    given()
    .contentType(ContentType.JSON)
    .body(updatedDrone)
    .patch("/drone/1")
    .then()
      .statusCode(200)
      .body("name", is("Master Blaster"));
  }
  
  @Test
  @DisplayName("5 - Deletar drone")
  public void deveDeletarDrone() {
    given().delete("/drone/1");
    given().when().get("/drone").then().statusCode(200).body("list.size()", is(1));
  }
}
