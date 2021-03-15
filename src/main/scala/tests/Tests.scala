package tests

import com.alvinalexander.simpletest.SimpleTest._

@main def tests =

    // run tests and give them descriptions
    True(1 == 1,  "1 == 1 (expecting green)")
    True(1 == 2,  "1 == 2 (expecting red)")
    False(1 == 2, "1 == 2 (expecting green)")
    False(1 == 1, "1 == 1 (expecting red)")
    Equals(1, 1,  "i expect green")
    Equals(1, 2,  "i expect red here")
    Todo("don’t forget to test 2 == 3")
    
    // run tests but only give them numbers
    True(1 == 1,   1)
    True(2 == 2,   2)
    True(3 == 3,   3)
    False(1 == 7,  4)
    False(1 == 8,  5)
    False(6 == 60, 6)

    // numbering is too much work, just let the object 
    // keep track of the test numbers
    True(1 == 1)
    False(1 == 2)
    Equals(1, 1)

