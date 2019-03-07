import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Calculator {
    public int evaluatePoints(Child child) {
        int result = 0;

        for(int i = 0; i < child.parents.length; i++) {
            if(child.parents[i].isWorking) {
                result++;
            }
        }

        if(child.disabled) result += 2;
        if(child.hasTwins) result += 1;

        for(int i = 0; i < child.siblings.length; i++) {
            if((child.school != null) && child.siblings[i].school.equals(child.school)) result += 1;
        }


        return result;
    }

    public List<Candidate> sortCandidates(Child[] children) {
        List<Candidate> candidates = new ArrayList<Candidate>();

        for(int i = 0; i < children.length; i++) {
            int points = this.evaluatePoints(children[i]);
            String name = children[i].name;
            Candidate candidate = new Candidate();
            candidate.points = points;
            candidate.name = name;

            candidates.add(candidate);
        }

        Collections.sort(candidates, new Comparator<Candidate>() {

            public int compare(Candidate o1, Candidate o2) {
                return o2.points - o1.points;
            }
        });

        return candidates;
    }
}

class Candidate {
    String name;
    int points;
}
