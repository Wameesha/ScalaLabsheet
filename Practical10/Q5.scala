object Q5{
    def main(args: Array[String]): Unit = {

        def countLetterOccurrences(words: List[String]): Int = {
            val letterCounts = words.map(_.length)
            val totalLetterCount = letterCounts.reduce(_+_)
            totalLetterCount
        }

        val words= List("apple", "banana", "cherry", "date")
        val totalCount = countLetterOccurrences(words)
        println(s"Total count of letter occurences: $totalCount")
    }
}