# Element Master Framework

A Selenium + TestNG automation framework built using the **Page Object Model (POM)** design pattern, targeting the [DemoQA](https://demoqa.com) web application.

---

## Table of Contents

- [Overview](#overview)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Architecture](#architecture)
- [Test Coverage](#test-coverage)
- [Setup & Installation](#setup--installation)
- [Running Tests](#running-tests)
- [Configuration](#configuration)
- [Reporting](#reporting)
- [Design Principles](#design-principles)
- [Known Limitations](#known-limitations)
- [Future Enhancements](#future-enhancements)

---

## Overview

Element Master Framework is a scalable and maintainable UI test automation framework built to demonstrate automation of key DemoQA components. It covers forms, web tables, alerts, frames, widgets, and more — with built-in reporting and screenshot capture on failure.

---

## Tech Stack

| Tool / Library       | Version   | Purpose                          |
|----------------------|-----------|----------------------------------|
| Java                 | 8+        | Programming language             |
| Selenium Java        | 4.21.0    | Browser automation               |
| TestNG               | 7.10.2    | Test execution & assertions      |
| WebDriverManager     | 5.8.0     | Automatic driver management      |
| ExtentReports        | 5.1.1     | HTML test reporting              |
| Apache Commons IO    | 2.15.1    | File utilities (screenshots)     |
| Maven                | —         | Build & dependency management    |

---

## Project Structure

```
element-master-framework/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── base/
│   │   │   │   └── BasePage.java          # Common UI actions (click, type, jsClick, wait)
│   │   │   ├── config/
│   │   │   │   └── ConfigReader.java      # Reads config.properties
│   │   │   ├── pages/
│   │   │   │   ├── AlertsPage.java        # Alert interactions
│   │   │   │   ├── ElementsPage.java      # Checkbox interactions
│   │   │   │   ├── FormPage.java          # Practice Form interactions
│   │   │   │   ├── FramesPage.java        # iFrame interactions
│   │   │   │   ├── WebTablePage.java      # CRUD on web tables
│   │   │   │   ├── WidgetsPage.java       # Widget interactions
│   │   │   │   └── WindowsPage.java       # Multi-window handling
│   │   │   └── utils/
│   │   │       ├── ExtentManager.java     # Extent report setup
│   │   │       └── ScreenshotUtil.java    # Screenshot capture utility
│   │   └── resources/
│   │       └── config.properties          # Browser, URL, timeout config
│   └── test/
│       ├── java/
│       │   ├── base/
│       │   │   └── BaseTest.java          # Driver setup & teardown
│       │   ├── listeners/
│       │   │   └── TestListener.java      # TestNG listener for reporting
│       │   └── tests/
│       │       ├── AlertsTest.java
│       │       ├── ElementsTest.java
│       │       ├── FormTest.java
│       │       ├── FramesTest.java
│       │       ├── WebTableTest.java
│       │       ├── WidgetsTest.java
│       │       └── WindowsTest.java
│       └── resources/
├── reports/
│   └── ExtentReport.html                  # Generated Extent HTML report
├── screenshots/                           # Screenshots captured on test runs
├── test-output/                           # TestNG default output
├── testng.xml                             # TestNG suite configuration
├── pom.xml                                # Maven build file
└── Design_doc                             # Architecture & design notes
```

---

## Architecture

The framework follows a layered **Page Object Model (POM)** structure:

```
┌─────────────────────────────────┐
│          Test Layer             │  ← Test classes (TestNG @Test methods)
├─────────────────────────────────┤
│          Page Layer             │  ← Page classes with locators & actions
├─────────────────────────────────┤
│          Base Layer             │  ← BaseTest (driver) + BasePage (common actions)
├─────────────────────────────────┤
│         Utility Layer           │  ← Screenshots, Extent Reports, Config
└─────────────────────────────────┘
```

### Key Classes

**`BaseTest`** — Handles browser initialization and teardown via TestNG `@BeforeMethod` / `@AfterMethod`. Supports both Chrome and Firefox based on `config.properties`.

**`BasePage`** — Provides reusable WebDriver helpers: `click()`, `type()`, `waitForElement()`, and `jsClick()` (JavaScript executor for bypassing ad overlays).

**`ConfigReader`** — Loads `browser`, `baseUrl`, and `timeout` from `config.properties`.

**`ScreenshotUtil`** — Captures screenshots on failure, saved to the `screenshots/` directory with a timestamp.

**`ExtentManager`** — Manages a singleton `ExtentReports` instance that writes to `reports/ExtentReport.html`.

---

## Test Coverage

| Test Class       | Test Methods                                                     |
|------------------|------------------------------------------------------------------|
| `FormTest`       | Form submission, radio button selection, empty form validation   |
| `ElementsTest`   | Checkbox selection                                               |
| `WebTableTest`   | Add record, search record, delete record                         |
| `AlertsTest`     | Simple alert, confirm alert (cancel), prompt alert with input    |
| `FramesTest`     | iFrame interaction                                               |
| `WidgetsTest`    | Widget interaction                                               |
| `WindowsTest`    | Multi-window handling                                            |

---

## Setup & Installation

### Prerequisites

- Java JDK 8 or higher
- Maven 3.6+
- Google Chrome or Firefox browser
- Internet connection (WebDriverManager downloads drivers automatically)

### Steps

1. **Clone or extract the project**
   ```bash
   unzip element-master-framework.zip
   cd element-master-framework
   ```

2. **Install dependencies**
   ```bash
   mvn clean install -DskipTests
   ```

---

## Running Tests

### Run all tests via Maven
```bash
mvn test
```

### Run using the TestNG XML suite
```bash
mvn test -DsuiteXmlFile=testng.xml
```

### Run a specific test class
```bash
mvn test -Dtest=FormTest
```

The default suite (`testng.xml`) runs: `FormTest`, `ElementsTest`, `WebTableTest`, `FramesTest`, and `WidgetsTest`.

---

## Configuration

Edit `src/main/resources/config.properties` to change run settings:

```properties
browser=chrome       # Options: chrome | firefox
baseUrl=https://demoqa.com
timeout=10           # Explicit wait timeout in seconds
```

---

## Reporting

Two types of reports are generated after a test run:

### Extent Report
- **Location:** `reports/ExtentReport.html`
- Rich HTML report with test status, logs, and timestamps.
- Open in any browser after the run.

### TestNG Default Report
- **Location:** `test-output/index.html`
- Standard TestNG suite report with pass/fail/skip breakdown.

### Screenshots
- Captured on test execution and saved to `screenshots/`
- Filename format: `testMethodName_yyyyMMddHHmmss.png`

---

## Design Principles

- **Separation of Concerns** — Test logic, page actions, and utilities are fully decoupled.
- **Reusability** — Common actions in `BasePage` are shared across all page classes.
- **Maintainability** — Locators and actions are centralized per page; only one place to update on UI changes.
- **Readability** — Test methods clearly express intent without WebDriver boilerplate.

---

## Known Limitations

- **DemoQA ads** — The site displays dynamic advertisements that can overlap elements. Workarounds using `jsClick()` (JavaScript executor) are applied where standard clicks fail.
- **Some components** required custom handling due to non-standard DOM structure on DemoQA.

---

## Future Enhancements

- [ ] **Data-driven testing** — Parameterize test inputs using Excel / JSON / CSV data providers.
- [ ] **CI/CD integration** — Add GitHub Actions or Jenkins pipeline for automated test runs on push.
- [ ] **Cross-browser execution** — Extend support for Edge and Safari browsers.
- [ ] **Parallel execution** — Configure TestNG for parallel test runs to reduce execution time.
- [ ] **Soft assertions** — Replace force-pass assertions with meaningful validations throughout.
