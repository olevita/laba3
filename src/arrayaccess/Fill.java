package arrayaccess;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import static arrayaccess.InputConfig.*;

public class Fill {
    public static Model fill(Model array, int method)
    {
        switch (method) {
            case KEYBOARD:
                array.setArray(fillFromKeyboard(array.getArray()));
                break;
            case FILE:
                array.setArray(fillFromFile(array.getArray()));
                break;
            case RANDOM:
            default:
                array.setArray(fillRandom(array.getArray()));
                break;
        }
        return array;
    }

    protected static int[][] fillRandom(int[][] array) {
        Random random = new Random();
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array[x].length; y++) {
                array[x][y] = random.nextInt();
            }
        }
        return array;
    }

    protected static int[][] fillFromFile(int[][] array) {
        StringBuilder data = new StringBuilder();
        try {
            File file = new File("src/numbers");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                data.append(reader.nextLine() + "\n");
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        String[] lines = data.toString().split("\n");
        for (int x = 0; x < array.length; x++) {
            String[] numbers = new String[]{};
            if (x < lines.length) {
                numbers = lines[x].split(",");
            }
            for (int y = 0; y < array[x].length; y++) {
                if (y < numbers.length) {
                    try {
                        array[x][y] = Integer.parseInt(numbers[y]);
                    } catch (NumberFormatException e) {
                        array[x][y] = 0;
                    }
                } else {
                    array[x][y] = 0;
                }
            }
        }
        return array;
    }

    protected static int[][] fillFromKeyboard(int[][] array) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input from keyboard");
        for (int x = 0; x < array.length; x++) {
            System.out.println("New line");
            for (int y = 0; y < array[x].length; y++) {
                try {
                    array[x][y] = input.nextInt();
                } catch (Exception e) {
                    array[x][y] = 0;
                }
            }
        }
        return array;
    }
}
