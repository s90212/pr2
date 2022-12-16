package de.bht.pr2.lab04;

import java.io.*;

public class ObjectSerde implements Serializable {

    public void serialize(Certificate certificate, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(certificate);

            oos.close();
            fos.close();
        } catch (Exception ignored) { }
    }

    public Certificate deserialize(String path) {
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Certificate certificate = (Certificate) ois.readObject();

            ois.close();
            fis.close();

            return certificate;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
