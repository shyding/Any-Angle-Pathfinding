package algorithms;

import algorithms.priorityqueue.IndirectHeap;
import grid.GridGraph;



public class AStar extends PathFindingAlgorithm {

    protected boolean postSmoothingOn = false;
    protected float heuristicWeight = 1f;

    protected Float[] distance;
    protected boolean[] visited;
    
    protected IndirectHeap<Float> pq; 

    protected int finish;

    
    public AStar(GridGraph graph, int sx, int sy, int ex, int ey) {
        super(graph, graph.sizeX, graph.sizeY, sx, sy, ex, ey);
    }

    public static AStar postSmooth(GridGraph graph, int sx, int sy, int ex, int ey) {
        AStar aStar = new AStar(graph, sx, sy, ex, ey);
        aStar.postSmoothingOn = true;
        return aStar;
    }

    public static AStar dijkstra(GridGraph graph, int sx, int sy, int ex, int ey) {
        AStar aStar = new AStar(graph, sx, sy, ex, ey);
        aStar.heuristicWeight = 0;
        return aStar;
    }
    
    @Override
    public void computePath() {
        int totalSize = (graph.sizeX+1) * (graph.sizeY+1);

        int start = toOneDimIndex(sx, sy);
        finish = toOneDimIndex(ex, ey);
        
        distance = new Float[totalSize];
        parent = new int[totalSize];
        
        initialise(start);
        visited = new boolean[totalSize];
        
        pq = new IndirectHeap<Float>(distance, true);
        pq.heapify();
        
        while (!pq.isEmpty()) {
            int current = pq.popMinIndex();
            if (current == finish || distance[current] == Float.POSITIVE_INFINITY) {
                maybeSaveSearchSnapshot();
                break;
            }
            visited[current] = true;

            int x = toTwoDimX(current);
            int y = toTwoDimY(current);

            tryRelax(current, x, y, x-1, y-1);
            tryRelax(current, x, y, x, y-1);
            tryRelax(current, x, y, x+1, y-1);
            
            tryRelax(current, x, y, x-1, y);
            tryRelax(current, x, y, x+1, y);
            
            tryRelax(current, x, y, x-1, y+1);
            tryRelax(current, x, y, x, y+1);
            tryRelax(current, x, y, x+1, y+1);

            maybeSaveSearchSnapshot();
        }
        
        maybePostSmooth();
    }
    
    private void tryRelax(int current, int currentX, int currentY, int x, int y) {
        if (!graph.isValidCoordinate(x, y))
            return;
        
        int destination = toOneDimIndex(x,y);
        if (visited[destination])
            return;
        if (parent[current] != -1 && parent[current] == parent[destination]) // OPTIMISATION: [TI]
            return; // Idea: don't bother trying to relax if parents are equal. using triangle inequality.
        if (!graph.lineOfSight(currentX, currentY, x, y))
            return;
        
        if (relax(current, destination, weight(currentX, currentY, x, y))) {
            // If relaxation is done.
            pq.decreaseKey(destination, distance[destination] + heuristic(x,y));
        }
    }

    protected float heuristic(int x, int y) {
        //return 0;
        return heuristicWeight*graph.distance(x, y, ex, ey);
    }


    protected float weight(int x1, int y1, int x2, int y2) {
        return graph.distance(x1, y1, x2, y2);
    }
    

    public Float[] getDistance(){return distance;}
    public int[] getParent(){return parent;}
    
    
    protected boolean relax(int u, int v, float weightUV) {
        // return true iff relaxation is done.
        
        float newWeight = distance[u] + weightUV;
        if (newWeight < distance[v]) {
            distance[v] = newWeight;
            parent[v] = u;
            maybeSaveSearchSnapshot();
            return true;
        }
        return false;
    }
    
    
    protected final void initialise(int s) {
        for (int i=0; i<distance.length; i++) {
            distance[i] = Float.POSITIVE_INFINITY;
            parent[i] = -1;
        }
        distance[s] = 0f;
    }
    
    private int pathLength() {
        int length = 0;
        int current = finish;
        while (current != -1) {
            current = parent[current];
            length++;
        }
        return length;
    }
    
    protected boolean lineOfSight(int node1, int node2) {
        int x1 = toTwoDimX(node1);
        int y1 = toTwoDimY(node1);
        int x2 = toTwoDimX(node2);
        int y2 = toTwoDimY(node2);
        return graph.lineOfSight(x1, y1, x2, y2);
    }

    protected float physicalDistance(int node1, int node2) {
        int x1 = toTwoDimX(node1);
        int y1 = toTwoDimY(node1);
        int x2 = toTwoDimX(node2);
        int y2 = toTwoDimY(node2);
        return graph.distance(x1, y1, x2, y2);
    }
    
    protected void maybePostSmooth() {
        if (postSmoothingOn) {
            postSmooth();
        }
    }
    
    private void postSmooth() {

        int current = finish;
        while (current != -1) {
            int next = parent[current]; // we can skip checking this one as it always has LoS to current.
            if (next != -1) {
                next = parent[next];
                while (next != -1) {
                    if (lineOfSight(current,next)) {
                        parent[current] = next;
                        next = parent[next];
                        maybeSaveSearchSnapshot();
                    } else {
                        next = -1;
                    }
                }
            }
            
            current = parent[current];
        }
    }
    

    public int[][] getPath() {
        int length = pathLength();
        int[][] path = new int[length][];
        int current = finish;
        
        int index = length-1;
        while (current != -1) {
            int x = toTwoDimX(current);
            int y = toTwoDimY(current);
            
            path[index] = new int[2];
            path[index][0] = x;
            path[index][1] = y;
            
            index--;
            current = parent[current];
        }
        
        return path;
    }
    
    @Override
    protected boolean selected(int index) {
        return visited[index];
    }
}