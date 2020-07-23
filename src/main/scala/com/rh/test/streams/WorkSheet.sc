import com.rh.test.TradeStreamScalaMe.SELL
import scala.collection._

val tradesStream = Seq(
  "1921020 212",
  "9898AA SELL",
  "32332 443",
  "784758458 2112",
  "9898AA BUY",
  "123CB BUY",
  "232334 121211221",
  "123CB SELL")

//Function for checking if a trade is a SwapTrade
val isSwapTrade = (trade: String) =>

  trade match {
    case x if x.contains(SELL) || x.contains("BUY") => true
    case _ => false
  }

val swapTrades = tradesStream.filter(isSwapTrade) // BUYS & SELLS eg "9898AA BUY" or "123CB SELL"
val cashTrades = tradesStream.filterNot(isSwapTrade) // Code & Serial eg "984756 34566"

//Sorting and grouping for swapTrades Only

//Create map for sorting
val groupSplit = swapTrades.groupBy(_.split(" ")(0))

//Sort lexicographically by orderNumber
val arrangeSortGroups = groupSplit.toSeq.sortBy(_._1)

//Sort by transaction type
val sortByTrades = arrangeSortGroups.map(_._2.sortWith(
  (a, b) => {
    a.endsWith(SELL)
  }))

//Reduce Collections again
val swapsReduced = sortByTrades.reduce(_ ++ _)

//Concatenate Seqs
val ret = swapsReduced ++ cashTrades
