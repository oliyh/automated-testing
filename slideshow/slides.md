# Automated Testing

## What do we want to achieve as professional software developers?

* Consistently deliver working software
* Flexibility to respond quickly to change
* Pride in our code

> Consistently deliver working software
> Know that every release will improve the customer’s experience

> Flexibility to respond quickly to change
> If the customer changes their mind we should be able to impress them with how quickly we can deliver what they want. From the Agile manifesto “we should embrace change” and not fear it

> Pride in our code
> The difference between a profession and a job is that a profession requires you to live it, breathe it, and constantly strive to improve your abilities and the wider environment in which you work. Our code is our craft and the ultimate expression of our abilities as a developer.

***

## "Traditional" approaches to achieving these goals

* Manual testing
* Code reviews
* Documentation

> All very time-intensive work and prone to human error

***

## Can a traditional approach work?

* Some live coding coming up!
* Requirement: Parse structured addresses from CSV strings

```
"One, Cabot Square, London, E14 4QJ" -> {Number: One, Road: Cabot Square, City: London, Postcode: E14 4QJ}
```

> Switch to IDE, do examples 1-4 of AddressParser
> After each change, use UI mockup to test and exaggerate the slow feedback cycle

***

## Can a traditional approach work?

* How long did it take to test all the permutations?
* Did you remember to update the documentation?
* Did your code reviewer or QA spot the bug?

> 1. You should repeat all these tests before every release. How long does it take? Is your release process limited by this? Do you decide not to test some parts that you don’t think have changed so that you can release faster?
> 1a. You should repeat all these tests when any external dependency releases! How often does that happen?
> 2. We forgot to update the documentation. Now it is incomplete and misleading.
> 3. There was a bug!

> This approach does not scale beyond the most trivial of projects.

***

## Working software

* How do we know software works?
    * Look at the code?
    * Run some static analysis tool?
    * Run the code!

> We’ve already seen that looking at the code is no guarantee it will work when you run it – there is a bug in the code we wrote.
> Can run inspections on the java code – Intellij comes back with nothing
> The best way of knowing is to run the code and know for sure, but we can save our QA from the tedium.

***

## Example of a unit test

* Going back to our live coding example from earlier…

> Write unit tests, cover the edge and corner cases, exception case, and fix the formatting issue that we didn’t notice

***

## Black box testing

* We should not know or care about how the production code is implemented
* We should only care about its behaviour
* This means our test documents the behaviour and not the implementation
* It means we can change the implementation and use the test to prove that the behaviour remains the same

> Documentation comes for free with unit tests

***

## All of my unit tests pass, why doesn’t the app work?

* Composition and configuration of code is just as important as the code itself when it comes to a working application
* You may be using libraries or calling other systems
* How can we make sure the application or even the system works?

> There is more to an application than just an amorphous collection of code

***

## Types of test

* Unit tests
* Module tests
* Acceptance tests

* External tests
* Smoke tests

[img of types of test]

> This is a massively simplified representation of the Giraffe application and one of the other applications in the system, Gibn, which supplies market data to Giraffe. The green dots are individual classes; the arrows represent data flow.

> We already know about unit tests. They tell us that the green dots work.
> Module tests tell us that groups of classes that work together work to give higher order functionality.
> Acceptance tests tell us that the application itself can perform the tasks required to satisfy the client.
> External tests ensure that we can interact with our external dependencies.
> Smoke tests attempt to ensure that the application will work when deployed within a real system.

***