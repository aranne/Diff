# Diff

Show the differences between two txt files.

#### Algorithm: 
Use google hash library to hash lines in file to hashcode value.

Double check lines string to avoid hash collisions.

Then use Longest Common Subsequences to get the common lines between two files.

#### Example output:
$ diffprint  f1.txt f2.txt 

   Hello

\- there 

   world.

\+ Really! 

\+ Yep.
