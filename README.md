# Geo-Task

## Solution for: Find 9 letter words that are still valid after removing one letter each time

### Output of solution
#### Words found(count): 775
#### Execution time: ~0.2s (excluding words fetch time)

### Description

All words in the English language are loaded from a remote URL.
The program first filters all 9-letter words and then checks each one to see if it meets the following condition:
 - A word is considered valid if we can progressively remove one letter at a time, and each resulting word (until we get down to a single letter) still exists in the list.


#### Solution is written using Java v.21.0.5(eclipse-temurin)
