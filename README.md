# Diff

Show the differences between two txt files.

#### Algorithm: 
Use google hash library to hash lines in file to hashcode value.

Double check lines string to avoid hash collisions.

Then use Longest Common Subsequences to get the common lines between two files.

#### How to run
1. Run HashFile function:

$java -jar HashFile.jar ex41.txt

2. Run Diff function:

$java -jar Diff.jar ex61.txt ex62.txt

3. Run DiffPrint function:

$java -jar DiffPrint.jar ex41.txt ex42.txt

#### Example output:
$ diffprint  f1.txt f2.txt 

   Hello

\- there 

   world.

\+ Really! 

\+ Yep.
