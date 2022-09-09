#Author: goyal.shivam002

@paybackTest
Feature: Login in Payback app and then apply first REWE coupon.

    Scenario: Coupon activation for a logged in user.
    Given Open the PAYBACK app
    And User login with valid credentials
    #Given User should be able to login using valid credentials
    When Click on Coupons
    And click on filter icon
    And Select Rewe from the filter
    Then Selected Coupon for Rewe should be activated
    And Rewe coupon will be displayed in Active section


