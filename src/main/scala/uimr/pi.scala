package uimr

import scala.io.Source
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object Pi {
  def main(args: Array[String]) {
    // set spark context
    val conf = new SparkConf().setAppName("My Spark-Scala Pi Application")
    val sc = new SparkContext(conf)
    
    val NUM_SAMPLES=10000
    val count = sc.parallelize(1 to NUM_SAMPLES).map{i =>
      val x = Math.random()
      val y = Math.random()
      if (x*x + y*y < 1) 1 else 0
      }.reduce(_ + _)
    println("Pi is roughly " + 4.0 * count / NUM_SAMPLES)
  }
}
