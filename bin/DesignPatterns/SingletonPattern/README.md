# 🔒 Singleton Pattern

![Pattern](https://img.shields.io/badge/pattern-Singleton-blue)
![Type](https://img.shields.io/badge/type-Creational-green)
![Origin](https://img.shields.io/badge/origin-Gang%20of%20Four-lightgrey)
![Language](https://img.shields.io/badge/language-Java-orange)

> A creational design pattern that guarantees a class has **exactly one instance** and provides a single global point of access to it.

---

## 📖 Table of Contents

- [What It Is](#-what-it-is)
- [The Problem](#-the-problem)
- [The Solution](#-the-solution)
- [How It Works](#-how-it-works)
- [Example](#-example)
- [Eager vs. Lazy Initialization](#-eager-vs-lazy-initialization)
- [Why Use It](#-why-use-it)
- [When to Use It](#-when-to-use-it)
- [When *Not* to Use It](#-when-not-to-use-it)
- [Caveats](#-caveats)

---

## 🎯 What It Is

The **Singleton** ensures that a class is instantiated **only once**, and that every part of the program shares that same instance. Instead of creating objects with `new`, callers ask the class itself for its one instance.

**Type:** Creational (Gang of Four)

---

## 😩 The Problem

Some things should exist **exactly once** in an application — a cache, a configuration registry, a connection pool, a logger. If different parts of the code each do `new Cache()`, you get problems:

```java
PriceCache cacheA = new PriceCache();
PriceCache cacheB = new PriceCache();

cacheA.getPrice("apple");   // >> expensive DB lookup for apple
cacheB.getPrice("apple");   // >> expensive DB lookup for apple   ← AGAIN!
```

- ❌ **Wasted work** — expensive setup runs again for every new instance.
- ❌ **Split state** — `cacheA` and `cacheB` each have their own data and never see each other's.
- ❌ The whole point of a *shared* resource is broken.

---

## ✅ The Solution

Force the program to share **one** instance. The second lookup below prints nothing — it's served from the shared memory:

```java
PriceCache cacheA = PriceCache.getInstance();
PriceCache cacheB = PriceCache.getInstance();

cacheA.getPrice("apple");   // >> expensive DB lookup for apple
cacheB.getPrice("apple");   // (nothing printed — served from memory)
```

`cacheA` and `cacheB` are now **the same object**.

---

## ⚙️ How It Works

Three structural moves make a class a Singleton:

| Move | Purpose |
|------|---------|
| 🔐 **Private constructor** | Blocks `new` from outside — nobody can create extra instances |
| 📦 **Private static instance field** | The class stores its single instance itself |
| 🚪 **Public static `getInstance()`** | The one controlled way to obtain the instance |

```
Client ──getInstance()──► Singleton ──returns──► the one shared instance
                              ▲
                              └── private constructor blocks "new"
```

---

## 💻 Example

```java
public class PriceCache {

    // 📦 the single instance, held by the class itself
    private static PriceCache instance = new PriceCache();

    private Map<String, Double> cache = new HashMap<>();

    // 🔐 private constructor — nobody outside can call "new PriceCache()"
    private PriceCache() { }

    // 🚪 the only way to obtain the instance
    public static PriceCache getInstance() {
        return instance;
    }

    public double getPrice(String product) {
        if (!cache.containsKey(product)) {
            System.out.println("  >> expensive DB lookup for " + product);
            cache.put(product, loadFromDatabase(product));
        }
        return cache.get(product);
    }

    private double loadFromDatabase(String product) {
        return 9.99;   // pretend this is a slow database call
    }
}
```

Usage:

```java
double price = PriceCache.getInstance().getPrice("apple");
```

No matter how many times or where you call `getInstance()`, you get **the exact same object back**.

---

## ⏱️ Eager vs. Lazy Initialization

There are two ways to create the single instance:

| Style | When the instance is created | Code shape | Thread-safe? |
|-------|------------------------------|------------|--------------|
| **Eager** | When the class first loads | `instance = new Cache();` at the field | ✅ Yes, automatically |
| **Lazy** | On the first `getInstance()` call | `if (instance == null) instance = new Cache();` | ⚠️ No — needs synchronization |

```java
// Eager — simple and thread-safe
private static PriceCache instance = new PriceCache();

// Lazy — created only when first needed
private static PriceCache instance;
public static PriceCache getInstance() {
    if (instance == null) {
        instance = new PriceCache();
    }
    return instance;
}
```

> 💡 **Eager** is simpler and automatically thread-safe. **Lazy** delays the work until it's actually needed, but must be synchronized to be safe in multithreaded code.

---

## 🚀 Why Use It

| Benefit | What it means |
|---------|---------------|
| 🎯 **One instance guaranteed** | Impossible to accidentally create duplicates |
| 🔗 **Shared state** | Everyone reads/writes the same object |
| 💰 **Saves resources** | Expensive setup happens once |
| 🌍 **Global access** | One well-known entry point for the whole app |

---

## 📌 When to Use It

- ✅ There must be **exactly one** of something (cache, config, connection pool, logger).
- ✅ That single thing needs to be **shared** across the whole program.
- ✅ Creating it is **expensive** and should happen only once.

---

## 🛑 When *Not* to Use It

- ❌ You're using it just for **convenient global access** — that's a global variable in disguise.
- ❌ The object holds **state that varies per user/request** — a shared instance would leak data between them.
- ❌ It makes **testing harder** without a real benefit (see caveats).

---

## ⚠️ Caveats

The Singleton is the *easiest* pattern to understand but the *most misused*:

- **Global state** — it provides global access to a shared object, which can hide dependencies and make code harder to reason about.
- **Testing** — a hard-coded singleton is difficult to replace with a fake/mock in tests.
- **Thread safety** — the naive lazy version is **not thread-safe**; two threads can create two instances on the first simultaneous call. Fixes: eager init, synchronization, or an `enum`-based Singleton.

> 💡 **In practice, frameworks manage singletons for you.** Spring beans are singletons *by default* — Spring keeps one instance and injects that same one everywhere, giving you the benefit while avoiding most of the downsides. You rarely need to hand-write `getInstance()`.

---

## 📚 Related Patterns

- **Factory Method** — the other side of controlling creation: decides *which* class to build.
- **Abstract Factory** — factories are often implemented as singletons.
- **Monostate** — an alternative where all instances share the same state.

---

<div align="center">

*Part of my design patterns learning series* ✨

</div>
