import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestCases
{
   private final static double DELTA = 0.0001;

   ////////////////////////////////////////////////////////////
   //                      SimpleIf Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testAnalyzeApplicant()
   {
      assertTrue(SimpleIf.analyzeApplicant(89, 85));
   }

   @Test
   public void testAnalyzeApplicant2()
   {
      assertFalse(SimpleIf.analyzeApplicant(15, 90));
   }

   @Test
   public void testAnalyzeApplicant3()
   {
      /* TO DO: Write one more valid test case. */
      //New test case
      assertFalse(SimpleIf.analyzeApplicant(92, 99));
      assertFalse(SimpleIf.analyzeApplicant(92, 92));
   }

   @Test
   public void testMaxAverage() {
      assertEquals(SimpleIf.maxAverage(89.5, 91.2), 91.2, DELTA);
   }

   @Test
   public void testMaxAverage2() {
      assertEquals(SimpleIf.maxAverage(60, 89), 89, DELTA);
   }

   @Test
   public void testMaxAverage3() {
      /* TO DO: Write one more valid test case. */

      assertEquals(SimpleIf.maxAverage(89.9, 90), 90, DELTA);
   }

   ////////////////////////////////////////////////////////////
   //                    SimpleLoop Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testSimpleLoop1()
   {
      assertEquals(7, SimpleLoop.sum(3, 4));
   }

   @Test
   public void testSimpleLoop2()
   {
      assertEquals(7, SimpleLoop.sum(-2, 4));
   }

   @Test
   public void testSimpleLoop3()
   {
      /* TO DO: Write one more valid test case to make sure that
         this function is not just returning 7. */
      //New test case
      assertEquals(1045, SimpleLoop.sum(90, 100));
      assertEquals(10, SimpleLoop.sum(1, 4));
   }

   ////////////////////////////////////////////////////////////
   //                    SimpleArray Tests                   //
   ////////////////////////////////////////////////////////////

   @Test
   public void testSimpleArray1()
   {
      /* What is that parameter?  They are newly allocated arrays
         with initial values. */
      assertArrayEquals(
         new boolean[] {false, false, true, true, false, false},
         SimpleArray.applicantAcceptable(new int[] {80, 85, 89, 92, 76, 81}, 85)
      );
   }

   @Test
   public void testSimpleArray2()
   {
      assertArrayEquals(
         new boolean[] {false, false},
         SimpleArray.applicantAcceptable(new int[] {80, 83}, 92));
   }

   @Test
   public void testSimpleArray3()
   {
      /* TO DO: Add a new test case. */
      //New test case
      assertArrayEquals(
         new boolean[] {false, false, false, false, false, false},
         SimpleArray.applicantAcceptable(new int[] {80, 85, 89, 92, 76, 81}, 100));

      assertArrayEquals(
           new boolean[] {false, false, false, true, true, false},
              SimpleArray.applicantAcceptable(new int[] {82, 83, 84, 85, 90, 75}, 84)
      );
   }

   ////////////////////////////////////////////////////////////
   //                    SimpleList Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testSimpleList1()
   {
      List<Integer> input =
         new LinkedList<>(Arrays.asList(80, 85, 89, 92, 76, 81));
      List<Boolean> expected =
         new ArrayList<>(Arrays.asList(false, false, true, true, false, false));

      assertEquals(expected, SimpleList.applicantAcceptable(input, 85));
   }

   @Test
   public void testSimpleList2()
   {
      List<Boolean> expected = Arrays.asList(false, false, true, true, false, false);

      /* TO DO: Add a new test case. */
      List<Integer> input = Arrays.asList(80, 85, 89, 92, 76, 81);
      assertEquals(expected, SimpleList.applicantAcceptable(input, 88));

      //New test case
      List<Boolean> expected2 = Arrays.asList(false, true, false, false, false, false);
      List<Integer> input2 = Arrays.asList(98, 100, 1, 23, 19, 98);
      assertEquals(expected2, SimpleList.applicantAcceptable(input2, 99));
   }

   ////////////////////////////////////////////////////////////
   //                    BetterLoop Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testFourOver85()
   {
      assertFalse(BetterLoop.atLeastFourOver85(new int[] {89, 93, 100, 39, 84, 63}));
   }

   @Test
   public void testFourOver85_2()
   {
      assertTrue(BetterLoop.atLeastFourOver85(new int[] {89, 86, 90, 92, 84, 88}));
   }

   @Test
   public void testFourOver85_3()
   {
      /* TO DO: Write a valid test case where the expected result is false. */
      //New test case
      assertFalse(BetterLoop.atLeastFourOver85(new int[] {92, 1, 2, 3, 4, 92}));
      assertFalse(BetterLoop.atLeastFourOver85(new int[] {85, 80, 85, 75, 80, 92}));
   }

   // @Test
   // public void testAverage()
   // {
   //    assertEquals(BetterLoop.average(new int[] {89, 93, 100, 39, 84, 63}),
   //       (double) (89 + 93 + 100 + 39 + 84) / 5, DELTA);
   // }

   ////////////////////////////////////////////////////////////
   //                    ExampleMap Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testExampleMap1()
   {
      Map<String, List<CourseGrade>> courseListsByStudent = new HashMap<>();
      courseListsByStudent.put("Julie",
         Arrays.asList(
            new CourseGrade("CPE 123", 89),
            new CourseGrade("CPE 101", 90),
            new CourseGrade("CPE 202", 99),
            new CourseGrade("CPE 203", 100),
            new CourseGrade("CPE 225", 89)));
      courseListsByStudent.put("Paul",
         Arrays.asList(
            new CourseGrade("CPE 101", 86),
            new CourseGrade("CPE 202", 80),
            new CourseGrade("CPE 203", 76),
            new CourseGrade("CPE 225", 80)));
      courseListsByStudent.put("Zoe",
         Arrays.asList(
            new CourseGrade("CPE 123", 99),
            new CourseGrade("CPE 203", 91),
            new CourseGrade("CPE 471", 86),
            new CourseGrade("CPE 473", 90),
            new CourseGrade("CPE 476", 99),
            new CourseGrade("CPE 572", 100)));

      List<String> expected = Arrays.asList("Julie", "Zoe");

      /*
       * Why compare HashSets here?  Just so that the order of the
       * elements in the list is not important for this test.
       */
      assertEquals(new HashSet<>(expected),
         new HashSet<>(ExampleMap.highScoringStudents(
            courseListsByStudent, 85)));
   }

   @Test
   public void testExampleMap2() {
      /* TO DO: Write another valid test case. */
      // New test case
      Map<String, List<CourseGrade>> courseListsByStudent = new HashMap<>();
      courseListsByStudent.put("S5",
         Arrays.asList(
            new CourseGrade("CPE 123", 92),
            new CourseGrade("CPE 101", 90)));
      courseListsByStudent.put("S4",
         Arrays.asList(
            new CourseGrade("CPE 101", 86),
            new CourseGrade("CPE 202", 80),
            new CourseGrade("CPE 203", 76),
            new CourseGrade("CPE 225", 80)));
      courseListsByStudent.put("S1",
         Arrays.asList(
            new CourseGrade("CPE 123", 100),
            new CourseGrade("CPE 203", 100),
            new CourseGrade("CPE 471", 100),
            new CourseGrade("CPE 473", 100),
            new CourseGrade("CPE 476", 100),
            new CourseGrade("CPE 572", 100)));
      courseListsByStudent.put("S2",
         Arrays.asList(
            new CourseGrade("CPE 123", 99),
            new CourseGrade("CPE 203", 91),
            new CourseGrade("CPE 471", 86)));

      List<String> expected = Arrays.asList("S1");

      assertEquals(new HashSet<>(expected),
         new HashSet<>(ExampleMap.highScoringStudents(
            courseListsByStudent, 99)));
   }
}
