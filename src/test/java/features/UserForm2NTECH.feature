@UserForm
Feature: Testing The User Form

      Scenario: Fill out the form and send it
        Given User is on home page
        When Write name surname as "Test User"
        And Write birtdate as "12.12.2000"
        And Write Turkish Identification number as "74126985432"
        And Write mobile number as "05540002222"
        And Write mail as "mail58745689@gmail.com"
        And Upload CV
        And Select education as "Lisans"
        And Click to next button
        Then User must be on details page
        When Select  position as "Test Engineer"
        And Click to send button
        Then The form must be sent successfully