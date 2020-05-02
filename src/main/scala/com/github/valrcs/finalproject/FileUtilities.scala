package com.github.valrcs.finalproject

import better.files._

object FileUtilities {
  def unzipFile(filePath: String):String={
    println(s"Unzipping $filePath")
//    val zipFile: File = file"path/to/research.zip"
    val zipFile: File = File(filePath)
    val fileNames = zipFile.newZipInputStream.mapEntries(_.getName)
    val fileSeq = fileNames.toSeq
    fileSeq.foreach(println)
    val outFile: File = zipFile.unzipTo(destination = File("C:/temp"))
//    outFile.path.toString
    outFile.toString()
    //here you would need an if to check if there are really 2 files in the zip
    fileSeq(1)
  }

  def writeFile(filename: String, s: String): Unit = {
    val file = new java.io.File(filename)
    val bw = new java.io.BufferedWriter(new java.io.FileWriter(file))
    bw.write(s)
    bw.close()
  }
}
