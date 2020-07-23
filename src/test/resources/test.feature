Feature: Search product



  Scenario: Search result should show item
    Given Open Rozetka home page
    When Enter product title in search field
    And press Search button
    Then all prices in search result are in grivna
