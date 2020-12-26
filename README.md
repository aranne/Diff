# Diff

> Show the differences of two txt files.

#### Algorithm: 

Use google hash library to hash lines in file to hashcode values.

Double check line's string equality to avoid hash collisions.

Then compute Longest Common Subsequences (LCS) to get common lines of two files.

#### How to run:
1. Run HashFile function:

   `$java -jar HashFile.jar ex41.txt`

2. Run Diff function:

   `$java -jar Diff.jar ex61.txt ex62.txt`

3. Run DiffPrint function:

   `$java -jar DiffPrint.jar ex41.txt ex42.txt`

#### Example output:
`$ java DiffPrint.jar f1.txt f2.txt `

```
   Hello

 - there 

   world.

 + Really! 

 + Yep.
```
