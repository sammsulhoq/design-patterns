## Applicability
- Use the Mediator pattern when it’s hard to change some of the classes because they are tightly coupled to a bunch of other classes.
- Use the pattern when you can’t reuse a component in a different program because it’s too dependent on other components.
- Use the Mediator when you find yourself creating tons of component subclasses just to reuse some basic behavior in various contexts.

## How To Implement
1. Identify a group of tightly coupled classes which would benefit from being more independent (e.g., for easier maintenance or simpler reuse of these classes).

2. Declare the behavioral.mediator interface and describe the desired communication protocol between mediators and various components. In most cases, a single method for receiving notifications from components is sufficient.

3. This interface is crucial when you want to reuse component classes in different contexts. As long as the component works with its behavioral.mediator via the generic interface, you can link the component with a different implementation of the behavioral.mediator.

4. Implement the concrete behavioral.mediator class. Consider storing references to all components inside the behavioral.mediator. This way, you could call any component from the behavioral.mediator’s methods.

5. You can go even further and make the behavioral.mediator responsible for the creation and destruction of component objects. After this, the behavioral.mediator may resemble a factory or a facade.

6. Components should store a reference to the behavioral.mediator object. The connection is usually established in the component’s constructor, where a behavioral.mediator object is passed as an argument.

7. Change the components’ code so that they call the behavioral.mediator’s notification method instead of methods on other components. Extract the code that involves calling other components into the behavioral.mediator class. Execute this code whenever the behavioral.mediator receives notifications from that component.