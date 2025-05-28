## Applicability
- Use the Strategy pattern when you want to use different variants of an algorithm within an object and be able to switch from one algorithm to another during runtime.
- Use the Strategy when you have a lot of similar classes that only differ in the way they execute some behavior.
- Use the pattern to isolate the business logic of a class from the implementation details of algorithms that may not be as important in the context of that logic.
- Use the pattern when your class has a massive conditional statement that switches between different variants of the same algorithm.

## How To Implement
1. In the context class, identify an algorithm that’s prone to frequent changes. It may also be a massive conditional that selects and executes a variant of the same algorithm at runtime.

2. Declare the behavioral.strategy interface common to all variants of the algorithm.

3. One by one, extract all algorithms into their own classes. They should all implement the behavioral.strategy interface.

4. In the context class, add a field for storing a reference to a behavioral.strategy object. Provide a setter for replacing values of that field. The context should work with the behavioral.strategy object only via the behavioral.strategy interface. The context may define an interface which lets the behavioral.strategy access its data.

5. Clients of the context must associate it with a suitable behavioral.strategy that matches the way they expect the context to perform its primary job.