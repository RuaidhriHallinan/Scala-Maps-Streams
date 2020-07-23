

val sentences = List(
  "the quick brown fox",
  "the slow brown cow",
  "to be or not to be that is the question")

def searchSentenses(searchStr: String): Any = {
  sentences.map { r =>
    if(r.contains(searchStr)) {
      println(r)
    }
  }
}

searchSentenses("to")
