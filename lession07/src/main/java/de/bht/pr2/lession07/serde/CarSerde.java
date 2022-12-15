package de.bht.pr2.lession07.serde;

import de.bht.pr2.lession07.Car;
import java.util.List;

public interface CarSerde {

  void serialize(List<Car> cars, String path);

  List<Car> deserialize(String path);
}
