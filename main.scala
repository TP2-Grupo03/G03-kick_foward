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
def read_file(path: String, func: (List[String], (List[String], (List[String], (List[String], HashMap[String, Int] => Unit) => Unit) => Unit) => Unit) => Unit): Unit = { 
  var lines = Source.fromFile(path).getLines.toList

  // chama filter_chars
  func(lines, scan)
}

/**
  * Recebe as linhas do arquivo, remove todos os caracteres não-alpha,
  * transforma todas as palavras em lower case e, em seguida, chama a função scan
  */ 
def filter_chars(lines: List[String], func: (List[String], (List[String], (List[String], HashMap[String, Int] => Unit) => Unit) => Unit) => Unit): Unit = {
  //var words = lines.map(s => s.replaceAll("[^a-zA-Z]", "").toLowerCase()) 
  var words = lines.map(s => s.replaceAll("[^a-zA-Z\\s]", "").toLowerCase())
  // chama scan
  func(words, removeStopWords)
}

/**
  * Recebe as linhas de um arquivo contendo apenas caracteres alpha
  * e cria uma lista com todas as palavras separadas. 
  */
def scan(lines: List[String], func: (List[String], (List[String], HashMap[String, Int] => Unit) => Unit) => Unit): Unit = {
  var words = lines.flatMap(line => line.split(" "))
  // chama removeStopWords
  func(words, frequencies)
}

/**
  * Dada uma lista de palavras, remove as palavras que são stopWord.
  */ 
def removeStopWords(words : List[String], func: (List[String], HashMap[String, Int] => Unit) => Unit): Unit = {
  words.filter(w => ! isStopWord(w) && w.size > 3)
  // chama frequencies
  func(words, sortAndPrint)
}


/**
  * Dada uma lista de palavras, conta a frequencia com que elas
  * ocorrem na lista. Retorna um Mapa de String (palavra) para Int (frequencia). 
  */ 
def frequencies(words: List[String], func: HashMap[String, Int] => Unit): Unit = {
  val res = new HashMap[String, Int]()
  words.foreach(w => res += w -> (res.getOrElse(w, 0) + 1))
  // chama sortAndPrint
  func(res)

}

/**
  * Retorna as 10 palavras mais frequentes. 
  */ 
def sortAndPrint(map: HashMap[String, Int]): Unit = {
  //val sorted_map = ListMap(map.toSeq.sortWith(_._2 > _._2):_*)//.take(10)
  val sorted_map = ListMap(map.toSeq.sortWith(_._2 > _._2)*)

  //printa o conteúdo do HashMap
  for ((key, value) <- sorted_map) {
  println(s"$key - $value")
  }
}
/**
  * Leitura da entrada
  */
object Main {
  def main(args: Array[String]): Unit = {
    args.toList match {
      // case "--words" :: count :: input :: Nil =>
      case "--words" :: input :: Nil =>
        read_file(input, filter_chars)
      case _ =>
        // println("Invalid arguments. Expected format: --words <count> <InputText>")
        println("Invalid arguments. Expected format: --words <InputText>")
    }
  }
}

