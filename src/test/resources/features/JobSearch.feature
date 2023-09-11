Feature: Navigation to Job Search
  Description: 	This feature focuses on navigating to job search page via different routes and vlidating links on the page.

  Background: 
    Given User is on Deutsche Bank career page

  @smoke @sanity @regression @Test1
  Scenario: Verify user is able to access Deutsche Bank job search page
    Given User hovers mouse over Professionals link
    When User clicks on Search Roles
    Then User is able to view Jobs search page

  @sanity @regression @Test2
  Scenario: Verify user is able to access all the links present under Professionals section
    Given User hovers mouse over Professionals link
    When User is able to view Search Roles,FAQ, Professionals and  A notice on Recruitment Scams link
    Then Validate that user is able to access all the links.

  @sanity @regression @Test3
  Scenario: Verify that user is able to navigate to Job search results page by different routes
    Given User clicks on Professionals link
    Then User is able to view Jobs search page
    And On clicking Search Roles under professionsal tab user is able to view Jobs search page
    And On clicking more button under professionsal section user is able to view Jobs search page
    And On clicking View and Apply button on Your application user is able to view Jobs search page

  @sanity @regression @Test4
  Scenario: Verify that all the links on Careers page are working
    Given User clicks on Professionals link
    When User checks for any broken links on the page
    Then There should be no broken links on the page
