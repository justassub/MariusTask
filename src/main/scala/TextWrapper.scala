import scala.annotation.tailrec
import scala.collection.mutable

object TextWrapper {
  @tailrec
  def wrapText(text: String, maxSize: Int, list: mutable.MutableList[String] = mutable.MutableList.empty[String]): mutable.MutableList[String] = {
    val pattern = ("^.{" + maxSize + ",}$").r
    val textToProcess = text take maxSize

    textToProcess match {
      case pattern(line)
        if line contains "\n" => wrapText(text.substring(line.indexOf("\n")), maxSize, list += textToProcess.substring(0, textToProcess lastIndexOf "\n"))
      case pattern() if (!textToProcess.endsWith(" ") && textToProcess.contains(" ")) =>
        wrapText(text.substring(textToProcess.lastIndexOf(" ") + 1), maxSize, list += textToProcess.substring(0, textToProcess lastIndexOf " ").trim)
      case pattern() => wrapText(text.substring(maxSize), maxSize, list += textToProcess.trim)
      case _ => if (textToProcess.contains("\n")) {
        wrapText(text.substring(textToProcess.lastIndexOf("\n") + 1), maxSize, list += textToProcess.substring(0, textToProcess lastIndexOf "\n").trim)
      } else {
        list += textToProcess
      }
    }
  }
}