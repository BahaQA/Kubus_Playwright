@reg
@US01
Feature: Job Application

  Scenario Outline: An applicant should be able to apply for an open position
    Given the applicant is on the home page
    When the applicant clicks the Jobs button
    And the applicant selects the "<department>"
    And the applicant selects a "<position>"
    And the applicant scrolls down the job details
    And the applicant clicks the Apply button
    And the applicant uploads their "<resume>"
    And the applicant enters "<full name>", "<email address>", and "<phone number>"
    And the applicant checks the Legal Agreements
    And the applicant clicks the Send button
    Then the application should be sent and "<confirmation message>" should be displayed
    Examples:
      | department  | position | full name          | email address                | phone number | confirmation message           | resume                                                                                              |
      | Development | SDET     | Bahadir Kucukuysal | bahadir.kucukuysal@cydeo.com | +31685075493    | Thank you for your application | C:\Users\bkucu\IdeaProjects\Kubus_Playwright\src\test\resources\files\Bahadir Kucukuysal_Resume.pdf |



















