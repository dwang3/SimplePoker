# SimplePoker

Yu'an Wang 100822446

https://github.com/dwang3
https://github.com/dwang3/SimplePoker

to run code, pull from github or drop all .java files into a new package with junit in the build path

all junit tests are run from TestingSuite.java (there may be some failures due to rounding errors)

TestPlayers.java has test methods for checking player IDs in the right position, valid player IDs, valid hands containing no duplicate cards or invalid cards
TestCards.java has test methods for individual cards that are invalid
TestHands.java has test methods for each hand ranking and checking hands for 5 cards. Also checking for which hand will "win" and which hands are tied in strength
TestRound.java has test methods for "rounds" or games where a few players are input, then it outputs the ranking for each player that entered. if two hands are tied then they both have the same ranking

invalid rounds (any invalid cards, hands or IDs) will not be output

you can input cards using a playerId followed by a string of space separated cards or with a numerical rank and suit
invalid cards may be added but rounds will not be able to be output with them

Hand.java is unused