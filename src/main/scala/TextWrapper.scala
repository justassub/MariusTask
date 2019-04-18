import scala.annotation.tailrec
import scala.util.Properties

object TextWrapper {
  def wrapText(text: Stream[String], maxSize: Int): Stream[String] = {

    @tailrec
    def processLine(line: String, proccessedLines: Stream[String] = Stream.empty): Seq[String] = {
      val pattern = ("^.{" + maxSize + ",}$").r
      val textToProcess = line take maxSize
      textToProcess match {
        case pattern() if (!textToProcess.endsWith(" ") && textToProcess.contains(" ")) =>
          processLine(line.substring(textToProcess.lastIndexOf(" ") + 1), proccessedLines #::: Stream(textToProcess.substring(0, textToProcess lastIndexOf " ").trim))
        case pattern() => processLine(line.substring(maxSize), proccessedLines #::: Stream(textToProcess))
        case _ => proccessedLines #::: Stream(textToProcess)
      }
    }

    text.flatMap(processLine(_).map(_ + Properties.lineSeparator)).filter(_.trim.nonEmpty)
  }

}