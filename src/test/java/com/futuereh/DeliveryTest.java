package com.futuereh;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.futuereh.dto.DeliveryDto;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class DeliveryTest {

   @Test
   @DisplayName("6 - Adicionar entrega")
   public void deveAdicionarEntrega() {
     DeliveryDto deliveryDto1 = new DeliveryDto();
     
     deliveryDto1.setLat("38.897957");
     deliveryDto1.setLon("-77.036560");
     deliveryDto1.setPostingDate("01/01/2022");
     deliveryDto1.setDeliveryDate("07/01/2022");
     deliveryDto1.setDeliveryStatus("entregue");
     
     given()
       .contentType(ContentType.JSON)
       .body(deliveryDto1)
       .when()
       .post("/delivery")
       .then()
         .statusCode(201)
         .body("lat", is("38.897957"))
         .body("lon", is("-77.036560"))
         .body("deliveryStatus", is("entregue"));
   }
   
   @Test
   @DisplayName("7 - Listar entregas")
   public void deveListarDronesCriados() {
     DeliveryDto deliveryDto2 = new DeliveryDto();
     deliveryDto2.setLat("40.730610");
     deliveryDto2.setLon("-73.935242");
     deliveryDto2.setPostingDate("12/02/2022");
     deliveryDto2.setDeliveryDate("");
     deliveryDto2.setDeliveryStatus("encaminhado");
     
     DeliveryDto deliveryDto3 = new DeliveryDto();
     deliveryDto2.setLat("40.730610");
     deliveryDto2.setLon("-73.935242");
     deliveryDto2.setPostingDate("");
     deliveryDto2.setDeliveryDate("");
     deliveryDto2.setDeliveryStatus("pendente");

     given().contentType(ContentType.JSON).body(deliveryDto2).post("/delivery");
     given().contentType(ContentType.JSON).body(deliveryDto3).post("/delivery");

     given().when().get("/delivery").then().statusCode(200).body("list.size()", is(2));
   }
   
  //  @Test
  //  @DisplayName("8 - Buscar entrega por Id")
  //  public void deveRetornarBuscaPorId() {
  //    given()
  //    .when().get("/delivery/2")
  //    .then().statusCode(200).body("deliveryStatus", is("entregue"));
  //  }
   
  //  @Test
  //  @DisplayName("9 - Atualizar entrega")
  //  public void deveAtualizarDrone() {
  //    DeliveryDto deliveryDto = new DeliveryDto();
  //    DeliveryDto deliveryDto2 = new DeliveryDto();
  //    deliveryDto2.setLat("40.730610");
  //    deliveryDto2.setLon("-73.935242");
  //    deliveryDto2.setPostingDate("12/02/2022");
  //    deliveryDto2.setDeliveryDate("");
  //    deliveryDto2.setDeliveryStatus("encaminhado");
     
  //    given().contentType(ContentType.JSON).body(deliveryDto).post("/drone");
     
  //    DeliveryDto updatedDelivery = new DeliveryDto();
  //    updatedDelivery.setDeliveryDate("14/02/2022");
  //    updatedDelivery.setDeliveryStatus("entregue");

  //    given()
  //    .contentType(ContentType.JSON)
  //    .body(updatedDelivery)
  //    .patch("/delivery/1")
  //    .then()
  //      .statusCode(200)
  //      .body("deliveryStatus", is("entregue"));
  //  }
   
  //  @Test
  //  @DisplayName("10 - Deletar entrega")
  //  public void deveDeletarDrone() {
  //    given().delete("/delivery/1");
  //    given().when().get("/delivery").then().statusCode(200).body("list.size()", is(1));
  //  }
}
