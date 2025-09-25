```mermaid
---
config:
  layout: elk
  class:
    hideEmptyMembersBox: false
---
classDiagram
direction TB
    class DoppelkopfGame {
    }
    class Player {
	    +hand : Hand
	    -score: int
        -wonCards: List~Card~

        +getScore() int
        +getCurrentPoints() int
    }
    class Hand {
	    -cards : List~Card~
	    +Hand(l: List~Card~)
	    +getTrumps() int
	    +getPlains() int
	    +playCard(c: Card) void
	    +playCard(i: int) void
	    +getCards() List~Card~
    }
    class Card {
	    -color: Color
	    -type: CardType
	    +Card(c: Color,  t: CardType)
	    +getValue() int
	    +getColor() Color
	    +getType() CardType
    }
    Card <-- Hand
    Hand <-- Player
```