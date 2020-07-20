package stackQueues;

import java.util.Stack;

class FindCelebChallenge {

    public static int findCelebrity(int[][] party, int numPeople) {
        int celebCandidate = -1;

        for (int i = 0; i < numPeople; i++) {
            boolean flag = true;
            for (int j = 0; j < numPeople; j++) {
                if (party[i][j] == 1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                celebCandidate = i;
                break;
            }
        }

        if (celebCandidate == -1) {
            return celebCandidate;
        }

        for (int i = 0; i < numPeople; i++) {
            if (i == celebCandidate) {
                continue;
            }
            if (party[i][celebCandidate] == 0) {
                return -1;
            }
        }
        return celebCandidate;
    }

    public static int findCelebrityStack(int[][] party, int numPeople) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numPeople; i++) {
            stack.push(i);
        }

        if (stack.size() == 1 || stack.empty()) {
            return -1;
        }

        while (stack.size() > 1) {
            int x = stack.pop();
            int y = stack.pop();

            if (personKnows(x, y, party)) {
                stack.push(y);
            } else {
                stack.push(x);
            }
        }

        int celebCandidate = stack.pop();

        for (int i = 0; i < numPeople; i++) {
            if (i != celebCandidate &&
                (personKnows(celebCandidate, i, party) || !personKnows(i, celebCandidate, party))) {
                return -1;
            }
        }

        return celebCandidate;
    }

    private static boolean personKnows(int p1, int p2, int[][] party) {
        return party[p1][p2] == 1;
    }

    public static void main(String[] args) {

        int[][] party1 = {
            {0, 1, 1, 0},
            {1, 0, 1, 1},
            {0, 0, 0, 0},
            {0, 1, 1, 0},
        };

        int[][] party2 = {
            {0, 1, 1, 0},
            {1, 0, 1, 1},
            {0, 0, 0, 1},
            {0, 1, 1, 0},
        };

        int[][] party3 = {
            {0, 0, 0, 0},
            {1, 0, 0, 1},
            {1, 0, 0, 1},
            {1, 1, 1, 0},
        };

        System.out.println(findCelebrityStack(party1, 4));
        System.out.println(findCelebrityStack(party2, 4));
        System.out.println(findCelebrityStack(party3, 4));
    }
}
