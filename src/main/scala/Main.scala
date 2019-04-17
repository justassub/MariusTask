

object Argument {

  case class Argument(fileLocation: String, maxValue: Int)

  def validateArguments(arguments: Array[String]): Unit = {
    require(arguments.length > 1)
    require(arguments(0) nonEmpty)
    require(arguments(1).toInt > 0)
  }

  def buildArgument(argument: Array[String]) = Argument(argument(0), argument(1).toInt)
}

private case class Arguments(fileLocation: String, maxValue: Int)

object Main extends App {
  Argument.validateArguments(args)
  val arguments = Argument.buildArgument(args)
  new DataProcessor(arguments.fileLocation, arguments.maxValue)
}