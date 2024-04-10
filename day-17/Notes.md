1. Coroutines to functions 
    --> all coroutines are converted to regular java functions
    --> all suspending function are also converted into regular java function
        --> will have a new/additional parameter called `continuation`
2. State machines
    --> for each suspend point (call to another suspending function, such as network calls, file/IO read/write), the current state has to saved, so that when the coroutine resumes, the state of the coroutine can be resumed. The state is maintained by the `state machines` along with continuation info
3. Dispatcher
    --> what a `scheduler` means in a multi-threaded environment
    --> determinies the execution context (such as thread pools)
4. Coroutine lifecycle
    --> managed by coroutine runtime library


Some key elements of a CoroutineContext:

1. Job 
    - represents an actual `job`, has access to lifecycle, can control the execution and cancellation of the task
2. Dispatcher 
    - decides the thread/thread-pool on which the actual task runs.
    - controls the execution context
3. Coroutine name
    - used for debugging 
4. Additionally:
    - parent job
    - execption handler

CoroutineScope:

    - defines a `scope` within which a coroutine can be launched and controlled
    - provides functions (such as `launch` or `async`) to create coroutines
    