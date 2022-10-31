package de.bht.pr2.lab01;

public class Student {

  //-------------------------------------------
  // Attribute
  private String name = "";

  // Matrikelnummer
  private int registrationNumber = 0;

  // Medieninformatik, Technische Informatik, Druck- und Medientechnik und Screen Based Media
  private String courseOfStudies = "";

  // Rückmeldegebühr
  public static final int TUITION_FEE = 312;

  /**
   * This contructor parses a comma-separated row describing a student object.
   *
   * @param dataRow a comma-separated row describing a student object
   */
  public Student(String dataRow) throws StudentParseException, RegistrationNumberException, WrongCourseOfStudiesException, NotPaidTuitionFeeException {

    //check Datenzeile
    String[] list = dataRow.split(",");
    if (list.length != 4) throw new StudentParseException("Data not in the right format or missing: " + dataRow);

    //check Matrikelnummer
    String mN = list[1];
    if (mN.length() < 5) throw new RegistrationNumberException("Not a valid registration number: " + mN);
    for (int i = 0; i < mN.length(); i++) {
      if (!Character.isDigit(mN.charAt(i))) throw new RegistrationNumberException("Not a valid registration number: " + mN);
    }

    //check Studiengang
    String course = list[2];
    String[] courses = {"Medieninformatik", "Technische Informatik", "Druck- und Medientechnik", "Screen Based Media"};
    if (!(course.equals("Medieninformatik") || course.equals("Technische Informatik") || course.equals("Druck- und Medientechnik") || course.equals("Screen Based Media"))) {
      throw new WrongCourseOfStudiesException("Course not registered in FB VI: " +  course);
    }

    //check Studiengebuehren
    int paid = Integer.parseInt(list[3]);
    if (paid < 312) throw new NotPaidTuitionFeeException("Tuition fee not paid fully. " + (312 - paid) + " Euro missing.");

    //execute if all checks went through
    this.name = list[0];
    this.registrationNumber = Integer.parseInt(mN);
    this.courseOfStudies = course;
  }

  public String getName() {
    return this.name;
  }
  public String toString() {
    return this.name + ", " + this.registrationNumber + ", " + this.courseOfStudies;
  }
}
