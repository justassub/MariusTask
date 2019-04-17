import org.scalatest.{FlatSpec, Matchers}
import util.FileReader

class ProcessorIT extends FlatSpec with Matchers {
  "Processor" should "wrap data and store information " in {
    new DataProcessor("src/test/resources/testString.txt", 5).calcuteAndSaveResult;
    val result = FileReader.readResource("target/test/output/file.txt")
    result should be equals "123\n4\n1\n123\n4"
  }

}
