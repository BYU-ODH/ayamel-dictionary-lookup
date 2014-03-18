package controllers

import edu.byu.arclite.dictionary.DictionaryCache

object LookupBYU extends Translator {

  val name = "BYU Dictionaries"
  val expiration = Utils.getExpiration("byu")

  /**
   * Endpoint for translating via BYU Dictionaries
   */
  def translate(src: String, dest: String, text: String) = {
      val firstTry = DictionaryCache.getDictionaryEntry(src + "-" + dest, text)
      if (firstTry != None) firstTry else DictionaryCache.getDictionaryEntry(src + "-" + dest, text.toLowerCase)
    }
}