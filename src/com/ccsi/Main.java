package com.ccsi;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        AMGraph graph=buildGraph();
        System.out.printf("numbers of vertex:%d\n",graph.getNumOfVertx());
        System.out.printf("numbers of edges:%d\n",graph.getNumOfEdegs());

        graph.deleteEdge(0,1);
        System.out.printf("numbers of vertex:%d\n",graph.getNumOfVertx());
        System.out.printf("numbers of edges:%d\n",graph.getNumOfEdegs());
    }
    public static AMGraph buildGraph(){
        int n=4,e=4;//vertexs numbers and edges numbers
        String[] labels={"V1","V2","V3","V4"};
        AMGraph graph=new AMGraph(n);
        for(String label:labels){
            graph.insertVertex(label);  //insert vertexs
        }
        //insert Edges
        graph.insertEdege(0,1,2);
        graph.insertEdege(0,2,5);
        graph.insertEdege(2,3,8);
        graph.insertEdege(3,0,7);

        return graph;
    }
}
class AMGraph{
    private ArrayList vertexList;//Vertex List
    private int[][] edges;       //store edges in matrix
    private int numOfEdegs;      //numbers of Edges

    public AMGraph(int n) {       //initiate matrix
        this.vertexList = new ArrayList(n);
        this.edges = new int[n][n];
        this.numOfEdegs = 0;
    }

    //get number of vertex
    public int getNumOfVertx(){
        return this.vertexList.size();
    }

    //get number of Edges
    public int getNumOfEdegs(){
        return this.numOfEdegs;
    }

    //get the value of vertex i
    public Object getValueByIndex(int i){
        return this.vertexList.get(i);
    }
    //get the weight of Edge(v1,v2)
    public int getWeight(int v1,int v2){
        return this.edges[v1][v2];
    }
    //insert a vertex
    public void insertVertex(Object vertex){
        vertexList.add(vertexList.size(),vertex);
    }
    //insert Edge
    public void insertEdege(int v1,int v2,int weight){
        this.edges[v1][v2]=weight;
        numOfEdegs++;
    }
    //delete Edge
    public void deleteEdge(int v1,int v2){
        this.edges[v1][v2]=0;
        numOfEdegs--;
    }
    //get the first neighbor
    public int getFirstNeighbor(int index){
        for (int i = 0; i < vertexList.size(); i++) {
            if(edges[index][i]>0)
                return i;
        }
        return -1;
    }
    //get the first neighbor base on the previous vertex
    public int getNextNeighbor(int v1,int v2){
        for (int i = v2+1; i < this.vertexList.size(); i++) {
            if(edges[v1][i]>0){
                return i;
            }
        }
        return -1;
    }
}