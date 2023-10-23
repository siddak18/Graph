import java.util.*;
public class Prims{
    static class Triplet{
        int a;
        int b;
        int c;
        Triplet(int a,int b,int c){
            this.a=a;
            this.b=b;
            this.c=c;
        }
        
    }
    
    static class TripletComparator implements Comparator<Triplet>{
        @Override
        public int compare(Triplet t1,Triplet t2){
            return Integer.compare(t1.a,t2.a);
        }
    }
    public static void main(String args[]){
        List<List<List<Integer>>>li=new ArrayList<>();
        for(int i=0;i<=6;i++){
            li.add(new ArrayList<>());
        }
        // node 1
        li.get(1).add(new ArrayList<>(Arrays.asList(4,1)));
        li.get(1).add(new ArrayList<>(Arrays.asList(5,4)));
        li.get(1).add(new ArrayList<>(Arrays.asList(2,2)));
        
        //node 2
        li.get(2).add(new ArrayList<>(Arrays.asList(3,3)));
        li.get(2).add(new ArrayList<>(Arrays.asList(4,3)));
        li.get(2).add(new ArrayList<>(Arrays.asList(1,2)));
        li.get(2).add(new ArrayList<>(Arrays.asList(6,7)));
        
        // node 3
        li.get(3).add(new ArrayList<>(Arrays.asList(2,3)));
        li.get(3).add(new ArrayList<>(Arrays.asList(4,5)));
        li.get(3).add(new ArrayList<>(Arrays.asList(6,8)));
        
        // node 4
        li.get(4).add(new ArrayList<>(Arrays.asList(5,9)));
        li.get(4).add(new ArrayList<>(Arrays.asList(3,5)));
        li.get(4).add(new ArrayList<>(Arrays.asList(2,3)));
        li.get(4).add(new ArrayList<>(Arrays.asList(1,1)));
        
        // node 5
        li.get(5).add(new ArrayList<>(Arrays.asList(4,9)));
        li.get(5).add(new ArrayList<>(Arrays.asList(1,4)));
        
        // node 6
        li.get(6).add(new ArrayList<>(Arrays.asList(3,8)));
        li.get(6).add(new ArrayList<>(Arrays.asList(2,7)));
        
        
        boolean vis[]=new boolean[7];
        PriorityQueue<Triplet>pq=new PriorityQueue<>(new TripletComparator());
        pq.add(new Triplet(0,1,-1));
        List<List<Integer>>mst=new ArrayList<>();
        int mstsum=0;
        while(!pq.isEmpty()){
            Triplet top=pq.remove();
            if(!vis[top.b]){
                mstsum+=top.a;
                if(top.c!=-1){
                    mst.add(new ArrayList<>(Arrays.asList(top.c,top.b)));
                }
                    for(int i=0;i<li.get(top.b).size();i++){
                        pq.add(new Triplet(li.get(top.b).get(i).get(1),li.get(top.b).get(i).get(0),top.b));
                        vis[top.b]=true;
                    }
            }
        }
        System.out.println(mstsum+" "+mst);
    }
}