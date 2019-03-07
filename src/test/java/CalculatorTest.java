import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class CalculatorTest {
    @Test
    public void evaluatesExpression() {
        Calculator calculator = new Calculator();
        Parent father = new Parent("Rumen", 50, true);
        Parent mother = new Parent("Rumen", 50, true);
        Parent[] parents = new Parent[]{father,mother};
        Child[] siblings = new Child[0];
        Child child = new Child("Atanas", 21, false, false, parents, siblings, null);

        int sum = calculator.evaluatePoints((child));

        assertEquals(2, sum);
    }

    @Test
    public void calculatesPointsForDisabledChild() {
        Calculator calculator = new Calculator();
        Parent father = new Parent("Rumen", 50, true);
        Parent mother = new Parent("Rumen", 50, true);
        Parent[] parents = new Parent[]{father,mother};
        Child[] siblings = new Child[0];
        Child child = new Child("Atanas", 21, true, false, parents, siblings, null);

        int sum = calculator.evaluatePoints((child));

        assertEquals(4, sum);
    }

    @Test
    public void calculatesTwinsPoints() {
        Calculator calculator = new Calculator();
        Parent father = new Parent("Rumen", 50, true);
        Parent mother = new Parent("Rumen", 50, true);
        Parent[] parents = new Parent[]{father,mother};
        Child[] siblings = new Child[0];
        Child child = new Child("Atanas", 21, true, true, parents, siblings, null);

        int sum = calculator.evaluatePoints((child));

        assertEquals(5, sum);
    }

    @Test
    public void calculatesSiblingsIncorrectly() {
        Calculator calculator = new Calculator();
        Parent father = new Parent("Rumen", 50, true);
        Parent mother = new Parent("Rumen", 50, true);
        Parent[] parents = new Parent[]{father,mother};
        Child brother = new Child("Peter", 4, false, false, parents, new Child[0], "Moon");
        Child sister = new Child("Ellen", 5, false, false, parents, new Child[0], "Star");
        Child[] siblings = new Child[0];

        Child child = new Child("Atanas", 21, true, true, parents, siblings, "Moon");

        int sum = calculator.evaluatePoints((child));

        assertNotEquals(6, sum);
    }

    @Test
    public void calculatesSiblingsCorrectly() {
        Calculator calculator = new Calculator();
        Parent father = new Parent("Rumen", 50, true);
        Parent mother = new Parent("Rumen", 50, true);
        Parent[] parents = new Parent[]{father,mother};
        Child brother = new Child("Peter", 4, false, false, parents, new Child[0], "Moon");
        Child sister = new Child("Ellen", 5, false, false, parents, new Child[0], "Star");
        Child[] siblings = new Child[]{brother, sister};

        Child child = new Child("Atanas", 21, true, true, parents, siblings, "Moon");

        int sum = calculator.evaluatePoints((child));

        assertEquals(6, sum);
    }
}