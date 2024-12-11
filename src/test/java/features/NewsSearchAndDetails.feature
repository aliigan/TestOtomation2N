@NewsSearch
Feature: 2nhaber.com News Search and News Details Test

    Scenario Outline: Check news details
      Given User is on home page
      When Click to search button
      And Type "<search_word>" in the search field and search
      Then List of search results should be displayed
      When User goes to the details of the news number "<news_order>"
      Then News number "<news_title>" should be displayed successfully
      Examples:
        | search_word | news_order |                        news_title                           |
        |   İstanbul  |      8     |  Türkiye’nin ilk sanal gerçeklik müzesi açılıyor            |
        |   Ankara    |      3     |  Türkiye’nin elektrik altyapısına 1,5 milyar dolar yatırım  |
