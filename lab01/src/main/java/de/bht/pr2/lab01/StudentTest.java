package de.bht.pr2.lab01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    List<String> data = new ArrayList<String>();

    @AfterEach
    void tearDown() {
        data.clear();
    }

    @Test
    void testCorrectParsing() throws NotPaidTuitionFeeException, RegistrationNumberException, WrongCourseOfStudiesException, StudentParseException {
        data.add("Anna Alt,70001,Medieninformatik,312");
        data.add("Bob Berg,70002,Technische Informatik,312");
        data.add("Carla Castor,70003,Druck- und Medientechnik,312");
        data.add("Daniel Dorf,70004,Screen Based Media,312");
        data.add("Florian Fein,70005,Technische Informatik,312");
        data.add("Horst Heinz,70008,Screen Based Media,312");
        data.add("Jan Jung,70010,Druck- und Medientechnik,312");
        data.add("Katrin Keller,70011,Medieninformatik,312");
        data.add("Melanie Mauer,70013,Technische Informatik,312");
        data.add("Nick Nuss,70014,Medieninformatik,312");
        data.add("Olivia Oper,70015,Druck- und Medientechnik,312");
        data.add("Peter Preis,70016,Screen Based Media,312");
        data.add("Queeny Quadrat,70017,Screen Based Media,312");
        data.add("Sara Sauer,70019,Technische Informatik,312");
        data.add("Thomas Tanne,70020,Medieninformatik,312");
        data.add("Ute Ulrich,70021,Screen Based Media,312");
        data.add("Vera Vesper,70022,Medieninformatik,312");
        data.add("Xena Xylophon,70024,Screen Based Media,312");
        data.add("Yannik Yoga,70025,Druck- und Medientechnik,312");
        data.add("Zoe Zoo,70026,Technische Informatik,312");

        for (String datenZeile : data) {
            Student student = new Student(datenZeile);
            String[] datenString = datenZeile.split(",");
            assertEquals(datenString[0], student.getName());                                    //check name
            assertEquals(Integer.parseInt(datenString[1]), student.getRegistrationNumber());    //check registration number
            assertEquals(datenString[2], student.getCourseOfStudies());                         //check course of studies
        }
    }

    @Test
    void testStudentParseException() {
        data.add("Walter Welt,70023,Medieninformatik");
        data.add(",,");
        data.add("Tarik Teller,70013,Medieninformatik,312,zuviel");
        for (String datenZeile : data) {
            assertThrows(StudentParseException.class,
                    () -> { Student student = new Student(datenZeile); }
            );
        }
    }

    @Test
    void testRegistrationNumberException() {
        data.add("Leon Lied,70.012,Screen Based Media,312");
        data.add("Greta Graf,7-00-06,Medieninformatik,312");
        data.add("Tarik Teller,7013,Medieninformatik,312");
        for (String datenZeile : data) {
            assertThrows(RegistrationNumberException.class,
                    () -> { Student student = new Student(datenZeile); }
            );
        }
    }

    @Test
    void testWrongCourseOfStudiesException() {
        data.add("Ingrid Insel,70009,Musik und Tanz,312");
        data.add("Tarik Teller,70013,Mediendesign,312");
        for (String datenZeile : data) {
            assertThrows(WrongCourseOfStudiesException.class,
                    () -> { Student student = new Student(datenZeile); }
            );
        }
    }

    @Test
    void testNotPaidTuitionFeeException() {
        data.add("Rafael Raum,70018,Druck- und Medientechnik,200");
        data.add("Tarik Teller,70013,Medieninformatik,300");
        for (String datenZeile : data) {
            assertThrows(NotPaidTuitionFeeException.class,
                    () -> { Student student = new Student(datenZeile); }
            );
        }
    }
}