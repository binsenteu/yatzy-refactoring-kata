package yatzy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class DiceRoll {


    private final List<Integer> diceRoll;

    public DiceRoll(int d1, int d2, int d3, int d4, int d5) {
        this.diceRoll = Arrays.asList(d1, d2, d3, d4, d5);
    }

    /**
     *
     * @return Sum of the faces of the dice roll
     */
    public Integer getSum() {
        return diceRoll.stream().reduce(0, Integer::sum);
    }

    /**
     *
     * @return Map of dice face as key and their frequencies as value
     */
    public Map<Integer, Integer> getFacesOccurrences() {
        return diceRoll.stream().collect(groupingBy(Function.identity(), summingInt(e -> 1)));
    }

    /**
     *
     * @param face value of the face
     * @return frequency of the face requested
     */
    public Integer getOccurrence(int face) {
        return getFacesOccurrences().getOrDefault(face, 0);
    }

    /**
     *
     * @param occurrence occurrence of the face
     * @return List of faces that have the occurrence requested
     */
    public List<Integer> getFacesWithOccurrence(int occurrence) {
        return getFacesOccurrences().entrySet().stream().filter(entry -> entry.getValue() == occurrence)
            .map(Map.Entry::getKey).collect(Collectors.toList());
    }

    /**
     *
     * @param occurrence occurrence of the face
     * @return Any face that have the occurrence requested. 0 if face not found.
     */
    public Integer getFaceWithOccurrence(int occurrence) {
        List<Integer> faceList = getFacesWithOccurrence(occurrence);
        if (faceList.isEmpty()) {
            return 0;
        }
        return faceList.get(0);
    }

    /**
     *
     * @param occurrence occurrence of the face
     * @return List of faces with a occurrence equal or greater than the occurrence requested
     */
    public List<Integer> getFacesWithOccurrenceEqualOrGreaterThan(int occurrence) {
        return getFacesOccurrences().entrySet().stream().filter(entry -> entry.getValue() >= occurrence)
            .map(Map.Entry::getKey).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    /**
     *
     * @param occurrence occurrence of the face
     * @return Greatest face with a occurrence equal or greater than the occurrence requested. 0 if face not found.
     */
    public Integer getFaceWithOccurrenceEqualOrGreaterThan(int occurrence) {
        List<Integer> faceList = getFacesWithOccurrenceEqualOrGreaterThan(occurrence);
        if (faceList.isEmpty()) {
            return 0;
        }
        return faceList.get(0);
    }



}
