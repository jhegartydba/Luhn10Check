# Luhn10Check

This is a simple Java class which checks whether a number conforms to the Luhn Algorithm.

The 1st number is multiplied by 2, the 2nd by 1, etc.,  this is the repeated for the whole card number. 

If the multiplied number is greater than 9 then the 2 digits are added together (e.g. 18 --> 1 + 8 = 9) 

the sum of all the number is then mod by 10. If this returns zero then the card has passed the LUHN-10 check.

There is a one-in-ten chance that a totally random number will pass this simple validity test.

Example - Card Number 4563 9601 2200 1999

 4   5    6    3    9    6    0    1    2    2    0    0    1    9    9   9 
 
x2    x1    x2    x1    x2    x1    x2    x1    x2    x1    x2    x1    x2    x1    x2    x1  

--  --  --  --  --  --  --  --  --  --  --  --  --  --  --  -- 

 8   5  12   3  18   6   0   1   4   2   0   0   2   9  18   9
 
 8 + 5 + 3 + 3 + 9 + 6 + 0 + 1 + 4 + 2 + 0 + 0 + 2 + 9 + 9 + 9  = 70
 
70 = 0 mod 10

The test PASSED since the result is zero.

Luhn Algorithm - <https://en.wikipedia.org/wiki/Luhn_algorithm>
