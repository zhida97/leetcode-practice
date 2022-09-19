public class a1_The_LeetCode_Beginners_Guide {

    // 1. Add Two Integers
    // Given two integers num1 and num2, return the sum of the two integers.
    public int sum(int num1, int num2) {
        return num1 + num2;
    }

    // 2. Running Sum of 1d Array
    // Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
    // Return the running sum of nums.
    public int[] runningSum(int[] nums) {

        // Create a new array for answer based on the length of the input
        int[] sumOfNums = new int[nums.length];

        // Create a new int to hold the sum for all the values
        int sum = 0;

        // Loop the input array
        for(int i = 0; i < nums.length; i++){

            // Add the current value to the sum
            sum = nums[i] + sum;

            // Add the sum to the answer array
            sumOfNums[i] = sum;
        }

        // Return the result
        return sumOfNums;
    }

    // 3. Richest Customer Wealth
    // You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank. Return the wealth that the richest customer has.
    // A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.
    public int maximumWealth(int[][] accounts) {
        public int maximumWealth(int[][] accounts) {

            /// Init the sum of the current customer
            int sumOfTheCurrentCustomer = 0;

            // Init the highest wealth
            int maxWealth = 0;

            // Loop all the accounts
            for(int i = 0; i < accounts.length; i++){

                // Loop all the array inside each account
                for(int j = 0; j < accounts[i].length; j++){

                    // Accumulate the total amount of the current customer
                    sumOfTheCurrentCustomer = accounts[i][j] + sumOfTheCurrentCustomer;

                    // If the current total greater than the highest wealth
                    if(sumOfTheCurrentCustomer > maxWealth){

                        // set the highest wealth as the current highest
                        maxWealth = sumOfTheCurrentCustomer;
                    }
                }

                // Reset the current amount for the next customer
                sumOfTheCurrentCustomer = 0;
            }

            // Return the result
            return maxWealth;
        }
    }

    // 4. Fizz Buzz
    // Given an integer n, return a string array answer (1-indexed) where:
    // answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
    // answer[i] == "Fizz" if i is divisible by 3.
    // answer[i] == "Buzz" if i is divisible by 5.
    // answer[i] == i (as a string) if none of the above conditions are true.
    public List<String> fizzBuzz(int n) {

        // Initialize a new string array
        List<String> listString = new ArrayList<String>(n);

        // Loop and generate the array based on the size of n
        for(int i = 1; i <= n; i++){

            // "FizzBuzz" if i is divisible by 3 and 5.
            if(i % 3 == 0 && i % 5 == 0){

                // Update the list
                listString.add("FizzBuzz");

                // Move to the next loop
                continue;
            }

            // answer[i] == "Fizz" if i is divisible by 3.
            else if(i % 3 == 0){

                // Update the list
                listString.add("Fizz");

                // Move to the next loop
                continue;
            }

            // answer[i] == "Buzz" if i is divisible by 5.
            else if(i % 5 == 0){

                // Update the list
                listString.add("Buzz");

                // Move to the next loop
                continue;
            }

            // answer[i] == i (as a string) if none of the above conditions are true.
            else{

                // Update the list
                listString.add(String.valueOf(i));

                // Move to the next loop
                continue;
            }
        }

        // Return the result
        return listString;
    }

    // 5. Number of Steps to Reduce a Number to Zero
    // Given an integer num, return the number of steps to reduce it to zero.
    // In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
    public int numberOfSteps(int num) {

        // Number of steps
        int steps = 0;

        // Loop until the num become 0
        while (num > 0){

            // if the current number is even, you have to divide it by 2
            if(num % 2 == 0){
                num = num / 2;
            }

            // otherwise, you have to subtract 1 from it.
            else {
                num = num - 1;
            }

            // Steps increment
            steps = steps + 1;
        }

        // Return the result
        return steps;
    }

    // 6 - 876. Middle of the Linked List
    // Given the head of a singly linked list, return the middle node of the linked list.
    // If there are two middle nodes, return the second middle node.
    public ListNode middleNode(ListNode head) {

        // Initialize the middle node, the node that keep moving until the endNodes stop it
        ListNode middleNode = head;

        // Initialize the end node, the end node is for telling the middle node that there're still space to continue moving
        ListNode endNode = head;

        // Loop until the endNode gets to the end
        while(endNode != null && endNode.next != null){

            // Move the middleNode up by one step
            middleNode = middleNode.next;

            // Move the endNode up by two steps
            endNode = endNode.next.next;
        }

        // Return the result
        return middleNode;
    }

    // 7 - 383. Ransom Note
    // Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
    // Each letter in magazine can only be used once in ransomNote.
    public boolean canConstruct(String ransomNote, String magazine) {

        // Initialize the magazineMap for storing the characters and its count
        HashMap<Character, Integer> magazineMap = new HashMap<>();

        // Loop for each chars in magazine
        for(int i = 0; i < magazine.length(); i++){

            // Store the current character
            Character a = magazine.charAt(i);

            // Get the count of the character in the map, default to 0
            int currentCount = magazineMap.getOrDefault(a, 0);

            // Add the character in the map with the current count + 1
            magazineMap.put(a, currentCount + 1);
        }

        // Loop for each chars in ransomNote
        for(int j = 0; j < ransomNote.length(); j++){

            // Check the current character
            Character b = ransomNote.charAt(j);

            // Get the count of the character in the map
            int currentCt = magazineMap.getOrDefault(b, 0);

            // If the count is 0, return false
            if(currentCt == 0) {
                return false;
            }

            // Else continue the operation by removing the char count from the map
            magazineMap.put(b, currentCt - 1);
        }

        // Return true if manage to reach here
        return true;
    }

    // 8 - 9. Palindrome Number
    // Given an integer x, return true if x is palindrome integer.
    // An integer is a palindrome when it reads the same backward as forward.
    // For example, 121 is a palindrome while 123 is not.
    public boolean isPalindrome(int x) {

        // negative will not be a palindrome for sure
        // if the last digit is 0, it can't be reversed unless it is exactly 0
        if(x < 0 || x % 10 == 0 && x != 0){
            return false;
        }

        // Declare the reverted number
        int revertedNumber = 0;

        // when the original number is less than the reversed number, it means we've processed half of the number digits.
        while(revertedNumber < x){

            // Taking the current number position, times 10 + the remainder of x % 10
            revertedNumber = revertedNumber * 10 + x % 10;

            // Shift down the x as well
            x = x / 10;
        }

        // True if one of the following occur, if the length of digit is
        // even, revertedNumber == x
        // odd, revertedNumber / 10(this will be bigger when the loop ends) == x, the middle for the odd will be the same always
        return revertedNumber == x || revertedNumber / 10 == x;
    }

    // 9 - 13. Roman to Integer
    // Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
    // Symbol       Value
    // I             1
    // V             5
    // X             10
    // L             50
    // C             100
    // D             500
    // M             1000
    // Given a roman numeral, convert it to an integer.
    public int romanToInt(String s) {

        // Initialize the integer answer
        int answer = 0;

        // Loop each character in the string and increase the answer accordingly
        for (int i = 0; i < s.length(); i++){

            char curChar = s.charAt(i);

            if(curChar == 'I'){
                answer += 1;
            }

            else if(curChar == 'V'){
                answer += 5;
            }

            else if(curChar == 'X'){
                answer += 10;
            }

            else if(curChar == 'L'){
                answer += 50;
            }

            else if(curChar == 'C'){
                answer += 100;
            }

            else if(curChar == 'D'){
                answer += 500;
            }

            else if(curChar == 'M'){
                answer += 1000;
            }
        }

        // Decrease the number accordingly, but take note we're doubling the decrement because we added it on top
        // There are six instances where subtraction is used:
        // I can be placed before V (5) and X (10) to make 4 and 9.
        // X can be placed before L (50) and C (100) to make 40 and 90.
        // C can be placed before D (500) and M (1000) to make 400 and 900.
        if(s.contains("IV")){
            answer -= 2;
        }

        if(s.contains("IX")){
            answer -= 2;
        }

        if(s.contains("XL")){
            answer -= 20;
        }

        if(s.contains("XC")){
            answer -= 20;
        }

        if(s.contains("CD")){
            answer -= 200;
        }

        if(s.contains("CM")){
            answer -= 200;
        }

        return answer;
    }

    // 10 - 1. Two Sum
    // Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    // You may assume that each input would have exactly one solution, and you may not use the same element twice.
    // You can return the answer in any order.
    public int[] twoSum(int[] nums, int target) {

        // Create an array which holds two integer
        int[] answer = new int[2];

        // Loop each number
        for(int i = 0; i < nums.length-1; i++){

            // Loop each number +1
            for(int j = 1; j < nums.length; j++){

                // If number and next number is the same and i cannot be the same as j, assign to the array and end
                if(nums[i] + nums[j] == target && i != j){
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }
        return answer;
    }
}

