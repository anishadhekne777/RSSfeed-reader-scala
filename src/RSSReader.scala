import java.net.URL
import java.net.{URL, URLConnection}
import com.rometools.rome.feed.synd.{SyndFeed}
import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import scala.collection.JavaConverters._
import scala.io.Source

/**
 * @anisha
 *
 */
object RSSReader extends App{
   // NOTE: code can throw exceptions
  val feedUrl = "feedUrl.scala"
for (line <- Source.fromFile(feedUrl).getLines) {
  println("RSS Feed URL: " + line)
  println("")
    val input = new SyndFeedInput
    val feed: SyndFeed = input.build(new XmlReader(new URL(line)))
  //val feedUrl = new URL("https://www.npr.org/rss/rss.php?id=100")
    //println(feed)
    // `feed.getEntries` has type `java.util.List[SyndEntry]`
    val entries = asScalaBuffer(feed.getEntries).toVector

    for (entry <- entries) {
        println("Title: " + entry.getTitle)
        println("URI:   " + entry.getUri)
        println("Date:  " + entry.getPublishedDate)
        println("Contributers:  " + entry.getAuthor)
        // java.util.List[SyndLink]
        val links = asScalaBuffer(entry.getLinks).toVector
        for (link <- links) {
            println("Link: " + link.getHref)
        }

        val contents = asScalaBuffer(entry.getContents).toVector
        for (content <- contents) {
            println("Content: " + content.getValue)
        }

        val categories = asScalaBuffer(entry.getCategories).toVector
        for (category <- categories) {
            println("Category: " + category.getName)
        }

        println("")
    }
}
    def getUrlConnection(url: String): URLConnection = {
    val urlConnection = new URL(url).openConnection
    urlConnection.setConnectTimeout(1000)
    urlConnection.setReadTimeout(1000)
    urlConnection
    }

}