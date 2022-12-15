package de.bht.pr2.lession05.example02_comparable;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Example02Test {

  private static Stream<Arguments> testCases() {
    return Stream.of(
        // equal
        Arguments.of(new ComparableSchiff("", 0, 0), new ComparableSchiff("", 0, 0), 0),
        Arguments.of(new ComparableSchiff("A", 0, 0), new ComparableSchiff("A", 0, 0), 0),
        Arguments.of(new ComparableSchiff("A", 1, 0), new ComparableSchiff("A", 1, 0), 0),
        Arguments.of(new ComparableSchiff("A", 1, 1), new ComparableSchiff("A", 1, 1), 0),
        Arguments.of(new ComparableSchiff("A", 1, 0), new ComparableSchiff("A", 1, 0), 0),

        Arguments.of(new ComparableSchiff("A", 1, 1), new ComparableSchiff("B", 1, 1), -1),
        Arguments.of(new ComparableSchiff("A", 1, 1), new ComparableSchiff("A", 2, 1), -1),
        Arguments.of(new ComparableSchiff("A", 1, 1), new ComparableSchiff("A", 1, 2), -1)
    );
  }

  @ParameterizedTest(name = "{index}")
  @MethodSource("testCases")
  void testComparator(ComparableSchiff a, ComparableSchiff b, int expectedValueOfComparator) {
    Assertions.assertEquals(a.compareTo(b), expectedValueOfComparator);
  }
}
