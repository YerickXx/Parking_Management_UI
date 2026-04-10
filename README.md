# 🚗 Parking Management System (GUI Version)

### 📋 Overview
This is a professional-grade desktop application developed in **Java**. Unlike standard console applications, this version implements a full **Graphical User Interface (GUI)** using Swing and follows strict software engineering principles to ensure scalability and maintainability.

---

### 🏛️ Architecture & Design Patterns
The project is built using a **Layered Architecture** and **Interface-Based Design** to achieve high decoupling:

* **GUI (Presentation Layer):** Built with Java Swing. It interacts only with the Logic interfaces, keeping the UI separate from the business rules.
* **Logic (Business Layer):** Defined through **Java Interfaces**. This layer handles fee calculations, time tracking, and validation logic.
* **Data (Persistence Layer):** Manages data storage using File I/O. By using interfaces here, the system remains "database-agnostic" (it can switch from files to SQL easily).

**Key Principles Applied:**
* **Decoupling:** Layers communicate through abstractions (interfaces).
* **Single Responsibility:** Each class has one focused purpose within its layer.
* **Interface Segregation:** Ensuring clean contracts between the UI and the Backend.

---

### 🛠️ Tech Stack
* **Language:** Java 17+
* **Framework:** Java Swing / AWT
* **Version Control:** Git & GitHub (Professional Flow)
* **Tools:** NetBeans IDE

---

### 🔧 Installation
```bash
git clone [https://github.com/YerickXx/Parking_Management_UI.git](https://github.com/YerickXx/Parking_Management_UI.git)
