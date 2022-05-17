# Multithreading and Concurrency Prototypes

### Task1 - Usage of ConcurrentHashMap 
This task reproduces ConcurrentModificationException when using of HashMap.

### Task2 - Calculation of Numbers
* 1st thread is infinitely writing random number to the collection;
* 2nd thread is printing sum of the numbers in the collection;
* 3rd is printing square root of sum of squares of all numbers in the collection.
Make these calculations thread-safe using synchronization block. Fix the possible deadlock.

### Task3 - Concurrent Queue
* Implement asynchronous message bus. Do not use queue implementations from java.util.concurrent.
* Implement producer, which will generate and post randomly messages to the queue.
* Implement consumer, which will consume messages on specific topic and log to the console message payload.
* (Optional) Application should create several consumers and producers that run in parallel.

### Task4 - Simple Object Pool
Create simple object pool with support for multithreaded environment. No any extra inheritance, polymorphism or generics needed here, just implementation of simple class

### Task5 - Exchange Operations Between Different Currencies
* Create models for dealing with currencies, user accounts and exchange rates. One account can have multiple currency values. Use BigDecimal for performing of exchange calculations.
* Data with user accounts should be stored as files (one file per account).
* Separate application functionality to DAO, service and utilities.
* Create module which will provide high-level operations (manage accounts, currencies, exchange rates).
* Create sample accounts and currencies. Define sample exchange rates.
* Provide concurrent data access to user accounts. Simulate simultaneous currency exchanges for single account by multiple threads and ensure that all the operations are thread-safe.
* Use ExecutorService to manage threads.
* Make custom exceptions to let user to know the reason of error. Do not handle runtime exceptions.
* Validate inputs such an account existence, sufficiency of currency amount, etc.
* Log information about what is happening on different application levels and about conversion results. Use Logger for that.

