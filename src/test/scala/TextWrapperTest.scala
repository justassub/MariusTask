import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}

class TextWrapperTest extends FunSuite with Matchers with TableDrivenPropertyChecks {
  val mariusExamples =
    Table(
      ("text", "max length", "result"),
      (Stream("Green metal stick"), 13, Seq("Green metal", "stick")),
      (Stream("Establishment of the church"), 7, Seq("Establi", "shment", "of the", "church")),
      (Stream("Lorem ipsum", "dolor sit amet"), 9999, Seq("Lorem ipsum", "dolor sit amet")),
      (Stream("1234", "1", "1234"), 3, Seq("123", "4", "1", "123", "4")),
      (Stream("Lorem ipsum"), 6, Seq("Lorem", "ipsum"))
    )
  test("Text wrapper tests") {
    forAll(mariusExamples) {
      TextWrapper.wrapText(_, _) should contain allElementsOf (_)
    }
  }
}
