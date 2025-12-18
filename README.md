# Banking System – Technical Test

## 📌 Overview

This project is a simple **banking system** implemented in **Java** as part of a technical test.  
It provides the core functionalities of a banking account:

- Deposit money
- Withdraw money
- Print a bank statement with transaction history

The implementation follows clean code principles, handles invalid inputs, and includes unit tests.

---

## 🧱 Features

- Deposit funds into an account
- Withdraw funds with balance validation
- Transaction history tracking (date, amount, balance)
- Bank statement printing
- Input validation and exception handling
- Unit tests with JUnit

---

## 🛠️ Technologies Used

- **Java**
- **Maven**
- **JUnit** (for testing)
- **Git / GitHub**

---

## ✅ Business Rules

- Deposits must be greater than 0
- Withdrawals must be greater than 0
- Withdrawals cannot exceed the current balance
- Transactions are stored in memory using lists (no database)
- Amounts are represented using `int` for simplicity

---

# How to Run

```bash
mvn compile
java -cp target/classes banking.Main
```

---

## 🧪 Running Tests

Make sure Maven is installed, then run:

```bash
mvn test
```

Expected result:

```
BUILD SUCCESS
```
