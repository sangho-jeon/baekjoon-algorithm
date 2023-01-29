    package Toss.programmersLockAndKey;

    import java.security.Key;
    import java.util.ArrayList;
    import java.util.Arrays;

    public class Main {
        public static void main(String[] args) {
            int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
            int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
            System.out.println(solution(key, lock));
        }

        static ArrayList<KeyChain> keys;
        static ArrayList<KeyChain> holes;
        static int N, M;

        public static boolean solution(int[][] key, int[][] lock) {
            boolean answer = false;
            N = key.length;
            M = lock.length;
            holes = new ArrayList<>();
            keys = new ArrayList<>();
            int holecount = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    if (lock[i][j] == 0) {
                        KeyChain hole = new KeyChain(i + N, j + N);
                        holes.add(hole);
                        holecount++;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (key[i][j] == 1) {
                        KeyChain keyhole = new KeyChain(i, j);
                        keys.add(keyhole);
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                keys = rotate(keys);
                for (int j = 0; j < N + M; j++) {
                    for (int k = 0; k < N + M; k++) {
                        int count = 0;
                        ArrayList<KeyChain> movedChain = move(j, k, keys);
                        for (KeyChain p:
                             movedChain) {
                            for (KeyChain q:
                                 holes) {
                                if(p.x == q.x && p.y == q.y){
                                    count++;
                                }
                            }
                        }
                        if(count == holecount)
                            return true;
                    }
                }

            }

            return answer;
        }
        public static ArrayList<KeyChain> move(int i, int j, ArrayList<KeyChain> keys){
            ArrayList<KeyChain> re = new ArrayList<>();
            for (KeyChain k:
                 keys) {
                re.add(new KeyChain(k.x+i, k.y+j));
            }
            return re;
        }

        public static ArrayList<KeyChain> rotate(ArrayList<KeyChain> key) {
            ArrayList<KeyChain> rotatedKeys = new ArrayList<>();
            for (KeyChain k :
                    key) {
                KeyChain r = new KeyChain(k.y, N - 1 - k.x);
                rotatedKeys.add(r);
            }
            return rotatedKeys;

        }

        public static class KeyChain {
            int x;
            int y;

            public KeyChain(int x, int y) {
                this.x = x;
                this.y = y;
            }
            public void out(){
                System.out.println(x);
                System.out.println(y);
            }

        }

    }


