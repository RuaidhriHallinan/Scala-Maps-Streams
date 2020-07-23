package com.rh.test

/**
 * The system is event based so trades arrive at this consumer out of order.
 * To fix this issue, tradesStream must be sorted with the following rules:
 *
 * * SWAP trades are represented by two strings (i.e. 123CB SELL or 9898AA BUY), orderNumber and buySell respectively.
 *   - order numbers must be sorted lexicographically (i.e 11 before 11C)
 *   - Sells (SELL) must be processed before Buys (BUY) by stacking SELL/BUY pairs with the same orderNumber
 *
 * * CASH trades are represented by two numbers (i.e. 984756 34566), code and serial respectively.
 * CASH trades must be processed in order of appearance, after all SWAPs are processed
 *
 * Please take a look at the test class for some examples
 */
object TradeStreamScalaMe {

  val SELL: String = "SELL"

  /**
   * Extracts Swap trades from trades stream. Sorts them lexicographically first,
   * then sorts each Swap trade by verifying which contains contains "SELL" string.
   * Finally the Swap trades are merged with the unchanged Cash trades.
   *
   * @param tradesStream - Trade stream containing Cash and/or Swap trades.
   * @return Sorted Seq of Trades with Swap Trades merged on top of unchanged Cash
   *         trades.
   */
  def orderTrades(tradesStream: String*): Seq[String] = {
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
    swapsReduced ++ cashTrades
  }
}
