# Multithreading and Concurrency Prototypes

### Task1 - Usage of ConcurrentHashMap 
This task reproduces ConcurrentModificationException when using of HashMap.

### Task2 - Calculation of Numbers
* 1st thread is infinitely writing random number to the collection;
* 2nd thread is printing sum of the numbers in the collection;
* 3rd is printing square root of sum of squares of all numbers in the collection.
Make these calculations thread-safe using synchronization block. Fix the possible deadlock.
