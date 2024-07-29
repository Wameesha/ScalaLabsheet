import scala.io.StdIn.{readLine, readInt}
import scala.util.Try

object StudentRecordsApp {
  
  def getStudentInfo(): (String, Int, Int, Double, Char) = {
    var validInput = false
    var name = ""
    var marks = 0
    var totalMarks = 0
    var percentage = 0.0
    var grade = 'F'

    while (!validInput) {
      println("Enter student name:")
      name = readLine()
      println("Enter student marks:")
      marks = Try(readInt()).getOrElse(-1)
      println("Enter total possible marks:")
      totalMarks = Try(readInt()).getOrElse(-1)

      val validationResult = validateInput(name, marks, totalMarks)
      validInput = validationResult._1
      if (!validInput) {
        println(s"Invalid input: ${validationResult._2.getOrElse("")}")
      }
    }

    percentage = (marks.toDouble / totalMarks) * 100

    grade = percentage match {
      case p if p >= 90 => 'A'
      case p if p >= 75 => 'B'
      case p if p >= 50 => 'C'
      case p if p < 50  => 'D'
    }

    (name, marks, totalMarks, percentage, grade)
  }

  def printStudentRecord(record: (String, Int, Int, Double, Char)): Unit = {
    val (name, marks, totalMarks, percentage, grade) = record
    println(s"Student Name: $name")
    println(s"Marks Obtained: $marks / $totalMarks")
    println(s"Percentage: $percentage%")
    println(s"Grade: $grade")
  }

  def validateInput(name: String, marks: Int, totalMarks: Int): (Boolean, Option[String]) = {
    if (name.isEmpty) 
      return (false, Some("Name cannot be empty"))
    if (marks < 0 || marks > totalMarks) 
      return (false, Some("Marks must be a positive integer and not exceed total possible marks"))
    (true, None)
  }

  def getStudentInfoWithRetry(): (String, Int, Int, Double, Char) = {
    var validInput = false
    var name = ""
    var marks = 0
    var totalMarks = 0

    while (!validInput) {
      println("Enter student name:")
      name = readLine()
      println("Enter student marks:")
      marks = Try(readInt()).getOrElse(-1)
      println("Enter total possible marks:")
      totalMarks = Try(readInt()).getOrElse(-1)

      val validationResult = validateInput(name, marks, totalMarks)
      validInput = validationResult._1
      if (!validInput) {
        println(s"Invalid input: ${validationResult._2.getOrElse("")}")
      }
    }

    val percentage = (marks.toDouble / totalMarks) * 100
    val grade = percentage match {
      case p if p >= 90 => 'A'
      case p if p >= 75 => 'B'
      case p if p >= 50 => 'C'
      case p if p < 50  => 'D'
    }

    (name, marks, totalMarks, percentage, grade)
  }

  def main(args: Array[String]): Unit = {
    val studentInfo = getStudentInfoWithRetry()
    printStudentRecord(studentInfo)
  }
}
