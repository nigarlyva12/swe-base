# 🏭 Factory Method Pattern

![Pattern](https://img.shields.io/badge/pattern-Factory%20Method-blue)
![Type](https://img.shields.io/badge/type-Creational-green)
![Origin](https://img.shields.io/badge/origin-Gang%20of%20Four-lightgrey)
![Language](https://img.shields.io/badge/language-Java-orange)

> A creational design pattern that centralizes object creation — the client asks for an object by its **interface** and receives one, without knowing which concrete class was built.

---

## 📖 Table of Contents

- [What It Is](#-what-it-is)
- [The Problem](#-the-problem)
- [The Solution](#-the-solution)
- [How It Works](#-how-it-works)
- [Example](#-example)
- [Why Use It](#-why-use-it)
- [When to Use It](#-when-to-use-it)
- [When *Not* to Use It](#-when-not-to-use-it)
- [The Convince-Yourself Test](#-the-convince-yourself-test)

---

## 🎯 What It Is

The **Factory Method** defines a single, dedicated place for creating objects instead of scattering `new ConcreteClass()` calls across the codebase. Callers depend only on a shared interface — the factory decides which concrete implementation to hand back at runtime.

**Type:** Creational (Gang of Four)

---

## 😩 The Problem

Without a factory, the decision *"which class do I build?"* gets copy-pasted into every caller:

```java
// In CheckoutService
if (type.equals("email"))     new EmailNotification().send();
else if (type.equals("sms"))  new SMSNotification().send();
else if (type.equals("push")) new PushNotification().send();

// In ReminderService — the SAME block, copy-pasted
// In AdminPanel        — copy-pasted AGAIN
```

- ❌ Adding a new type means editing **every** caller.
- ❌ Callers are **tightly coupled** to concrete classes.
- ❌ The selection logic is **duplicated** everywhere.
- ❌ Callers become **hard to test**.

---

## ✅ The Solution

Move all creation into **one** class. Callers just ask for what they need:

```java
// Every caller, everywhere — one line, identical
NotificationFactory.create(type).send();
```

---

## ⚙️ How It Works

Four roles collaborate:

| Role | Job |
|------|-----|
| **Product** *(interface)* | The common type all created objects share |
| **Concrete Products** | The real implementations that do the work |
| **Factory** *(Creator)* | Owns the "which class to build" decision |
| **Client** | Asks the factory, uses the product via its interface |

```
Client ──asks──► Factory ──creates──► Concrete Product
                                          │ implements
                                          ▼
                                       Product (interface)
```

---

## 💻 Example

### 1. Product interface

```java
public interface Notification {
    void send();
}
```

### 2. Concrete Products

```java
public class EmailNotification implements Notification {
    public void send() { System.out.println("Sending an EMAIL notification."); }
}

public class SMSNotification implements Notification {
    public void send() { System.out.println("Sending an SMS notification."); }
}

public class PushNotification implements Notification {
    public void send() { System.out.println("Sending a PUSH notification."); }
}
```

### 3. The Factory

```java
public class NotificationFactory {

    public static Notification create(String type) {
        switch (type) {
            case "email": return new EmailNotification();
            case "sms":   return new SMSNotification();
            case "push":  return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}
```

### 4. The Client

```java
public class Main {
    public static void main(String[] args) {
        Notification n = NotificationFactory.create("email");
        n.send();   // Sending an EMAIL notification.
    }
}
```

The client only ever names `Notification` — it has **no idea the concrete classes exist**.

---

## 🚀 Why Use It

| Benefit | What it means |
|---------|---------------|
| 🎯 **Centralization** | All object creation lives in one place, not scattered |
| 🔌 **Decoupling** | Callers depend on the interface, never on concrete classes |
| 📖 **Open/Closed Principle** | Add a new type without editing existing callers |
| 🧪 **Testability** | Creation can be swapped for fakes/mocks in tests |
| 🚫 **No duplication** | The selection logic exists once, as a single source of truth |

---

## 📌 When to Use It

- ✅ You have a **family of related classes** sharing a common interface.
- ✅ The choice of *which one* depends on **runtime input** (config, user choice, file type).
- ✅ You see the same `if/else` / `switch` with `new` **copy-pasted** across callers.
- ✅ You expect to **add new variants** later without touching every caller.

---

## 🛑 When *Not* to Use It

- ❌ There's only **one** implementation — the indirection buys you nothing.
- ❌ Object creation is **trivial** and never varies.
- ❌ You'd be adding a factory "just in case" — that's over-engineering.

---

## 🧠 The Convince-Yourself Test

> **"When I add a new product type, how many files must I change?"**

| | Files to change |
|---|---|
| **With** Factory Method | **1** — just the factory |
| **Without** Factory Method | **Every** caller |

That single question is the whole justification for the pattern.

---

## 📚 Related Patterns

- **Simple Factory** — one class with a `switch` (shown above); the gentle entry point.
- **Factory Method (GoF)** — subclasses override a creation method instead of a `switch`.
- **Abstract Factory** — creates whole *families* of related products.

---

<div align="center">

*Part of my design patterns learning series* ✨

</div>
