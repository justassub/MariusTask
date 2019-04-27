import scala.annotation.tailrec
import scala.util.Properties

object TextWrapper {
  def wrapText(text: Iterator[String], maxSize: Int): Iterator[String] = {

    @tailrec
    def processLine(line: String, proccessedLines: Stream[String] = Stream.empty): Stream[String] = {
      val pattern = ("^.{" + maxSize + ",}$").r
      val textToProcess = line take maxSize
      textToProcess match {
        case pattern() if (!textToProcess.endsWith(" ") && textToProcess.contains(" ")) =>
          processLine(line.substring(textToProcess.lastIndexOf(" ") + 1).trim, proccessedLines :+ textToProcess.substring(0, textToProcess lastIndexOf " ").trim)
        case pattern() => processLine(line.substring(maxSize).trim, proccessedLines :+ textToProcess.trim)
        case string if string isEmpty => proccessedLines
        case _ => proccessedLines :+ textToProcess
      }
    }

    text.flatMap(processLine(_))
  }

}