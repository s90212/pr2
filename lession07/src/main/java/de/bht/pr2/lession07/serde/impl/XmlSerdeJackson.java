package de.bht.pr2.lession07.serde.impl;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import de.bht.pr2.lession07.Car;
import de.bht.pr2.lession07.serde.CarSerde;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class XmlSerdeJackson implements CarSerde {

  @Override
  public void serialize(List<Car> cars, String path) {
    try {
      XmlMapper xmlMapper = new XmlMapper();
      xmlMapper.setVisibility(
          xmlMapper.getSerializationConfig().
              getDefaultVisibilityChecker().
              withFieldVisibility(JsonAutoDetect.Visibility.ANY).
              withGetterVisibility(JsonAutoDetect.Visibility.NONE).
              withIsGetterVisibility(JsonAutoDetect.Visibility.NONE)
      );
      xmlMapper.writeValue(new File(path), cars);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Car> deserialize(String path) {
    try {
      final File file = new File(path);
      final XmlMapper xmlMapper = new XmlMapper();
      return xmlMapper.readValue(file, new TypeReference<>() {
      });
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


}
