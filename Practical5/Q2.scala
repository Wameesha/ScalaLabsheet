object Q2{

    case class Book(title: String, author: String, isbn: String)

    def main(args: Array[String]): Unit = {
        var library: Set[Book] = Set(
            Book("To Kill a Mockingbird", "Harper Lee", "9780061120084"),
            Book("1984", "George Orwell", "9780451524935"),
            Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565") 
        )

        displayLibrary(library)
        library = addBook(library, Book("Brave New World", "Aldous Huxley", "9780060850524"))
        library = removeBookByISBN(library, "9780451524935")
        println(s"Book with ISBN '9780061120084' exists: ${checkBookByISBN(library, "9780061120084")}")
        searchBookByTitle(library, "The Great Gatsby")
        displayBooksByAuthor(library, "Harper Lee")
    }

    def addBook(library: Set[Book], book: Book ): Set[Book] ={
        library + book
    }

    def removeBookByISBN(library: Set[Book], isbn:String): Set[Book] = {
        library.filterNot(_.isbn == isbn)
    }

    def checkBookByISBN(library: Set[Book], isbn:String): Boolean = {
        library.exists(_.isbn == isbn)
    }

    def displayLibrary(library: Set[Book]): Unit ={
        println("Current Library Collecton: ")
        library.foreach{ book =>
            println(s"Title: ${book.title}-> Author: ${book.author}-> ISBN: ${book.isbn}")
        }
    }

    def searchBookByTitle(library: Set[Book], title:String): Unit ={
        val foundBooks = library.filter(_.title.equalsIgnoreCase(title))
        if (foundBooks.nonEmpty) {
           println(s"Books found with title '$title':")
           foundBooks.foreach { book =>
           println(s"Title: ${book.title}-> Author: ${book.author}-> ISBN: ${book.isbn}")
           }
        } else {
           println(s"No books found with title '$title'")
        }
    }

    def displayBooksByAuthor(library: Set[Book], author:String): Unit = {
        val booksByAuthor = library.filter(_.author.equalsIgnoreCase(author))
        if (booksByAuthor.nonEmpty){
            println(s"Book by author '$author':")
            booksByAuthor.foreach{book =>
                println(s"Title: ${book.title}-> Author: ${book.author}-> ISBN: ${book.isbn} ")
            }
        }else{
            println(s"No books found by author '$author")
        }
    }
}