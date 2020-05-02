package com.github.valrcs.finalproject

import org.apache.spark.sql.SparkSession

object MyApp {
  def main(args: Array[String])={

    println(s"Starting our App with ${args.length} arguments")
//    for (arg:String <- args) {
//      println(s"My arg is ${arg}")
//    }

    if (args.length >= 2) {
      //real works starts here
      val spark = init(Array("Something", "Something"))
      println(s"Our first argument is ${args(0)}")
      TextProcessingModule.getDonuts(args(0))
      val outFile = FileUtilities.unzipFile((args(1)))
      println(s"Will work on this file $outFile")
      val fullJSONFilePath = s"c:/temp/$outFile"
      val stores = TextProcessingModule.getSalesJSON(fullJSONFilePath, spark)
      val storeReport = DataTransform.getTopSeller(stores)
      //TODO more transformations, save to Database
      storeReport.printReport()
      storeReport.printReport("c:/temp/donut_report.txt")

    }
    println("All done")
  }

  def init(configArguments: Array[String]):SparkSession={
    val spark = SparkSession.builder.appName("Simple Application").config("spark.master", "local").getOrCreate()
    spark
  }

}
