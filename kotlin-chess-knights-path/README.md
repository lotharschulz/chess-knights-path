# Path finding for chess knights

A program that finds the shortest path for a chess knight to take between two points on a standard 8x8 chessboard.

In chess, knights move in an L-shape: 2 squares along one dimension, 1 square along the other. 
See https://en.wikipedia.org/wiki/Knight_(chess)#Movement for more details.

### Functional requirements
Command-line executable that reads instructions from standard input (stdin).
Instructions are lines (separated by newlines) in the following format:
D4 G7
D4 D5


The first of the space-separated values is the knight's starting position, the second is the knight's target position.
For each line in the input, your program should print (to standard out) the shortest path it found. So for the example above, it should print e.g.:

D4 E6 G7

D4 C4 B4 D5

D4 E6 C7

There are other paths available with same length:

D4 F5 G7

D4 E2 F4 D5

D4 B5 C7

### Solution

#### Precondition
[gradle](https://gradle.org/) ([prerequisit](https://docs.gradle.org/current/userguide/installation.html#sec:prerequisites) & [installation](https://gradle.org/install/#install))

Test your gradle installation from your command line:

```bash
gradle
```

output should be similar to

```bash
gradle

> Task :help

Welcome to Gradle 4.0.1.

.....

```

 

#### Run it

```bash
gradle run -Dexec.args="D4 G7"
```
```bash
gradle run -Dexec.args="D4 D5"
```
```bash
gradle run -Dexec.args="D4 C7"
```

#### Test it

```bash
gradle test
```

##### "full" dev round trip
```bash
gradle clean test && gradle run -Dexec.args="D4 G7" && gradle run -Dexec.args="D4 D5" && gradle run -Dexec.args="D4 C7" 
```
