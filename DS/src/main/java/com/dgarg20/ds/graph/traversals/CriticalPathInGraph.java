package com.dgarg20.ds.graph.traversals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Deepanshu Garg on 11/10/20.
 */

/**
 * Eg - At apth com/dgarg20/ds/graph/dfs/img_graph_1.png
 * Also Called as Tarjan's Algorithm
 * Also Known as number of strongly components in a graph
 */
public class CriticalPathInGraph {
    ArrayList<Integer>[] graph;
    List<List<Integer>> criticalConnections;
    int[] lowTimes;
    boolean[] isVisited;
    int[] nodeVisitedAtTime;
    int time;

    public CriticalPathInGraph() {
    }

    public List<List<Integer>> findCriticalPaths(List<List<Integer>> graphConnections, int numNodes) {
        graph = new ArrayList[numNodes];
        criticalConnections = new ArrayList<List<Integer>>();
        time = 0;
        isVisited = new boolean[numNodes];
        lowTimes = new int[numNodes];
        nodeVisitedAtTime = new int[numNodes];

        //Building AdjacencyList
        buildGraph(graphConnections, numNodes);
        dfs(0, -1);
        return criticalConnections;
    }

    public void dfs( int currentNode, int parent) {
        isVisited[currentNode] = true;
        nodeVisitedAtTime[currentNode] = lowTimes[currentNode] = time++;
        for(int neighbourNode: graph[currentNode]) {
            if(neighbourNode == parent) continue;
            if (!isVisited[neighbourNode]) {
                dfs(neighbourNode, currentNode);
                lowTimes[currentNode] = Math.min(lowTimes[currentNode], lowTimes[neighbourNode]);
                if(lowTimes[currentNode]< lowTimes[neighbourNode]) {
                    criticalConnections.add(Arrays.asList(currentNode, neighbourNode));
                }
            }
            else {
                lowTimes[currentNode] = Math.min(lowTimes[currentNode], nodeVisitedAtTime[neighbourNode]);
            }
        }
    }

    public void buildGraph(List<List<Integer>> graphConnections, int numNodes) {
        for(int i =0; i<numNodes; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for(List<Integer> connectionPair: graphConnections) {
            int u = connectionPair.get(0);
            int v = connectionPair.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }
    }

    @Test
    public void test1(){
        List<List<Integer>> input = Arrays.asList(Arrays.asList(0,1), Arrays.asList(1,2 ), Arrays.asList(2,0), Arrays.asList(1,3));
        List<List<Integer>> expOutput = Arrays.asList(Arrays.asList(1,3));
        CriticalPathInGraph criticalPathInGraph = new CriticalPathInGraph();
        List<List<Integer>> result = criticalPathInGraph.findCriticalPaths(input, 4);
        System.out.println(result);
        Assertions.assertEquals(1, result.size());
    }
}
