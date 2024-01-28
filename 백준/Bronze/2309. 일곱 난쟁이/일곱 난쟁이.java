import java.util.*;

class Main {
    static List<Integer> dwarfs = new ArrayList<>(9);
    static List<Integer> suspectIdx = new ArrayList<>(2);
    static List<Integer> excludeSuspectIdx = new ArrayList<>(7);
    static int allSum;
    public static void main(String[] args) {
        // 입력부 작성
        Scanner sc = new Scanner(System.in);
        for (int i=0; i<9; i++) {
            dwarfs.add(Integer.parseInt(sc.nextLine().strip()));
        }
        Collections.sort(dwarfs);
        allSum = dwarfs.stream().mapToInt(Integer::intValue).sum();
        for (int i=0; i<9; i++) {
            // 총 2명을 제외 시켜야 하기 때문에
            // 혼자서도 allSum-100 보다 키가 큰 녀석은 용의선에서 제외한다.
            if (dwarfs.get(i) > allSum-100) {
                // <종료 조건 1> (short cut) 처음 나타난 i가 7인 경우 앞선 7명으로 확정
                if (excludeSuspectIdx.isEmpty() && i == 7) break;
                excludeSuspectIdx.add(i);
                continue;
            }
            // <종료 조건 2> (normal end) 1명을 제외 시킨 후 남은 키에 해당하는 인원을 찾은 경우
            int remainingSum = allSum - dwarfs.get(i);
            int targetHeight = remainingSum - 100;
            int secondIdx = dwarfs.indexOf(targetHeight);
            if (secondIdx >= 0) {
                Collections.addAll(suspectIdx, i, secondIdx);
                break;
            }
        }
        if (!suspectIdx.isEmpty()) {
            dwarfs.stream().filter(x-> !suspectIdx.contains(dwarfs.indexOf(x))).forEach(System.out::println);
        } else {
            for (int i=0; i<7; i++) System.out.println(dwarfs.get(i));
        }
    }
}
