## Overview
This folder contains the automated test scripts designed for the **API regression testing** of our application using **Rest Assured**. As part of the QA process, these tests ensure that the API endpoints remain functional after code changes, preventing the introduction of new bugs during the development cycle.

## Purpose
The main objective of the automation framework is to:
- Perform **regression testing** for API endpoints to ensure the stability and reliability of the application.
- Detect any issues introduced during new deployments or feature additions.
- Validate API responses, status codes, and request payloads to match the expected behavior.

## Project Structure
The project is built using **Rest Assured** for API automation and integrates with **TestNG** for test execution and reporting. The structure of the project is as follows:

- **src/test/java**: Contains all the API test scripts categorized by feature or module.
- **src/main/resources**: Stores configuration files, such as environment URLs and API credentials.
- **reports**: Stores test execution reports generated after each test run, using **Extent Reports**.
- **config**: Contains configuration files for managing environment-specific variables and test data.

## Key Features
- **Automated API Testing**: Automated tests covering all API endpoints, including both positive and negative test scenarios.
- **Regression Testing**: Tests are triggered before every major release to verify that existing functionality is not broken.
- **Reporting**: Detailed test execution reports are generated with **Extent Reports**, providing insight into test results and failures.
- **Environment Support**: The framework supports multiple environments (e.g., staging, production) and can easily switch between them.

## How to Run the Tests
1. Clone the repository and navigate to the `testing` folder.
2. Ensure all dependencies are installed via Maven (or Gradle if used).
3. Use the following Maven command to run the tests:
   ```bash
   mvn clean test
   ```
4. After execution, reports will be available.
