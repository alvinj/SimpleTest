# SimpleTest

This is an extremely simple “testing” framework that I’m using with the 
[Scala Cookbook (2nd Edition)](https://amzn.to/3du1pMR). After trying a 
few different testing frameworks, I decided that what I really wanted 
was to have my tests in `@main` methods, so I created this very little 
library.

To call this a “framework” is a bit of an inside joke. It’s really just
about 100 lines of code that give me something more than `assert` and
less than a full-blown testing framework with other required dependencies.



## Usage

Currently you have to build the project with `sbt package` and
then put the resulting jar file in your _lib_ directory. At some
point I’ll work on packaging this a bit more.

Once you have the needed jar file, see the 
[src/main/scala/tests/Tests.scala](Tests.scala) file for
up-to-date examples, but the basic usage looks like this:

```scala
import com.alvinalexander.simpletest.SimpleTest._

@main def tests =

    // use `True` to assert that an expression is true
    True(1 == 1,  "1 == 1 (expecting green)")
    True(1 == 2,  "1 == 2 (expecting red)")

    // use `False` to assert that an expression is false
    False(1 == 2, "1 == 2 (expecting green)")
    False(1 == 1, "1 == 1 (expecting red)")

    // use `Equals` to assert that two objects are `==`
    Equals(1, 1,  "i expect green")
    Equals(1, 2,  "i expect red here")

    // in case you want to note tests that you intend to run
    Todo("don’t forget to test 2 == 3")
    
    // numbering is too much work, just let the object 
    // keep track of the test numbers
    True(1 == 1)
    False(1 == 2)
    Equals(1, 1)
```



## Versions

- 0.3.0
    - Now using `True`, `False`, `Equals`, and `Todo` for the test names
    - I like these names better than the alternatives I tried (`_true`,
      `true_?`, `isTrue`, etc.)
