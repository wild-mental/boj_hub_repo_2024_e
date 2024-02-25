import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int minChanges = 2500;
        String bw = "BW".repeat(4);
        String wb = "WB".repeat(4);
        String bwBoard = (bw+wb).repeat(4);
        String wbBoard = (wb+bw).repeat(4);
        // System.out.println(bwBoard);
        // System.out.println(wbBoard);
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\s");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        List<String> board = new ArrayList<>(rows);
        for (int i = 0; i < rows; i++) {
            board.add(sc.nextLine());
        }
        for (int i = 0; i < rows-7; i++) {
            for (int j = 0; j < cols-7; j++) {
//                System.out.printf("i: %s, j: %s", i, j);
                StringBuilder newBoard = new StringBuilder();
                for (int k = 0; k < 8; k++) {

                    newBoard.append(board.get(i+k), j, j+8);
                }
//                System.out.println(newBoard);
                int idx = 0;
                int changesBW = 0;
                int changesWB = 0;
                for (char c : newBoard.toString().toCharArray()) {
                    if (c != bwBoard.charAt(idx)) {
                        changesBW+=1;
                    }
                    if (c != wbBoard.charAt(idx)) {
                        changesWB+=1;
                    }
                    idx++;
                }
                // ShortCut
                if (changesBW == 0 || changesWB == 0) {
                    System.out.println(0);
                    return;
                }
                int smallerChanges = Math.min(changesBW, changesWB);
                if (smallerChanges<minChanges) {
                    minChanges = smallerChanges;
                }
            }
        }
        System.out.println(minChanges);
    }
}
