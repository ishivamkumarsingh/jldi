Feature: Purchase a product from nopCommerce

  Scenario: User purchases a product successfully
    Given User launches the nopCommerce website
    When User logs in with valid credentials
    And User navigates to Electronics -> Cell Phones
    And User selects the third product and adds to cart
    And User goes to the shopping cart
    And User selects Yes for Gift Wrapping and proceeds to checkout
    And User fills required fields and confirms the order
    Then User should see order confirmation message
    And User logs out


