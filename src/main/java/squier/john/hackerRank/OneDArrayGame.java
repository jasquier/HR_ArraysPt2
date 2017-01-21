package squier.john.hackerRank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by johnsquier on 1/21/17.
 */
public class OneDArrayGame {

    public static void main(String[] args) throws FileNotFoundException {
        Path path = Paths.get("/Users/johnsquier/dev/labs/hackerRankOneDArrayPart2/src/main/java/squier/john/hackerRank/HackerRankInput3.txt");
        Path outputPath = Paths.get("/Users/johnsquier/dev/labs/hackerRankOneDArrayPart2/src/main/java/squier/john/hackerRank/HackerRankOutput.txt");
        ArrayList<String> lines = new ArrayList<>();

        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNextInt()) {

                int numTestCases = scanner.nextInt();

                for (int i = 0; i < numTestCases; i++) {

                    int arraySize = scanner.nextInt();
                    int jumpSize = scanner.nextInt();

                    // create and fill array
                    int[] array = new int[arraySize];

                    for (int j = 0; j < arraySize; j++) {
                        array[j] = scanner.nextInt();
                    }

                    int j = 0;
                    while (j < arraySize) {

                        // they're gonna try and trick you up w jumpSizes of 0 and 1
                        if (jumpSize > 1) {
                            //System.out.println("JUMP_MODE");

                            // check if you can win with a jump
                            if (j + jumpSize >= arraySize) {
                                //System.out.println("JUMP_WIN from INDEX: " + j);
                                lines.add("YES");
                                //System.out.println("YES");
                                break;
                            }
                            // see if you can jump
                            else if (array[j + jumpSize] == 0) {
                                //System.out.println("JUMP from INDEX: " + j);
                                j += jumpSize;
                            }
                            // see if you can step
                            else if (array[j + 1] == 0) {
                                //System.out.println("STEP from INDEX: " + j);
                                j++;
                            }
                            // see if you can step back and jump
                            else if ((j > 0) && (array[j + (jumpSize - 1)] == 0)) {
                                //System.out.println("STEP_BACK_&_JUMP from INDEX: " + j);
                                j += (jumpSize - 1);
                            }
                            // or else you cant progress and you lose
                            else {
                                lines.add("NO");
                                //System.out.println("NO");
                                break;
                            }
                        }
                        // jumpSize of 1 or 0, don't bother with it
                        else {
                            //System.out.println("STEP_MODE");

                            // see if you can win with a step
                            if (j + 1 >= arraySize) {
                                lines.add("YES");
                                //System.out.println("YES");
                                break;
                            }
                            // see if you can step
                            else if (array[j + 1] == 0) {
                                j++;
                            } else {
                                lines.add("NO");
                                //System.out.println("NO");
                                break;
                            }
                        }
                    }
                    Files.write(outputPath, lines);
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}


