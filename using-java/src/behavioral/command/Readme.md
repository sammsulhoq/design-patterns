## Applicability
- Use the Command pattern when you want to parametrize objects with operations.
- Use the Command pattern when you want to queue operations, schedule their execution, or execute them remotely.
- Use the Command pattern when you want to implement reversible operations.

## How To Implement
1. Declare the behavioral.command interface with a single execution method.

2. Start extracting requests into concrete behavioral.command classes that implement the behavioral.command interface. Each class must have a set of fields for storing the request arguments along with a reference to the actual receiver object. All these values must be initialized via the behavioral.command’s constructor.

3. Identify classes that will act as senders. Add the fields for storing commands into these classes. Senders should communicate with their commands only via the behavioral.command interface. Senders usually don’t create behavioral.command objects on their own, but rather get them from the client code.

4. Change the senders so they execute the behavioral.command instead of sending a request to the receiver directly.

5. The client should initialize objects in the following order:
   * Create receivers. 
   * Create commands, and associate them with receivers if needed. 
   * Create senders, and associate them with specific commands.