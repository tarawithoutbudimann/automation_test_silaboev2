# Login Test

## Table of Contents

- [Introduction](#introduction)
- [Project Structure](#project-structure)
  - [Overview](#overview)
  - [Page Object Model (POM)](#page-object-model-pom)
    - [Why POM?](#why-pom)
    - [Directory Structure](#directory-structure)
- [How to Navigate](#how-to-navigate)
- [Prerequisites](#prerequisites)
- [Dependencies](#dependencies)
- [How to Run Tests](#how-to-run-tests)


## Introduction

This project aims to automate the testing of a login page. The implementation is done using Maven, Java, JUnit, Selenium and Cucumber.

## Project Structure
## Overview

This project is structured following best practices and utilizes the Page Object Model (POM).

## Page Object Model (POM)

This project follows the Page Object Model (POM) architectural pattern for organizing and structuring automated tests. 
POM is a design pattern widely used in test automation to enhance the maintainability and reusability of test code.

## Why POM?

1. **Modularity:** POM promotes modularity by separating the application's UI components into distinct page objects. Each page object encapsulates the functionality and elements related to a specific page or component.

2. **Reusability:** Page objects can be reused across different tests, reducing redundancy and making it easier to manage changes to the application's UI.

3. **Readability:** POM enhances code readability by providing a clear and structured representation of the application's pages. Test scripts become more concise and easier to understand.

4. **Maintenance:** Changes to the UI are localized within the corresponding page objects, minimizing the impact on the overall test suite. This improves maintenance efficiency and reduces the likelihood of errors.
### Directory Structure

- **`pages/`:** Contains page object classes representing different pages or components of the application.

- **`stepdefinitions/`:** Holds Cucumber step definition classes that interact with page objects to define test behavior.

- **`utils/`:** Includes utility classes such as `WebDriverFactory`, etc., providing reusable functions and configurations.

## How to Navigate

```plaintext
project-root/
  ├── src/
  │   ├── main/
  │   │   └── java/
  │   │           ├── Config/        
  │   │           │   └── UiTestConstants.java
  │   │           ├── Pages/
  │   │           │   ├── HomePage.java
  │   │           │   └── LoginPage.java
  │   │           │
  │   │           ├── StepDefinitions/
  │   │           │   ├── HomeSteps.java
  │   │           │   ├── LoginSteps.java
  │   │           │   └── NavigationSteps.java
  │   │           │
  │   │           └── Utils/
  │   │               ├── DriverLibrary.java
  │   │               └── WebDriverFactory.java
  │   │
  │   └── test/
  │        ├── java/
  │            │   └── TestRunners/
  │            │        └── UITestRunner.java
  │            │
  │            └── resources/
  │                 └── Features/
  │                     └── ui/
  │                          └── Login.feature
  │   
  └── pom.xml
```
## Prerequisites

- Java 21 or later installed
- Maven 3.9.5 installed

## Dependencies

-  Cucumber
-  Selenium
-  JUnit
-  WebdriverManager 

## How to Run Tests

To run all tests, use the following command:
```bash
mvn test

```
Or to run the UI test specifically, you may use the following command:
```bash
mvn test -Dtest=UITestRunner

```
