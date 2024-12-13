# Task Management System

This project implements a Task Management System for organizing and managing tasks associated with various projects. It allows tasks to be categorized by project, priority, status, and assignee, with capabilities for sorting and displaying the tasks.

## Features

- **Task Representation:** Each task is represented as an instance of the `Task` class, which includes attributes like project name, description, assignee, priority, and status.
- **Sorting:** Tasks can be sorted by priority, status, or a combination of attributes using custom comparators.
- **Filtering by Assignee:** Tasks are grouped and displayed based on specific assignees or can be displayed collectively.
- **Data Representation:** Task data is hard-coded for simplicity and demonstrates functionality effectively.
- **Formatted Output:** Tasks are printed in a structured, human-readable format for easy understanding.

## Classes and Components

### `Task`
Represents a single task with the following attributes:
- **`projectName`**: The name of the project associated with the task.
- **`description`**: A brief description of the task.
- **`assignee`**: The person responsible for the task.
- **`priority`**: Priority of the task (High, Medium, Low).
- **`status`**: Current status of the task (Assigned, In Progress, Not Assigned).

Implements:
- `Comparable<Task>`: Allows natural sorting by `projectName` and `description`.
- Custom `toString`: Formats task data for display.
- `equals` and `hashCode`: Ensures proper behavior in collections like `Set`.

### `TaskData`
Provides a predefined set of tasks for demonstration purposes. Key functionalities include:
- Retrieving tasks based on the assignee.
- Parsing and converting raw string data into `Task` objects.

### `Test`
Main class that demonstrates the functionality of the system:
- Retrieves tasks for specific assignees (`Ann`, `Bob`, `Carol`, or all tasks).
- Sorts and displays tasks using various criteria:
  - Natural order (`projectName` and `description`).
  - Priority (high to low).
  - Status.
  - Combined sorting (priority, then status).

## How to Run

1. Compile all `.java` files:
   ```
   javac Task.java TaskData.java Test.java
   ```
2. Run the main program:
   ```
   java Test
   ```
3. Observe the sorted and filtered task lists in the console output.

## Example Output

### All Tasks:
```
------------------------------------------------------------------------------------------
                                All tasks:
------------------------------------------------------------------------------------------
Infrastructure       Logging                   HIGH       null      NOT_ASSIGNED
Infrastructure       DB Access                MEDIUM     null      NOT_ASSIGNED
Infrastructure       Security                 HIGH       null      NOT_ASSIGNED
...
```

### Ann Tasks Sorted by Priority:
```
------------------------------------------------------------------------------------------
                                Ann tasks:
------------------------------------------------------------------------------------------
Infrastructure       Security                 HIGH       Ann       IN_PROGRESS
Data Design          Encryption Policy        HIGH       Ann       NOT_ASSIGNED
...
```
