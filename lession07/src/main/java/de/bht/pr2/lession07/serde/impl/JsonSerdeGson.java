package de.bht.pr2.lession07.serde.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import de.bht.pr2.lession07.Car;
import de.bht.pr2.lession07.serde.CarSerde;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.List;

public class JsonSerdeGson implements CarSerde {

  @Override
  public void serialize(List<Car> cars, String path) {
    try {
      final Gson gson = new Gson();
      try (Writer writer = new FileWriter(path)) {
        gson.toJson(cars, writer);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Car> deserialize(String path) {
    try {
      final Gson gson = new Gson();
      Type listType = new TypeToken<List<Car>>() {
      }.getType();
      return gson.fromJson(new JsonReader(new FileReader(path)), listType);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


}
