# Adidas - Store QA

The following repository contains a Java project using Selenium WebDriver and JUnit 4, following a Page Object pattern, with the purpose if automating UI validation flows.
The decision on using Selenium WebDriver was given on the assignment itself, whereas in the case of JUnit4 it was mainly based on my professional experience. As regards our testing browser, Google Chrome is currently the most popular browser worldwide, reason why I decided to run the tests via ChromeDriver instead of Firefox, which is Selenium's default browser.

### Prerequisites

The following prerequisites are needed:

```
- Have latest Java SDK installed
- IntelliJ IDEA IDE (or Eclipse)
- ChromeDriver successfully downloaded and added to system path
```

### Installing

1. Clone repository from GitHub
2. Download latest Selenium Standalone Server and Java Client from https://www.seleniumhq.org/download/
3. Import the project on IntelliJ as a Java Project. Point to your Java SDK location.
4. Select File -- Project Structure and add the libraries downloaded in step 2. Apply changes.
5. Open StoreTest.java. If JUnit dependency hasn't been added automatically, tap over an @Test, @Before or @After annotation and select "Add JUnit4 to classpath".

## Running the tests

1. Open ChromeDriver
2. Build and run the StoreTest class. You should be good to go :)
