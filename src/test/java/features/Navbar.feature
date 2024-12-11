@Navbar
Feature: Testing of 2nhaber.com website navbar elements

    Scenario: Click on all navbar elements and check if the pages open
      Given User is on home page
      When The user clicks on all elements in the navbar in order
      Then After each click, the relevant page should open without any problems