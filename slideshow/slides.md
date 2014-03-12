# Automated Testing

## (Optional) introduction to the system

> High level introduction of the applications in the system, emphasise the number of teams, applications, developers, servers, some metrics
> 6 teams, 30 people, 10+ applications, 1000+ servers

> e.g. 
> A single production instance in Asia has 1500 distributed queues and over 200k consumers. In 24 hours, it sends 120 million JMS messages and serves 1.8 billion http requests


## What do we want to achieve as professional software developers?

* Consistently deliver working software
* Flexibility to respond quickly to change
* Pride in our code

> Consistently deliver working software
> Know that every release will improve the customer's experience

> Flexibility to respond quickly to change
> If the customer changes their mind we should be able to impress them with how quickly we can deliver what they want. From the Agile manifesto "we should embrace change" and not fear it

> Pride in our code
> The difference between a profession and a job is that a profession requires you to live it, breathe it, and constantly strive to improve your abilities and the wider environment in which you work. Our code is our craft and the ultimate expression of our abilities as a developer.

***

## "Traditional" approaches to achieving these goals

* Manual testing
* Code reviews
* Documentation

[bored_qa.png]
[code_review.png]
[documentation.png]

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

> 1. You should repeat all these tests before every release. How long does it take? Is your release process limited by this? Do you decide not to test some parts that you don't think have changed so that you can release faster?
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

> We've already seen that looking at the code is no guarantee it will work when you run it – there is a bug in the code we wrote.
> Can run inspections on the java code – Intellij comes back with nothing
> The best way of knowing is to run the code and know for sure, but we can save our QA from the tedium.

***

## Example of a unit test

* Going back to our live coding example from earlier…

> Write unit tests, cover the edge and corner cases, exception case, and fix the formatting issue that we didn't notice

***

## Black box testing

* We should not know or care about how the production code is implemented
* We should only care about its behaviour
* This means our test documents the behaviour and not the implementation
* It means we can change the implementation and use the test to prove that the behaviour remains the same

> Documentation comes for free with unit tests

***

## All of my unit tests pass, why doesn't the app work?

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

[typesoftest.png]

> This is a massively simplified representation of the Giraffe application and one of the other applications in the system, Gibn, which supplies market data to Giraffe. The green dots are individual classes; the arrows represent data flow.

> We already know about unit tests. They tell us that the green dots work.
> Module tests tell us that groups of classes that work together work to give higher order functionality.
> Acceptance tests tell us that the application itself can perform the tasks required to satisfy the client.
> External tests ensure that we can interact with our external dependencies.
> Smoke tests attempt to ensure that the application will work when deployed within a real system.

***

## Continuous Integration

* If we have a suite of automated tests we can run them before a release to make sure they all pass
* What if some fail?
    * The release could be delayed
    * Which change broke the test?
    * Who is best placed to fix it?
* Continuous Integration is the running of all the tests, all the time (for every check in)
    * You (and everyone else) knows as soon as something is broken
    * You know which change broke it
    * You can fix it straight away

***

## Teamcity

[http://www.teamcity.com]

***

## Build monitors

* A build monitor in a prominent place
    * Is a source of pride when green
    * A source of shame when red!
    * Fosters a culture of intolerance for broken software 

[red_build.jpg]
[green_build.jpg]
	
***

## Can we take it further?

* Running tests all the time gives a much shorter feedback cycle than only running tests before a release
* What if you are writing a new feature and want some feedback now?
* Write the test first!

***

## Test Driven Development (TDD)

* Writing a test first tells you many things
    * Do I need to write any code at all, or does it already work?
    * Is my test correct if it passed but it definitely shouldn't work?
    * When have I finished implementing the feature?
    * Have I remembered to do edge cases and error handling?
* It provides a scaffold for writing your code that lets you think about the behaviour you want to implement, and less about the implementation itself
* It prevents you over-engineering code – keeps code simpler and cleaner

> Return to IDE and show the PostcodeFormatter example

***

## What else can improve quality?

* We also use pair programming to reduce defects and improve speed
    * Point out typos
    * Check sanity
    * Brainstorm ideas
    * Teach and learn
    * Avoid knowledge silos
    * Motivation!

[pairing.jpg]

***

## What can we achieve now?

* We release any time that the build is green, knowing it will work
* We refactor our code freely and without fear until it is "beautiful"
* We work faster because we have faster feedback
* We fix bugs while the context is fresh in our mind
* Our ecosystem of 6 teams, 10+ applications can develop and release with confidence and consistently deliver a working system

> Refactoring:
> We can rewrite code and be confident it will work
> We can delete code that isn't needed any more
> We can keep our codebase small and relevant

> Faster:
> Faster feedback means we spend less time hunting bugs, so we can respond more quickly to business requirements

> All these things are exactly what I want to achieve as a professional software developer!

***

## What has this meant for the project?

* High onboarding rate sustained
* Significant technical initiatives have not slowed us down
* Happy users!

> "Really it's a dream… So much easier to run...  You know how much I don't like change... That's fantastic!"

> Every other project in the Zoo did not exist at the project inception – they have been created along the way to solve technical hurdles. Our use of automated testing has allowed us to take this in our stride and continue to deliver high quality software to the business

***

## Costs and limitations

* Test code can take on a life of its own
* Managers can obsess over 100% coverage

* Timing and threading issues are still hard to identify and test
* An external dependency with bugs is still unlikely to be caught
* A developer doesn't necessarily have the same mind set as a QA

> Automated testing is great but it's not a silver bullet

> Why isn't 100% coverage a good thing?
> 100% coverage still doesn't mean the app will work – see http://stackoverflow.com/questions/1475520/unit-testing-code-coverage-do-you-have-100-coverage
> Do you think it is a valuable use of time to "test" a simple DTO?

> A developer thinks "how can I make this work" whereas the QA thinks "how can I break this"?

***

