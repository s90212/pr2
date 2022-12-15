package de.bht.pr2.lession07;

import de.bht.pr2.lession07.serde.CarSerde;
import de.bht.pr2.lession07.serde.impl.JsonSerdeJsonLib;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JsonSerdeJsonLibTest {


  @Test
  public void shouldSerialize() {
    CarSerde jsonSerde = new JsonSerdeJsonLib();

    final List<Car> cars = CarUtil.createCars();
    jsonSerde.serialize(cars, "src/test/resources/autos-jsonlib.json");

    final List<Car> deserialize = jsonSerde.deserialize("src/test/resources/autos-jsonlib.json");

    Assertions.assertEquals(cars, deserialize);
  }

}
