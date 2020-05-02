package com.github.valrcs.finalproject

//TODO divide Store Report into more detailed sub categories
case class StoreReport(id: Int, description: String, topSeller: Double) {
  def printReport(filePath: String = ""): Unit ={
    if (filePath == "") {
      println(s"Our Top store has id $id, and sells $topSeller worth of Donuts in a day")
      println(s"Full description: $description")
    } else {
      val buf = new StringBuilder
      buf += '\n' // so += for single chars in 'c' and ++= for "strings"
      buf ++= s"Our Top store has id $id, and sells $topSeller worth of Donuts in a day"
      buf += '\n'
      buf ++= s"Full description: $description"
      FileUtilities.writeFile(filePath, buf.toString)
    }

  }
}
