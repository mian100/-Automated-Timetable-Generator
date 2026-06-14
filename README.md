# 📚 Automated Timetable Generator

## 👨‍🎓 Student Project (Data Structures & Algorithms)

This is a console-based Java project that automatically generates a university timetable using multiple Data Structures.

---

## 🚀 Features
- Add Courses, Teachers, and Rooms
- Automatic Timetable Generation
- Conflict Detection System
- Search Course using BST
- Organized Weekly Schedule Display

---

## 🧠 Data Structures Used

- **Linked List** → Store Courses, Teachers, Rooms dynamically  
- **Queue** → Manage scheduling order of courses (FIFO)  
- **Stack** → Handle conflict rollback/backtracking  
- **HashMap** → Detect scheduling conflicts quickly  
- **Binary Search Tree (BST)** → Fast searching of courses  
- **2D Array** → Store final timetable structure  

---

## ⚙️ How It Works

1. User adds courses, teachers, and rooms  
2. Data is stored in linked lists  
3. Courses are placed in a queue  
4. Timetable generator assigns time slots  
5. HashMap checks conflicts  
6. BST allows searching  
7. Final timetable is displayed using 2D array  

---

## 💻 How to Run

```bash
javac src/*.java
java src.Main
