Feature: TCs for placing orders

  @order
  Scenario: Place order and verify Amount
    Given Open home page
    When Navigate to "Laptops" category from left navigation
    And Open product "Sony vaio i5" from product listing page
    And Click Add to cart on product page
    And Accept confirmation popup
    And Open home page
    And Navigate to "Laptops" category from left navigation
    And Open product "Dell i7 8gb" from product listing page
    And Click Add to cart on product page
    And Accept confirmation popup
    And Navigate to cart
    And Delete product "Dell i7 8gb" from cart
    And Save basket Order Total price
    And Click 'Place order' button
    And Fill the user information
    And Click 'Purchase' button
    Then Verify Order is placed successfully
    Then Verify order amount on order confirmation page
    Then Click 'OK' button on Order confirmation page
