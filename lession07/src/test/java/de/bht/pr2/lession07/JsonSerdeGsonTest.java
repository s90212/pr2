package de.bht.pr2.lession07;

import de.bht.pr2.lession07.serde.CarSerde;
import de.bht.pr2.lession07.serde.impl.JsonSerdeGson;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JsonSerdeGsonTest {


  @Test
  public void shouldSerialize() {
    CarSerde jsonSerde = new JsonSerdeGson();

    final List<Car> cars = CarUtil.createCars();
    jsonSerde.serialize(cars, "src/test/resources/autos-gson.json");

    final List<Car> deserialize = jsonSerde.deserialize("src/test/resources/autos-gson.json");

    Assertions.assertEquals(cars, deserialize);
  }

}
