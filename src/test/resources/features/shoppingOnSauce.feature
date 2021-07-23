@shoppingOnSauce
Feature: shopping on sauce
  Scenario: shopping on sauce site
  Given user is logged in into the site
  When user is on landing page
  And user should be able to select "lohi" from dropdown
  And user should be able to add multiple items to shopping cart
  Then user clicks on shopping cart
  And user should verify items selected are present in the cart
  And user removes item from cart
  And user continue shopping
  Then user add another item to the cart and select checkout button
  And user should verify items purchased are correct
  Then user verifies total price is correct
  And user clicks on checkout button