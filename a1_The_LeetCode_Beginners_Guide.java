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
}
}
