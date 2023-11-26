# Clean Code and Refactoring

Somewhere along the way code goes from good to bad. 
It can happen from many reasons.
Regardless of the number of people working on a project, deadlines or the history of the project itself, the code tends
to become bad.

In order to talk about good code, first one must define what bad code is.
There are characteristics of bad code, even documented in literature about software craftsmanship and some of the most 
popular ones are code smells, or even more generic, the symptoms of the rotting system design which can be found here 
[1].


## Symptoms of Rotting Design
The 4 popular symptoms are:
* Rigidity
* Fragility
* Immobility
* Viscosity


## Steps on Refactoring Code
* Names should be meaningful:
  * Expressing the objects/entities/purpose;
  * Full real names;
  * Abbreviations might cause confusions.
* Classes/Types or functions/procedures should be kept small.
* Side effects should be avoided.
* Comments should be meaningful and express smth that is not deducible by the code.
* The main goal is human readability!



## References
[1] [Design Principles and
Design Patterns by R. C. Martin](https://staff.cs.utu.fi/~jounsmed/doos_06/material/DesignPrinciplesAndPatterns.pdf)

[2] [Code smells repository](https://github.com/nerdschoolbergen/code-smells)
