package additional;

/**
 * Created by rtsy on 17.07.2015.
 */
public class Apple {
    int weight;
    appleColors color;
    public enum appleColors {
        GREEN(1), RED(3), YELLOW(2);
        int colorID;

        appleColors(int i) {
            colorID = i;
        }

    }

    public Apple(int weight, appleColors color) {
        this.weight = weight;
        this.color = color;
    }

    public int getColorID() {
        return color.colorID;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public appleColors getColor() {
        return color;
    }

    public void setColor(appleColors color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color=" + color +
                '}';
    }
}