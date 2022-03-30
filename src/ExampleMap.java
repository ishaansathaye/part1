
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ExampleMap {

  /**
   * Return a list of "high scoring" students --- High scoring students are
   * students who have all grades strictly greater than the given threshold.
   * 
   * @param scoresByApplicantName A map of applicant names to applicant scores
   * @param scoreThreshold        The score threshold
   * @return The list of high-scoring applicant names
   */
  public static List<String> highScoringStudents(Map<String, List<CourseGrade>> scoresByApplicantName, int scoreThreshold) {
    List<String> final_names = new LinkedList<String>();
    for (String name : scoresByApplicantName.keySet()) {
      List<CourseGrade> grades = scoresByApplicantName.get(name);
      for (CourseGrade grade : grades) {
        if (grade.getScore() < scoreThreshold) {
          return new LinkedList<>();
        }
      }
    }
    return null;
  }
}
