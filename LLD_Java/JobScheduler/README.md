Content has been taken from: https://www.youtube.com/watch?v=l6uKzV7yZzM.
Creating my own notes based on that for learning purpose.

# Design a Job Scheduler
### Requirements:
1) User should be able to schedule adhoc events with initial delay.
2) User should be able to schedule a recurring event with fixed rate.
3) User should be able to schedule a recurring event with some delay rate.

### Non functional requirement
1. Async
2. Concurrent
3. Multithreading
4. 

### Proposed Solution

### Entities
- Demo - All the test cases and scenarios will be there in this file.
- SchedulerService - Will contains all API to trigger
- ScheduledJobPool - Actual business logic will be there
- Job or Task - What I want to actually run?
- TaskType - {OneTime, FixedRate, FixedDelay}
- Queue - PriorityQueue - push the Job and then poll the top one to be executed

- __LLD\-Java__
   - __JobScheduler__ 
     - __src__
       - __driver__
         - [SchedulerDemo.java](JobScheduler/src/driver/SchedulerDemo.java)
       - __main__
         - __entity__
           - [Job.java](JobScheduler/src/main/entity/Job.java)
           - [SchduledTask.java](JobScheduler/src/main/entity/SchduledTask.java)
         - __enums__
           - [TaskType.java](JobScheduler/src/main/enums/TaskType.java)
         - __helper__
           - [JobExecutor.java](JobScheduler/src/main/helper/JobExecutor.java)
         - __service__
           - [ISchedulerService.java](JobScheduler/src/main/service/ISchedulerService.java)
           - [SchedulerService.java](JobScheduler/src/main/service/SchedulerService.java)
   - [README.md](README.md)

### Design Pattern:
1) Singleton - SchedulerService 
(only one instance to run the whole scheduler application)

### Data Structure and Algorithm?
1) PriorityQueue - job ordering based on time
2) Deadlock

<!--### Concurrency:-->
<!--1) ExecutorService-->
<!--2) Threadpool-->

### Multithreading:
1) Executors
2) Concurrency
3) Synchronization
4) Locks
5) Conditions

### Future:

### Refererences:
https://leetcode.com/discuss/interview-question/system-design/344524/Amazon-or-Design-a-JobTask-Scheduler
https://leetcode.com/discuss/general-discussion/1082786/System-Design%3A-Designing-a-distributed-Job-Scheduler-or-Many-interesting-concepts-to-learn
https://www.geeksforgeeks.org/difference-between-job-task-and-process/

### Questions:
1) Why PQ - Heap Data structure
    1) Do we really need heap DS? Min Heap?
       1) Query pattern - min or certain attribute
       2) Update pattern - put any attribute value
     2) Options
        1) SortedList/SortedVector
            1) Query Complexity? O(1)
            2) Update Complexity? O(N) - worst case
        2) MinHeap
            1) Query complexity? O(1), remove -> O(logN) as have to again heapify
            2) Update complexity? O(logN)
        3) Array FindMin
            1) Query - O(N)
            2) Update - O(1)
