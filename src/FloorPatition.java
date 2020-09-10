import java.util.ArrayList;
import java.util.List;

public class FloorPatition {

    public static void main(String[] args) {

        int rows = 4;
        int cols = 4;

        //Some 4x4 Array Data Input. Can test by adding or removing comment one by one.
        //int[][] floor = {{1, 0, 0, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 1}};
        int[][] floor = {{1, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 1}};
        //int[][] floor = {{0, 1, 1, 0}, {0, 0, 1, 1}, {1, 1, 0, 0}, {0, 0, 1, 0}};
        //int[][] floor = {{1, 0, 1, 0}, {0, 0, 1, 1}, {1, 1, 0, 0}, {0, 0, 1, 0}};
        //int[][] floor = {{1, 1, 0, 0}, {1, 0, 1, 0}, {0, 1, 0, 1}, {0, 0, 1, 0}};


        int partition = 0;
        List<String> alreadyPartition = new ArrayList<>();
        List<String> allPartition = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (floor[i][j] == 1)
                    allPartition.add(i + "," + j);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (floor[i][j] == 1) {
                    boolean isSame = false;
                    List<String> neighbour = getNeighborsOfIndex(i, j, rows, cols);
                    for (String arrayIndex : neighbour) {
                        if (alreadyPartition.contains(arrayIndex)) {
                            isSame = true;
                        }
                        if (allPartition.contains(arrayIndex)) {
                            alreadyPartition.add(arrayIndex);
                        }
                    }
                    if (!isSame) {
                        partition++;
                        System.out.println("floor[" + i + "," + j + "]===1, so +1 partition");
                        alreadyPartition.add(i + "," + j);
                    } else {
                        alreadyPartition.add(i + "," + j);
                    }

                }
            }
        }

        System.out.println("Partition = " + partition);

    }


    private static List<String> getNeighborsOfIndex(int row, int col, int rowCount, int colCounts) {
        List<String> neighbors = new ArrayList<>();
        for (int xx = -1; xx <= 1; xx++) {
            for (int yy = -1; yy <= 1; yy++) {
                if (xx == 0 && yy == 0) {
                    continue;
                }
                if (Math.abs(xx) + Math.abs(yy) > 1) {
                    continue;
                }
                if (isExistInArray(row + xx, col + yy, rowCount, colCounts)) {
                    neighbors.add((row + xx)+","+(col + yy));
                }
            }
        }
        return neighbors;
    }

    public static boolean isExistInArray(int x, int y, int rows, int cols) {
        return x >= 0 && y >= 0 && x < cols && y < rows;
    }
}
