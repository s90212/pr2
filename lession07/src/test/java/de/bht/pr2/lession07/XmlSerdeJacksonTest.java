package de.bht.pr2.lession07;

import de.bht.pr2.lession07.serde.CarSerde;
import de.bht.pr2.lession07.serde.impl.XmlSerdeJackson;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class XmlSerdeJacksonTest {


  @Test
  public void shouldSerialize() {
    CarSerde xmlSerde = new XmlSerdeJackson();

    final List<Car> cars = CarUtil.createCars();
    xmlSerde.serialize(cars, "src/test/resources/autos-jackson.xml");
    final List<Car> deserialize = xmlSerde.deserialize("src/test/resources/autos-jackson.xml");

    Assertions.assertEquals(cars, deserialize);
  }

}
