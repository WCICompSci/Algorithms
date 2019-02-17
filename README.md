# Algorithms

**Breadth First Search (BFS)**
Problem: Find the minimum distance between two points on a matrix
  1. Start with a matrix. Input the size of the matrix. 
     This will store the number of steps each coordinate is from the beginning coordinate
  2. Input a beginning x and y coordinate
  3. Fill the matrix with a maximum value
  4. Set the beginning coordinate to 0 in the matrix, representing 0 steps from itself
  5. Create two queue lists: one for the x and one for the y value of the queued coordinates
  6. Add the beginning x and y values to their respective queues
  7. Run a while loop until the queues are empty
  8. Get a value from both queues and assign them to temporary variables
  9. Check every possible direction using if statements. If the direction is traversable, add their coordiantes to the queues and set the
     step value in its position in the matrix as the step of the current position plus 1
  10. Output the value in the step matrix at the desired end position
  
  **Depth First Search (DFS)**
Problem: Find the minimum distance between two points on a tree
  1. Start with an graph array of size n. This will store the nodes
  2. Initialize a parent array. This will hold the parent or ancestor of each node on the tree.
     The parent of the root node will be 0. Set all values in parent array to 0
  3. Initialize a distance array and set all values to 0
  4. Create a dfs method
  5. Iterate through the node values of the graph array
  6. If the node is not the root, set the parent of the node as the root. Set the distance of the current node to the distance of the
     root plus 1
  7. Recur the dfs method
  8. In the main class, dfs the root node
  9. Output the distance of the desired end position
  
  **Dijkstra**
 Problem: Find the distance between two nodes of the least weight
  1. Create an adjacency matrix that represents the edges of the nodes. Input.
  2. Create a weight array that holds the minimum weight of each node from the beginning node
  3. Fill the weight array with a maximum value
  4. Create a queue list that holds the current node
  5. Create a Path class that has a node variable and a weight variable. Initialize it with a constructor
  6. Add a new Path object to the queue list with a node 0 and weight 0
  7. Run a while loop until the queue is empty
  8. Get an the node and weight from an object from the queue and assign it to temporary variables
  9. If the weight from the queue is less than the weight of the node in the weight array, set the weight of the node
     in the weight array to that of the temporary variable. Iterate through the values on the row of the index of the node
     in the adjacency matrix. If there is an edge, add a new Path to the queue, with the distance of the current node plus 1
     and the node of the index in the adjacnecy matrix
  10. Output the weight of the desired end position
