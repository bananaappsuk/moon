Feature: Assessing the favourites
  inorder to see the added favourites
  I want to quick look at the blips


  Scenario: Check if favorite function saves blippers and can be opened
    Given user is in the home screen
    When he go to favoruites screen
    Then he should see a blipper added as favorite
    When I open the blipper it should open the selected blipper
