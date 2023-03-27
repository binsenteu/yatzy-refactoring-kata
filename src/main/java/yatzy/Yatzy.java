package yatzy;

import java.util.List;

public class Yatzy {
    public static int yatzy(DiceRoll diceRoll) {
        if (diceRoll.getFacesWithOccurrence(5).isEmpty()) {
            return 0;
        }
        return 50;
    }

    public static int chance(DiceRoll diceRoll) {
        return diceRoll.getSum();
    }


    public static int ones(DiceRoll diceRoll) {
        return diceRoll.getOccurrence(1);
    }

    public static int twos(DiceRoll diceRoll) {
        return diceRoll.getOccurrence(2) * 2;
    }

    public static int threes(DiceRoll diceRoll) {
        return diceRoll.getOccurrence(3) * 3;

    }

    public static int fours(DiceRoll diceRoll) {
        return diceRoll.getOccurrence(4) * 4;

    }

    public static int fives(DiceRoll diceRoll) {
        return diceRoll.getOccurrence(5) * 5;

    }

    public static int sixes(DiceRoll diceRoll) {
        return diceRoll.getOccurrence(6) * 6;

    }

    public static int onePair(DiceRoll diceRoll) {
        List<Integer> pairs = diceRoll.getFacesWithOccurrenceEqualOrGreaterThan(2);
        if (!pairs.isEmpty()) {
            return pairs.get(0) * 2;
        }
        return 0;
    }

    public static int twoPairs(DiceRoll diceRoll) {
        List<Integer> pairs = diceRoll.getFacesWithOccurrenceEqualOrGreaterThan(2);
        if (pairs.size() == 2) {
            return pairs.stream().reduce(0, Integer::sum) * 2;
        }
        return 0;
    }

    public static int threeOfAKind(DiceRoll diceRoll) {
        return diceRoll.getFaceWithOccurrenceEqualOrGreaterThan(3) * 3;
    }

    public static int fourOfAKind(DiceRoll diceRoll) {
        return diceRoll.getFaceWithOccurrenceEqualOrGreaterThan(4) * 4;
    }

    public static int smallStraight(DiceRoll diceRoll) {
        for (int face = 1 ; face < 6 ; face++) {
            if (diceRoll.getOccurrence(face) == 0) {
                return 0;
            }
        }
        return 15;
    }

    public static int largeStraight(DiceRoll diceRoll) {
        for (int face = 2 ; face < 7 ; face++) {
            if (diceRoll.getOccurrence(face) == 0) {
                return 0;
            }
        }
        return 20;
    }

    public static int fullHouse(DiceRoll diceRoll) {
        Integer threeOfAKindFace = diceRoll.getFaceWithOccurrence(3);
        Integer pairFace = diceRoll.getFaceWithOccurrence(2);
        if (threeOfAKindFace > 0 && pairFace > 0) {
            return threeOfAKindFace * 3 + pairFace * 2;
        }
        return 0;
    }
}



