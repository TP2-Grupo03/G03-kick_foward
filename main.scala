import java.nio.file.Path

import scala.io.Source
import scala.io.StdIn.readLine
import scala.collection.mutable.HashMap
import scala.collection.immutable.ListMap

import cats.implicits._
import com.monovore.decline._

/**
  * Dado um 'path' para um arquivo, lê as linhas do arquivo e chama a função seguinte
  * 
  */  
def readFile(path: String, func: ((List[String], String) => String) => Unit, normalize: String => Unit) = { 
  val data = Source.fromFile(path).getLines.toList
  func(data, normalize)
}

def normalize(data: String) = {
  println("a")  
}

// def normalize(str_data: List[String], func: (String, String) => Unit) = {
   // func(str_data.toLowerCase(), removeStopWords)
// }


/**
  * Leitura da entrada
  */
object Main {
  def main(args: Array[String]): Unit = {
    args.toList match {
      case "--words" :: n :: x :: Nil =>
        println(s"Received --words with parameters: n = $n, x = $x")
      case _ =>
        println("Invalid arguments. Expected format: --words <n> <x>")
    }
  }
}

/**
  * Retorna um set com as stop-words.
  */ 
def stopWords() = Set("the", "about", "above", "after", "again", "against",
    "all", "and", "any", "because", "before", "below", "between", "but",
    "down", "during", "for", "from", "further", "here", "into", "more","once",
    "only", "other", "over", "same", "some", "such", "that", "then",
    "there", "these", "this", "those", "through", "under", "until", "very",
    "what", "when", "where", "which", "while", "who", "which",
    "with", "could", "were", "your", "have", "will", "been", "would", 
    "they", "their", "should", "myself", "them", "upon", "might",
    "first", "eyes", "every", "you", "than", "thought", "whom", "ever",
    "most", "even","said", "shall", "towards", "found", "being",
    "time", "also", "him", "her", "still", "must", "many")