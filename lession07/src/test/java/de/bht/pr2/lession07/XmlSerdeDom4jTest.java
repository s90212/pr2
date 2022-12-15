package de.bht.pr2.lession07;

import de.bht.pr2.lession07.serde.CarSerde;
import de.bht.pr2.lession07.serde.impl.XmlSerdeDom4j;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class XmlSerdeDom4jTest {


  @Test
  public void shouldSerialize() {
    CarSerde xmlSerde = new XmlSerdeDom4j();

    final List<Car> cars = CarUtil.createCars();
    xmlSerde.serialize(cars, "src/test/resources/autos-dom4j.xml");

    final List<Car> deserialize = xmlSerde.deserialize("src/test/resources/autos-dom4j.xml");

    Assertions.assertEquals(cars, deserialize);
  }

}
