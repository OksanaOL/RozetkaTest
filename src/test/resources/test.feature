Feature: Search product
  In order to buy some product
  As private person
  I want easy find and buy it using online shop

  Background:
    Given Start browser

  Scenario Outline: Search result should show item
    Given Open Rozetka home page
    When Enter product "<title>" in search field
    Then Press Search button
    Examples:
      | title                                  |
      | Навушники Xiaomi AirDots/Earbuds Basic |
      | Samsung Galaxy M21 4/64GB Green        |


  Scenario: Verification if all prices are shown in grivna
    Given Rozetka site is opened
    When Scroll till end off page to load all products
    Then Prices are shown in Grivna

  Scenario: Verification if product is oin cart after pressing buy button
    Given Requested product is shown and buy button is pressed
    When Product Cart is opened - item is present
    And Plus button is pressed - total price is changed
    Then Product Cart is closed

