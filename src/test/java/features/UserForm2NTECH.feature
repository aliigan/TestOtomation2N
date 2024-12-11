@UserForm
Feature: Testing The User Form

      Scenario: Fill out the form and send it
        Given User is on home page
        When Write name surname as "Ali Test"
        And Write birtdate as "12.04.1995"
        And Write Turkish Identification number as "99133454634"
        And Write mobile number as "05549920101"
        And Write mail as "mail587456@gmail.com"
        And Upload CV
        And Select education as "Lisans"
        And Click to next button
        Then User must be on details page
        When Select  position as "Test Engineer"
        And Click to send button
        Then The form must be sent successfully