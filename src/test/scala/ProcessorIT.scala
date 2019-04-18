import org.scalatest.{FlatSpec, Matchers}
import util.FileReader

class ProcessorIT extends FlatSpec with Matchers {
  "Processor" should "wrap data and store information " in {
    new DataProcessor("src/test/resources/testString.txt", 3).calcuteAndSaveResult;
    val result = FileReader.readResource("target/test/output/file.txt")
    result shouldEqual  Stream("123", "4", "1", "123", "4")
  }

}
