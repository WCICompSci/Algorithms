# Algorithms

## Breadth First Search (BFS)
Problem: Find the minimum distance between two points on a matrix
  1. Start with a matrix. Input the size of the matrix. This will store the number of steps each coordinate is from the beginning coordinate
  2. Input a beginning x and y coordinate
  3. Fill the matrix with a maximum value
  4. Set the beginning coordinate to 0 in the matrix, representing 0 steps from itself
  5. Create two queue lists: one for the x and one for the y value of the queued coordinates
  6. Add the beginning x and y values to their respective queues
  7. Run a while loop until the queues are empty
  8. Get a value from both queues and assign them to temporary variables
  9. Check every possible direction using if statements. If the direction is traversable, add their coordiantes to the queues and set the step value in its position in the matrix as the step of the current position plus 1
  10. Output the value in the step matrix at the desired end position
  
## Depth First Search (DFS)
Problem: Find the minimum distance between two points on a tree
  1. Start with an graph array. This will store the nodes
  2. Initialize a parent array. This will hold the parent or ancestor of each node on the tree.
     The parent of the root node will be 0. Set all values in parent array to 0
  3. Initialize a distance array and set all values to 0
  4. Create a dfs method
  5. Iterate through the node values of the graph array
  6. If the node is not the root, set the parent of the node as the root. Set the distance of the current node to the distance of the root plus 1
  7. Recur the dfs method
  8. In the main class, dfs the root node
  9. Output the distance of the desired end position
  
## Dijkstra's Shortest Path
 Problem: Find the distance between two nodes of the least weight in a connected and undirected graph
  1. Create an adjacency matrix that represents the edges of the nodes. Input.
  2. Create a weight array that holds the minimum weight of each node from the beginning node
  3. Fill the weight array with a maximum value
  4. Create a queue list that holds the current node
  5. Create a Path class that has a node variable and a weight variable. Initialize it with a constructor
  6. Add a new Path object to the queue list with a node 0 and weight 0
  7. Run a while loop until the queue is empty
  8. Get an the node and weight from an object from the queue and assign it to temporary variables
  9. If the weight from the queue is less than the weight of the node in the weight array, set the weight of the node in the weight array to that of the temporary variable. Iterate through the values on the row of the index of the node in the adjacency matrix. If there is an edge, add a new Path to the queue, with the distance of the current node plus 1 and the node of the index in the adjacnecy matrix
  10. Output the weight of the desired end position

## Dynamic Programming (DP)
Problem: Find the minimum number of values in an array to evenly add up to a desired value, if possible
  1. Input the desired value d and the number of values n
  2. Create an array that stores the values. Input the values
  3. Create a dp array. This will be used to store the minimum number of values to get to each index between 0 and d
  4. Fill the dp array with a maximum value
  5. Set the beginning value of the dp array to 0, representing a distance of 0 from itself
  6. Create a nested for loop that iterates i through the numbers to d and then j through the numbers to the number of values. If the difference between i and the jth value in the value array is greater than or equal to 0, set the ith value of the dp array to the minimum between itself and the difference between i and the jth value's index in the dp array plus 1 value array. This way, all possibilities are tried and the one that is the minimum is stored 
  7. If the the dth value of the dp array is equal to the maximum value, output that the problem is not possible.
     Otherwise, output the dth value in the dp array
     
## Dynamic Programming with Prefix Sum Array (DP w/ PSA)
  Problem: Given an array of values in which a given number of adjacent values could be "taken" and removed a given number of times, find the maximum value sum
  1. Input the size of the array n, the number of adjacent values w, and the number of times adjacent values could be taken k
  2. Initialize a value array and a psa array, set the size to n, input values
  3. Initialize a dp matrix, set the size to n by k
  4. Set psa array as the psa of the previous index plus the value in the value array
  5. Create a nested for loop that iterates through the dp matrix, with i iterating to n and j iterating to k. To reduce required memory  and time, we will be checking the values from left to right. Set the dp of i plus w by j plus 1 to the maximum between itself and the dp of i by j plus the psa of i plus w plus 1 minus the psa of i minus 1. Set the dp of i plus 1 by j to the maximum between itself and the dp of i by j. The reason for this is to check every possibility of take or not take that can be done to each part of the array. If the point in the array is taken, the i value becomes the i plus the size of the part that is taken, and the j increases by 1, as we used up a time. Otherwise, it is just i plus 1, as we are going from left to right. 
  6. Initialize variable answer, set as 0
  7. Create for loop that iterates a to n and b to k. Set answer to the maximum between itself and the dp of a by b
  8. Output the answer variable
  
## Kruskal's Minimum Spanning Tree (Kruskal's MST)
Problem: Given an unconnected graph, find the minimal number of edges to add and the lengths of the edges to create a completely connected graph. Find all solutions if more than one
  1. Create Path class with node, parent, and distance variable. Initialize with contructor and implement comparable method that compares distance. If difference in distance is greater than 0, return 1. If difference in distance is less than 0, return -1. Otherwise, return 0
  2. Input number of nodes and x and y positions of nodes to and array that stores x coordinates and y coordinates
  3. Initialize list of arrays, to store edges between nodes
  4. Input existing edges
  5. Create a priority queue that stores Paths. Store a Path with 0 node, 0 parents, and 0 distance. This will be the beginning node
  6. Create a boolean array to store whether a node has been visited or not
  7. Initialize a list to store output
  8. Create a variable to store answer. Set answer to 0
  9. Run a while loop until the priority queue is empty
  10. Assign the node, parents, and distance from a Path in the priority queue to temporary variables
  11. If the current Path is true in the visited array, continue to while loop
  12. Otherwise, add the distance to the answer. Add the Path to the output list. Set the node in the visited array to true. 
  13. Iterate through nodes. If the node is not visited, calculate distance between current node and unvisited node using pythagorean theorem between x and y coordinates of the two nodes.
  14. Iterate through the list of the current node's index in the list array. If thge value in the list is not visited, add a new Path with 0 distance, the current node as the parent, and the unvisited node as the node
  15. Output the answer variable. Iterate through the number of nodes. If the distance of the output array of the node is not 0, output its node and parent
     
## Sweep Line
Problem: Given a 2d grid that alternates between an obstacle of a given height vertically coming from the bottom and one from the top, starting with one from the bottom, find the minimum number of obstacle components that must be hit when going left to right, as well as the number of occurrence of this minimum
  1. Input n, the number of obstacles and h, the height of the grid
  2. Create a one-dimensional array to represent the grid. The array can represent it because only the vertical values are significant to the problem, and using a smaller set of data allows us to reduce memory and time
  3. Set a start variable to half of n+1
  4. Iterate to n, alternate between adding 1 to the index at h minus inputted number and subtracting 1 from the index at inputted number. This way, when the line is swept through from bottom to top, it loses 1 every time it passes an upwards facing obstacle and gains one every time it comes onto a downwards facing obstacle
  5. Set a variable min as a maximum value, this will store the minimum number of obstacles that need to be hit. Set a variable num as 0, this will store the number of rows where the minimum is hit
  6. Iterate i to h. Add the ith term of the array to count. If count is lss than min, set min to count and num to 0. If count equals min, increase num by 1
  7. Output the min and num variables
