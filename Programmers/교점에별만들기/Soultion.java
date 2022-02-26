package 교점에별만들기;

import java.util.*;

class Solution {

    static long MAX = 10000000001L;

    static class Point {
        long x, y;

        public Point(long x, long y){
            this.x = x;
            this.y = y;
        }
    }

    static class Func extends Point{
        long e;

        public Func(long x, long y, long e){
            super(x, y);
            this.e = e;
        }
    }

    public String[] solution(int[][] lines) {
        Func[] funcs = new Func[lines.length];

        for(int i = 0; i < lines.length; i++){
            funcs[i] = new Func(lines[i][0], lines[i][1], lines[i][2]);
        }

        ArrayList<Point> list = new ArrayList<Point>();
        long maxX = Integer.MIN_VALUE;
        long maxY = Integer.MIN_VALUE;
        long minX = MAX;
        long minY = MAX;
        for(int i = 0; i < lines.length; i++){
            for(int j = i + 1; j < lines.length; j++){
                long x = getX(funcs[i], funcs[j]);
                long y = getY(funcs[i], funcs[j]);

                if(x == MAX || y == MAX ) continue;

                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);

                list.add(new Point(x, y));
            }
        }

        int ySize = (int) (Math.abs(maxY-minY));
        int xSize = (int) (Math.abs(maxX-minX));
        char[][] map = new char[ySize+1][xSize+1];
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                map[i][j] = '.';
            }
        }

        for(Point point : list){
            map[(int)(point.y - minY)][(int)(point.x - minX)] = '*';
        }

        String[] answer = new String[ySize+1];
        for(int i = 0; i < answer.length; i++){
            answer[i] = new String(map[answer.length - 1 - i]);
        }

        return answer;
    }

    static long getX(Func a, Func b) {
        if(a.x * b.y == a.y * b.x) return MAX;

        double result = (double)(a.y * b.e - a.e * b.y) / (double)(a.x * b.y - a.y * b.x);
        if(result == Math.round(result)){
            return (long)result;
        }

        return MAX;
    }

    static long getY(Func a, Func b) {
        if(a.x * b.y == a.y * b.x) return MAX;

        double result = (double)(a.e * b.x - a.x * b.e) / (double)(a.x * b.y - a.y * b.x);

        if(result == Math.round(result)){
            return (long)result;
        }

        return MAX;
    }


}