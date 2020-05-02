package com.github.valrcs.finalproject

import org.apache.spark.sql.SparkSession


object TextProcessingModule {
  def getTextData(filePath: String)={
    println(s"Opening File ${filePath}")
    //TODO actually get data
  }
  def getDonuts(filePath: String):Seq[Donut]={
    println(s"Opening File ${filePath}")
    //TODO readlines from text
    //TODO split by seperator and create a sequence of Donuts
    //fake data examples
//    (1 to 5).foreach(println)
//    val myDonuts: Seq[Donut] =  (1 to 5).map(Donut("Choco", _, 1.75, "Pink"))
    val myDonuts: Seq[Donut] = Seq(Donut("Banana",6,10.2, "Pink"),Donut("Choco",6,10.2, "Orange"))
    myDonuts
  }
  def getSalesJSON(filePath: String, spark:SparkSession): Seq[Store]={
    import spark.implicits._
    println(s"Opening JSON at $filePath")
    //TODO open JSON
    val storesDF = spark.read.option("multiline", "true").json(filePath)
    println(storesDF.show)
    val myRows = storesDF.as[Store].take(5)


    Seq(Store(1, "Terases", "Tomsona", "tstore@donuts.lv", "45.67"),
      Store(2, "Smoggy", "Valdemara", "tstore2@donuts.lv", "345.67")
    )
  }
}
