
<h3> Description of the Problem </h3>

Given an array of positive distinct integer denoting the crossing time of 'n' people. These 'n' people are standing at one side of bridge. Bridge can hold at max two people at a time. When two people cross the bridge, they must move at the slower person's pace. Find the minimum total time in which all persons can cross the bridge

<h3> Solution to find minimum total time </h3>

      Let N denote the initial set of distinct integers denoting the individual crossing times
      
      Sort the list of elements in N in ascending order
      
      Repeat the following steps until N has 2 or 3 elements left
      
          1.  Let F1 and F2 denote the times taken by the fastest 2 persons in the set. 
              Let the 2 fastest persons initially cross the bridge. So time taken = F2.
              
          2.  Now since torch has to be returned back, let the faster one of the two return back at the other end
              So time taken = F1
              
          3. Let the 2 slowest persons amongst the ones remaining on the left hand side of the bridge, cross the bridge.
             Let their times be S1 and S2 respectively (S2 being higher). So time taken = S2
             
          4. Now let person with time F2 return back with the torch to left side of bridge . Time takem = F2
          
          5. Add all times (T = F2 + F1 + S2 + F2) and increment minimum_time by T. minimum_time  = minimum_time + T
          
          6. Remove elements S1 and S2 from the set. 
             This implies that persons with times S1 and S2 are on right side of bridge and others are on left side

      if 2 elements are left 
          
          Since only elements are left in the set N, implies only 2 persons are left on left side. 
          Cross them with time taken = higher of the two remaining times
          
          Add this time to the minimum_time.

          
      if 3 elements are left
      
          Make the 2 fastest persons cross with time F2  = higher of the two times
          Let the faster of the two return back with time F1 = lower of the two times
          Let the remaining 2 on left side cross with time of the slower person = S
      
          Add (F2 + F1 + S) to the minimum_time.
      
      Return minimum_time
      
      
<h3> Steps to run the code </h3>

1.  Clone the repo https://github.com/nrp317/BridgeCrossingProblem.git

2.  Open command prompt and navigate to the cloned repo in your local system

3.  Compile the file using the command <b><i>javac BridgeCrossingproblem.java</i></b> 

4.  Run the file using the command <b><i>java -ea BridgeCrossingProblem</i></b>

Ensure the code runs successfully with no AssertionErrors.
