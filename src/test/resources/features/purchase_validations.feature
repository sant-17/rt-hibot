#language: en

  Feature: Purchase validation on SauceDemo

    Scenario Outline: Successful purchase order
      Given a user is on the homepage and logged in with username "<user>" and password "<password>"
      When add "<product1>" and "<product2>" to the cart
      And proceed to checkout with their name "<firstName>", "<lastName>" and postal code "<postalCode>"
      Then the displayed subtotal should equal the sum of the selected products
      And the message "<message>" confirming the purchase should be displayed

      Examples:
      |user         |password     |product1           |product2         |firstName  |lastName |postalCode   |message                  |
      |standard_user|secret_sauce |Sauce Labs Backpack|Sauce Labs Onesie|Juan       |Perez    |1234         |THANK YOU FOR YOUR ORDER |