package arrayaccess;

import java.util.Arrays;

public class Model {
    private int[][] array;

    public Model(int x, int y)
    {
        this.array = new int[x][y];
    }

    public int[][] getArray() {
        return this.array;
    }

    public Model setArray(int[][] array) {
        this.array = array;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int[] line: this.array) {
            result.append(Arrays.toString(Arrays.stream(line).mapToObj(String::valueOf).toArray(String[]::new)));
        }
        return result.toString();
    }
}
