Feature: Search and Validate Job Openings
  Description: 	This feature focuses on searching and validating jobs openings on Deutsche banks career page.

  Background: 
    Given User is on Deutsche Bank career page
    When User hovers mouse over Professionals link
    Then User clicks on Search Roles

  @smoke @regression @Test5
  Scenario: Verify job positions when user views all the open positions without applying any filters in Search By section
    Given User is on Job search Page
    When User clicks Search button without applying any filters
    Then Verify job search results page is displayed
    And Verify job position count matches the one displayed on job search page
    And Verify Number of job results displayed on the page

  @sanity @regression @Test6
  Scenario Outline: Verify user is able to search jobs by Division and is able to see relevant results after applying necessary filters in Search By section
    Given User is on Job search Page
    When User selects "Division" in Search By section
    Then User selects division category and other filters
      | Division Category | Country   | City   | Corporate title   | I want to work | What is your availability? |
      | <div_category>    | <country> | <city> | <corporate_title> | <job_type>     | <availability>             |
    And User clicks Search button
    And Verify job count matches with the total jobs on the page
    And Verify job search results page shows jobs from user has searched
      | City   | What is your availability? |
      | <city> | Full-time                  |

    Examples: 
      | div_category   | country | city      | corporate_title          | job_type  | availability |
      | Corporate Bank | India   | Mumbai    | Assistant Vice President | Permanent | Full time    |
      | Chairman       | Germany | Frankfurt |                          |           |              |

  @regression @Test7
  Scenario Outline: Verify user is able to search jobs by Profession and is able to see relevant results after applying necessary filters in Search By section
    Given User is on Job search Page
    When User selects "Profession" in Search By section
    Then User selects division category and other filters
      | Profession Category | Profession   | Country   | City   | Corporate title   | I want to work | What is your availability? |
      | <prof_category>     | <profession> | <country> | <city> | <corporate_title> | <job_type>     | <availability>             |
    And User clicks Search button
    And Verify job count matches with the total jobs on the page
    And Verify job search results page shows jobs from user has searched
      | City   | What is your availability? |
      | <city> | Full-time                  |

    Examples: 
      | prof_category | profession  | country | city      | corporate_title | job_type  | availability |
      | Operations    | Operations  | India   | Mumbai    | Associate       | Permanent | Full time    |
      | Technology    | Engineering | Germany | Frankfurt |                 |           |              |

  @regression @Test8
  Scenario Outline: Verify user is able to search jobs by providing Role Title in Keyword Search Section and is able to see relevant results
    Given User is on Job search Page
    When User enters a keyword in "<Role_Title>" search box
    And User clicks on Search button
    And User validates if the result contains the keywords that user has searched

    Examples: 
      | Role_Title    |
      | Operations    |
      | Selenium      |
      | aegufbsiukdfb |

  @regression @Test9
  Scenario Outline: Verify user is able to search jobs by providing Job ID in Job ID/Keyword Section and is able to see relevant results
    Given User is on Job search Page
    When User enters a "<Job_ID>" in Job ID Keyword Section
    And User clicks on Search button
    And User validates if the result contains the JobID that user has searched

    Examples: 
      | Job_ID   |
      | R0164048 |
      | R0231088 |
      | Finnish  |

  @smoke @sanity @regression @Test10
  Scenario Outline: Verify user is able to search jobs by providing both Role Title and Job ID and verify first preference is given to jobs having jobID
    Given User is on Job search Page
    When User enters a keyword in "<Role_Title>" search box
    And User enters a "<Job_ID>" in Job ID Keyword Section
    And User clicks on Search button
    And Verify first preference is given to jobs having searched jobID

    Examples: 
      | Role_Title | Job_ID          |
      | Operations | R0164048        |
      | Selenium   | 3456yttrdhyfjty |
