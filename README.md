# Demo Test Automation Project

A **Selenium-based test automation framework** for [SauceDemo](https://www.saucedemo.com/), built using **Java, TestNG, and WebDriver**. It follows the **Page Object Model (POM)** and includes utility classes for handling waits, actions, and browser interactions.

## 📌 Features
- **Login Test**: Automates the login process with valid credentials.
- **Page Object Model (POM)**: Keeps the test structure clean and maintainable.
- **Explicit Waits**: Ensures stable and reliable element interactions.
- **Utility Classes**: Includes reusable methods for element actions, scrolling, and browser navigation.

## 🛠️ Tech Stack
- **Java**
- **Selenium WebDriver**
- **TestNG**
- **Maven**

## 🚀 Getting Started
### 1️⃣ Clone the repository:
```sh
git clone https://github.com/your-username/demo-test-automation-project.git
```

2️⃣ Install dependencies:
Make sure you have Java and Maven installed, then run:
```sh
mvn clean install
```

3️⃣ Run the tests:
```sh
mvn test
```

## 📂 Project Structure
```
📦 src
 ┣ 📂 main
 ┃ ┗ 📂 java
 ┃ ┃ ┣ 📂 com.swaglabs.pages      # Page Object Model (POM)
 ┃ ┃ ┗ 📂 com.swaglabs.utils      # Utility classes (Waits, Actions, etc.)
 ┣ 📂 test
 ┃ ┗ 📂 java
 ┃ ┃ ┗ 📂 com.swaglabs.tests      # Test cases (LoginTest)
```
 
## 📝 License
This project is for learning purposes and is not affiliated with SauceDemo.





