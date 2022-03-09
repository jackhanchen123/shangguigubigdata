package com.sparkcore

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCount {

  def main(args: Array[String]): Unit = {


    val sparconf =new SparkConf().setMaster("local").setAppName("wordcount")
    val sc=new SparkContext(sparconf)


    println(sc.defaultMinPartitions)
    println(sc.defaultParallelism)


    // 读取数据
    val file = WordCount.getClass.getClassLoader.getResource("data/test.txt").getFile
    val value: RDD[String] = sc.textFile(file)


    //  数据处理rdd  转换算子filter
    val resultRdd: RDD[String] = value.filter(x => {
      if (x.contains("spark"))
        true
      else
        false
    })


  //行动算子
    resultRdd.foreach(println)

    sc.stop()
  }
//  转换算子
//
//  Rdd==>rdd
//
//  Retrun a new rdd
//
//  Filter map flatmap  sample reducebykey sortbykey sortby
//
//  行动算子
//
//  Rdd==>result
//
//  Launch a job to retrun a value to the user program



}
