# Java-MultiThreading-and-Semaphores
 P1: Using semaphores, design and implement an algorithm that prevents deadlock. Use threads to simulate multiple/concurrent WARs and assume that the group of WARs are constantly attempting to use the intersection from all four directions (N, S, W, E). Your program should input parameters at runtime to initialise the number of WARs from each direction. For example, the input ”N=3 S=1 E=1 W=1” would indicate that the simulation should start with 3, 1, 1 and 1 WARS starting from north, south, east and west direction respectively. WARs should be numbered continuously starting from 1 (e.g. WAR-1, WAR-2 etc.) You may choose how to number the WARs but the total number of WARs from each direction (N, S, E, W) must match the input. Depending on whether a WAR is going towards the Dock or towards the Storage it will be “Loaded” or “Unloaded”, respectively.  

P2: Using monitor, design and implement an algorithm that ensures the operation of the multi-printer according to the above characteristics. Use threads to simulate multiple concurrent printing jobs. Your solution should be fair – stream of Monochrome printing jobs should not cause the Colour Printing jobs wait forever or vice versa.   


P3: You will need to implement a solution for Problem 2 (Colour and Monochrome Printing) using semaphore. 
Using semaphore, design and implement an algorithm that ensures the operation of the multi-printer according to the above characteristics. Use threads to simulate multiple concurrent printing jobs. Your solution should be fair – stream of Monochrome printing jobs should not cause the Colour Printing jobs wait forever or vice versa. 
