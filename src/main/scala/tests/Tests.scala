package tests

import com.alvinalexander.simpletest.SimpleTest._

@main def tests =

    // run tests and give them descriptions
    isTrue(1 == 1,  "1 == 1 (expecting green)")
    isTrue(1 == 2,  "1 == 2 (expecting red)")
    isFalse(1 == 2, "1 == 2 (expecting green)")
    isFalse(1 == 1, "1 == 1 (expecting red)")
    isEq(1, 1,      "i expect green")
    isEq(1, 2,      "i expect red here")
    todo("don’t forget to test 2 == 3")
    
    // run tests but only give them numbers
    isTrue(1 == 1, 1)
    isTrue(2 == 2, 2)
    isTrue(3 == 3, 3)
    isFalse(1 == 7,  4)
    isFalse(1 == 8,  5)
    isFalse(6 == 60, 6)

    // shoot, just let the object keep track of the test numbers
    isTrue(1 == 1)
    isTrue(2 == 2)
    isFalse(1 == 3)
