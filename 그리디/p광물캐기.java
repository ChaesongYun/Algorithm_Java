import java.util.*;

class Solution{
    static class Mineral{
        private int diamond;
        private int iron;
        private int stone;
        
        public Mineral(int diamond, int iron, int stone){
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }
    }
    
    public int solution(int[] picks, String[] minerals){
        int[][] scoreBoard = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        int totalPicks = Arrays.stream(picks).sum();
        List<Mineral> list = new ArrayList<>();
        
        for(int i = 0; i < minerals.length; i+=5){
            if(totalPicks == 0) break;
            int dia = 0, iron = 0, stone = 0;
            for(int j = i; j < i+5; j++){
                if(j == minerals.length) break;
                
                String mineral = minerals[j];
                int idx = mineral.equals("diamond")? 0 : 
                mineral.equals("iron")? 1 : 2;
                
                dia += scoreBoard[0][idx];
                iron += scoreBoard[1][idx];
                stone += scoreBoard[2][idx];
            }
            list.add(new Mineral(dia, iron, stone));
            totalPicks--;
        }
        Collections.sort(list, (o1, o2)-> (o2.stone-o1.stone));
        int answer = 0;
        for(Mineral m: list){
            int dia = m.diamond;
            int iron = m.iron;
            int stone = m.stone;
            if(picks[0] > 0){
                answer += dia;
                picks[0]--;
                continue;
            }
            if(picks[1] > 0){
                answer += iron;
                picks[1]--;
                continue;
            }
            if(picks[2] > 0){
                answer += stone;
                picks[2]--;
                continue;
            }
        }
        return answer;
    }
}
