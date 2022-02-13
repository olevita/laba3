package arrayaccess;

import java.util.Arrays;

public class Sort {
    public static Model sort(Model object) {
        int[][] array = object.getArray();
        for (int[] lines : array) {
            Arrays.sort(lines);
        }
        return object.setArray(array);
    }
}
