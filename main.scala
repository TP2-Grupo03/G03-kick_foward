import java.nio.file.Path

import scala.io.Source
import scala.io.StdIn.readLine
import scala.collection.mutable.HashMap
import scala.collection.immutable.ListMap

import cats.implicits._


// ========= Helpers ===================

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

/**
  * Retorna verdadeiro se 'word' for um stopWord. 
  */ 
def isStopWord(word: String) = stopWords().contains(word.toLowerCase()) 


// =========== Funcoes =================
// TODO: Atualizar as funções à medida que novas funções forem implementadas  

/**
  * Dado um 'path' para um arquivo, lê as linhas do arquivo e chama a função seguinte, filter_chars
  * 
  */
def read_file(path: String, func: List[String] => Unit) = { 
  var lines = Source.fromFile(path).getLines.toList

  // chama filter_chars
  func(lines)
}

/**
  * Recebe as linhas do arquivo, remove todos os caracteres não-alpha,
  * transforma todas as palavras em lower case e, em seguida, chama a função scan
  */ 
def filter_chars(lines: List[String]) = {
  var words = lines.map(s => s.replaceAll("[^a-zA-Z]", "").toLowerCase())

   // chama scan
  // func(words)
}

/**
  * Recebe as linhas de um arquivo contendo apenas caracteres alpha
  * e cria uma lista com todas as palavras separadas. 
  */
// def scan(lines: List[String]) = {
//   words = lines.map(line => line.split(" "))
// }

/**
  * Leitura da entrada
  */
object Main {
  def main(args: Array[String]): Unit = {
    args.toList match {
      case "--words" :: count :: input :: Nil =>
        read_file(input, filter_chars(_: List[String]))
      case _ =>
        println("Invalid arguments. Expected format: --words <count> <InputText>")
    }
  }
}

