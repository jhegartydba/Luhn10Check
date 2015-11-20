package Luhn;

import javax.swing.JOptionPane;

public class Luhn10Check 
{

    /**
    *                       Luhn 10 Check
    *   Copyright (C) 2015 Joseph Hegarty
    *   A simple Java class which can be used when you need to check whether a credit card conforms 
    *   to a LUHN-10 coded number algorithm.
    *   The 1st CC number is multiplied by 2, the 2nd by 1, etc,  this is the repeated for the whole 
    *   card number. If the multiplied number is greater than 9 then the 2 digits are added 
    *   together (e.g. 18 --> 1 + 8 = 9) the sum of all the number is then mod by 10. If this 
    *   returns zero then the card has passed the LUHN-10 check.
    *   There is a one-in-ten chance that a totally random number will pass this simple validity test.
    *   Example - Test Card Number 4563 9601 2200 1999
    *    4   5   6   3   9   6   0   1   2   2   0   0   1   9   9   9 
    *   x2  x1  x2  x1  x2  x1  x2  x1  x2  x1  x2  x1  x2  x1  x2  x1  
    *   --  --  --  --  --  --  --  --  --  --  --  --  --  --  --  -- 
    *   8   5  12   3  18   6   0   1   4   2   0   0   2   9  18   9
    *   8 + 5 + 3 + 3 + 9 + 6 + 0 + 1 + 4 + 2 + 0 + 0 + 2 + 9 + 9 + 9  = 70
    *   70 = 0 mod 10
    *   The test PASSED the check since the returned result is zero.
    *   Luhn Algorithm - <https://en.wikipedia.org/wiki/Luhn_algorithm>.
    *     
    *   This program is free software: you can redistribute it and/or modify
    *   it under the terms of the GNU General Public License as published by
    *   the Free Software Foundation, either version 3 of the License, or
    *   (at your option) any later version.
    *
    *   This program is distributed in the hope that it will be useful,
    *   but WITHOUT ANY WARRANTY; without even the implied warranty of
    *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    *   GNU General Public License for more details.

    *   You should have received a copy of the GNU General Public License
    *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
    * 
    */
    public static void main(String[] args)
    {
        boolean doAgain = true;
        String inputValue = "";
        while(doAgain) {
            
            inputValue = JOptionPane.showInputDialog("Please enter card number: ");
         
            if(Check(inputValue))
            {
                JOptionPane.showMessageDialog(null, "The card has passed the Luhn check.", "Luhn Card Check", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "The card has failed the Luhn check.", "Luhn Card Check", JOptionPane.ERROR_MESSAGE);
            }
            
            int answer = JOptionPane.showConfirmDialog(null,"Do you wish to check another Card?", "Check Another Card", JOptionPane.YES_NO_OPTION);
            
            if (answer == 0) {
                doAgain = true;
            }
            else
            {
                doAgain = false;
            }
        
        }
    }
        

    private static boolean Check(String ccNumber)
    {
        int sum = 0;
        boolean alternate = false;
        for (int i = ccNumber.length() - 1; i >= 0; i--)
        {
            int n = Integer.parseInt(ccNumber.substring(i, i + 1));
            if (alternate)
            {
                n *= 2;
                if (n > 9)
                {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
     }
}
