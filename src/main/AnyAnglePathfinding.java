package main;
import algorithms.AStar;
import algorithms.AStarOctileHeuristic;
import algorithms.AStarStaticMemory;
import algorithms.AcceleratedAStar;
import algorithms.AdjustmentThetaStar;
import algorithms.Anya;
import algorithms.BasicThetaStar;
import algorithms.BreadthFirstSearch;
import algorithms.JumpPointSearch;
import algorithms.LazyThetaStar;
import algorithms.RecursiveThetaStar;
import algorithms.RestrictedVisibilityGraphAlgorithm;
import algorithms.StrictVisibilityGraphAlgorithm;
import algorithms.StrictVisibilityGraphAlgorithmV2;
import algorithms.VisibilityGraphAlgorithm;
import algorithms.incrementalvgs.IVGAlgorithm;
import algorithms.sparsevgs.DirectedEdgeNLevelSparseVisibilityGraphAlgorithm;
import algorithms.sparsevgs.EdgeNLevelSparseVisibilityGraphAlgorithm;
import algorithms.sparsevgs.SparseVisibilityGraphAlgorithm;
import algorithms.sparsevgs.VertexNLevelSparseVisibilityGraphAlgorithm;
import algorithms.sparsevgs.VisibilityGraphAlgorithmOptimised;
import algorithms.strictthetastar.RecursiveStrictThetaStar;
import algorithms.strictthetastar.StrictThetaStar;
import algorithms.subgoalgraphs.AnyAngleNLevelSubgoalGraphsAlgorithm;
import algorithms.subgoalgraphs.AnyAngleSubgoalGraphsAlgorithm;
import algorithms.subgoalgraphs.NLevelSubgoalGraphsAlgorithm;
import algorithms.subgoalgraphs.RecursiveStrictAnyAngleSubgoalGraphsAlgorithm;
import algorithms.subgoalgraphs.StrictAnyAngleSubgoalGraphsAlgorithm;
import algorithms.subgoalgraphs.SubgoalGraphsAlgorithm;
import algorithms.vertexanya.VertexAnya;
import algorithms.vertexanya.VertexAnyaMarking;
import algorithms.vertexanya.VertexAnyaMarkingV2;
import algorithms.vertexanya.VertexAnyaMarkingV3;
import algorithms.vertexanya.VertexAnyaNoExtents;
import algorithms.vertexanya.VisibilityScanSearchEager;
import algorithms.vertexanya.VisibilityScanSearchSemiEager;
import algorithms.visibilitygraph.BFSVisibilityGraph;
import grid.GridAndGoals;
import grid.GridGraph;
import main.graphgeneration.AutomataGenerator;
import main.graphgeneration.DefaultGenerator;
import main.graphgeneration.TiledMapGenerator;
import main.graphgeneration.UpscaledMapGenerator;
import main.mazes.StoredTestMazes;
import main.testgen.TestDataGenerator;
import uiandio.GraphImporter;

/**
 * Instructions: Look for the main method.
 * We can either run tests or trace the algorithm.
 * 
 * To see a visualisation of an algorithm,
 * 1) Set choice = 0 in the first line of main();
 * 2) Choose a maze in the first line of loadMaze();
 * 3) Choose an algorithm in the first line of setDefaultAlgoFunction();
 * 
 * The tracing / experimentation functions are detailed in the traceAlgorithm() method.
 */
public class AnyAnglePathfinding {
    public static final String PATH_TESTDATA = "testdata/";
    public static final String PATH_MAZEDATA = "mazedata/";
    public static final String PATH_ANALYSISDATA = "analysisdata/";
    private static AlgoFunction algoFunction; // The algorithm is stored in this function.

    public static void main(String[] args) {
        int choice = 0; // Choose an operation. 0: Visualisation.run() should be the default.

        switch(choice) {
            case 0:
                Visualisation.run();
                break;
            case 1:
                AlgoTest.run();
                break;
            case 2:
                Experiment.run();
                break;
            case 3:
                TestDataGenerator.run();
                break;
            case 4:
                GridGraphVisualiser.run();
                break;
            case 5:
                TextOutputVisualisation.run();
                break;
        }
    }
    
    /**
     * Choose a maze. (a gridGraph setting)
     */
    static GridAndGoals loadMaze() {
        int choice = 1; // Adjust this to choose a maze.
        
        switch(choice) {
            case 0 : {// UNSEEDED
                int unblockedRatio = 10;      // chance of spawning a cluster of blocked tiles is 1 in unblockedRatio.
                int sizeX = 20;               // x-axis size of grid
                int sizeY = 20;               // y-axis size of grid

                int sx = 10;                  // x-coordinate of start point
                int sy = 13;                  // y-coordinate of start point
                int ex = 6;                   // x-coordinate of goal point
                int ey = 8;                   // y-coordinate of goal point
                return DefaultGenerator.generateUnseeded(sizeX, sizeY, unblockedRatio, sx, sy, ex, ey);
            }
            case 1 : { // SEEDED
                int unblockedRatio = 17;      // chance of spawning a cluster of blocked tiles is 1 in unblockedRatio.
                int seed = 1667327427;        // seed for the random.
                
                int sizeX = 40;               // x-axis size of grid
                int sizeY = 40;               // y-axis size of grid
                int sx = 6;                   // x-coordinate of start point
                int sy = 10;                  // y-coordinate of start point
                int ex = 39;                  // x-coordinate of goal point
                int ey = 32;                  // y-coordinate of goal point
                return DefaultGenerator.generateSeeded(seed, sizeX, sizeY, unblockedRatio, sx, sy, ex, ey);
            }
            case 2 :
                return GraphImporter.importGraphFromFile("maze.txt", 25, 17, 2, 9);
            case 3 :
                return DefaultGenerator.generateSeededOld(-98783479, 40, 40, 7, 1, 4, 18, 18); // maze 3
            case 4 :
                return DefaultGenerator.generateSeededOld(-565315494, 15, 15, 9, 1, 2, 1, 13); // maze 2
            case 5 :
                return DefaultGenerator.generateSeededOld(53, 15, 15, 9, 0, 0, 10, 14); // maze 1
            case 6 :
                return DefaultGenerator.generateSeededOld(-159182402, 15, 15, 9, 1, 1, 13, 12); // anya previously gave incorrect path
            case 7 :
                return GraphImporter.importGraphFromFile("maze14x11.txt", 0, 0, 10, 10); // Maze to contradict Theta* / A* optimality
            case 8 :
                return GraphImporter.importGraphFromFile("mazeWCS.txt", 2, 0, 28, 25); // Worst Case Scenario path length.
            case 9 :
                return DefaultGenerator.generateSeededOld(-410889275, 15, 15, 7, 0, 1, 10, 12); // maze 4
            case 10 :
                return GraphImporter.importGraphFromFile("mazeThetaWCS.txt", 0, 0, 28, 13); // Worst Case Scenario for Theta*
            case 11 :
                return GraphImporter.importGraphFromFile("mazeReuseWCS.txt", 1, 28, 0, 27); // Worst Case Scenario for Visibility Graph reuse.
            case 12 :
                return GraphImporter.importGraphFromFile("anyaCont2.txt", 1, 6, 9, 1); // difficult case for anya
            case 13 :
                return DefaultGenerator.generateSeededOld(-1155797147, 47, 32, 38, 46, 30, 20, 1); // issue for Strict Theta*
            case 14 :
                return DefaultGenerator.generateSeededOld(-1155849806, 11, 13, 40, 7, 12, 9, 0); // Strict Theta* longer than Basic Theta*
            case 15 :
                return GraphImporter.loadStoredMaze("sc2_losttemple", "66-83_117-53");
            case 16 :
                return GraphImporter.importGraphFromFile("custommaze.txt", 1, 1, 7, 4);
            case 17 :
                return GraphImporter.importGraphFromFile("custommaze3.txt", 1, 19, 29, 2);
            case 18 :
                return GraphImporter.loadStoredMaze("baldursgate_AR0402SR", "9-45_44-22");
            case 19 :
                return DefaultGenerator.generateSeeded(-1131220420, 12, 13, 37, 5, 13, 2, 3); // Issue for Strict Theta* at goal
            case 20 :
                return GraphImporter.importGraphFromFile("custommaze4.txt", 2, 4, 10, 2);
            case 21 :
                return DefaultGenerator.generateSeededTrueRandomGraph(-1186265305, 15, 9, 12, 7,8, 4,2);
            case 22 :
                //return DefaultGenerator.generateSeededTrueRandomGraph(-1186644456, 6,5, 14, 0,2, 5,0);
                return DefaultGenerator.generateSeededTrueRandomGraph(-1185836518, 30,9, 3, 1,0, 7,9);
            case 23 :
                return DefaultGenerator.generateSeeded(138863256, 200, 200, 7, 59, 179, 160, 35); // Good large dense graph with indirect path
            case 24 :
                return DefaultGenerator.generateSeeded(138863256, 200, 200, 7, 160, 35, 59, 179); // Same graph, opposite direction
            case 25 :
                return DefaultGenerator.generateSeeded(-1878652012, 200, 200, 7, 59, 179, 160, 35); // Good large dense graph with indirect path
            case 26:
                return GraphImporter.loadStoredMaze("corr2_maze512-2-5", "171-149_313-324");
            case 27 :
                return DefaultGenerator.generateSeeded(-1270138724, 17, 16, 26, 12, 16, 8, 0); // Edge case for Incremental VG upper bound check
            case 28 :
                return DefaultGenerator.generateSeeded(250342248, 67, 33, 17, 3, 28, 47, 32); // Difficult case for Incremental VG lower bound check
            case 29 :
                return DefaultGenerator.generateSeeded(-13991511, 80, 80, 7, 26, 37, 52, 54); // Restricted VG Inefficient
            case 30:
                return GraphImporter.loadStoredMaze("def_iQCWUDHB_iED_iED_iP", "1-42_75-81");
            case 31:
                //return DefaultGenerator.generateSeeded(-1131088503, 8, 11, 27, 4, 11, 7, 4); // Strict Theta* with high buffer finds a much longer path.
                return GraphImporter.importGraphFromFile("mazehighbufferbad.txt", 4, 8, 7, 1); // Strict Theta* with high buffer finds a much longer path.
            case 32:
                return GraphImporter.loadStoredMaze("corr2_maze512-2-1", "219-187_186-334");
            case 33 :
                return GraphImporter.importGraphFromFile("anyaCont2b.txt", 9, 9, 9, 1); // difficult case for anya
            case 34:
                return DefaultGenerator.generateSeeded(47280928, 40, 40, 15, 24, 18, 0, 0); // Line of sight test 1
            case 35 :
                return GraphImporter.importGraphFromFile("lineOfSightTest.txt", 14, 18, 0, 1);// Line of sight test 2
            case 36 :
                return DefaultGenerator.generateSeeded(211, 40, 40, 10, 4, 3, 36, 36); // Maze likely to cause wrapping in taut-path algorithms.
            case 37 :
                return DefaultGenerator.generateSeeded(327116666, 40, 40, 8, 4, 3, 36, 37); // Goal unreachable. Much wrapping
            case 38 :
                return DefaultGenerator.generateSeeded(579631, 60, 60, 6, 34, 8, 37, 19); // Very roundabout path to goal.
            case 39 :
                return DefaultGenerator.generateSeeded(3350874, 20, 15, 13, 3, 3, 17, 12); // Basic Theta* suboptimal
            case 40 :
                return DefaultGenerator.generateSeeded(873637608, 9, 35, 24, 9, 28, 1, 12); // Bug in Vertex Anya due to not marking vertices as visited.
            case 41 :
                return GraphImporter.loadStoredMaze("sc2_blisteringsands", "20-93_119-84");
            case 42:
                return DefaultGenerator.generateSeeded(-387131321, 20, 17, 9, 14, 1, 15, 7); // Indirect path with lots of wrapping for Anya
            case 43:
                return DefaultGenerator.generateSeeded(-387213321, 5000, 4999, 7, 114, 4791, 4715, 17); // 5000x4999 dense map
            case 44:
                return DefaultGenerator.generateSeeded(-387213321, 2000, 1999, 7, 114, 1791, 1715, 17); // 2000x1999 dense map
            case 45:
                return GraphImporter.loadStoredMaze("wc3_gardenofwar", "378-312_74-120");
            case 46:
                return GraphImporter.loadStoredMaze("sc1_EbonLakes", "139-13_321-470");
            case 47: { // SEEDED
                int unblockedRatio = 5;          // chance of spawning a blocked tile is 1 in unblockedRatio.
                int iterations = 3;              // number of iterations for cellular automata
                int cutoffOffset = -1;           // offset for the default cutoff value used for cellular automata.  (Higher = Less blocked)
                float resolution = 1f;          // (Larger -> bigger islands)
                boolean bordersAreBlocked = false;
                int seed = -44556930;           // seed for the random.

                int sizeX = 600;               // x-axis size of grid
                int sizeY = 600;               // y-axis size of grid
                int sx = 19;                     // y-coordinate of start point
                int sy = 148;                     // x-coordinate of start point
                int ex = 203;                     // y-coordinate of goal point
                int ey = 145;                     // x-coordinate of goal point

                return AutomataGenerator.generateSeeded(seed, sizeX, sizeY, unblockedRatio, iterations, resolution, cutoffOffset, bordersAreBlocked, sx, sy, ex, ey);
            }
            case 48:
                return GraphImporter.loadStoredMaze("sc1_GreenerPastures", "210-327_722-43");
            case 49:
                return DefaultGenerator.generateSeeded(-1089290968, 50, 50, 7, 9, 6, 40, 46); // Good, mid-size indirect path map
            case 50:
                return DefaultGenerator.generateSeeded(-63381719, 19, 13, 10, 15, 1, 9, 11); // Counterexample maze that shows that you need to consider finite-level edges even after encountering skip-vertices in ENLSVGs.
            case 51:
                return AutomataGenerator.generateSeeded(-44556930, 223, 164, 5, 3, 2.4f, -1, true, 19, 148, 203, 145);
            case 52:
                return GraphImporter.importGraphFromFile("cropped.txt", 445, 2845, 1705, 77);
            case 53:
                return GraphImporter.importGraphFromFile("fatobstaclemaze.txt", 10, 10, 990, 990); // Maze with large, roughly convex obstacles
            case 54:
                return GraphImporter.importGraphFromFile("circleobstaclemaze.txt", 10, 10, 990, 990); // Maze with one large circular obstacle
            case 55:
                return GraphImporter.importGraphFromFile("threeislands.txt", 10, 10, 390, 390); // Maze with large, roughly convex obstacles
            case 56:
                return AutomataGenerator.generateSeeded(694392, 24, 20, 5, 3, 3f, 0, false, 5, 5, 19, 5); // A maze used to demo edge marking
            case 57:
                return StoredTestMazes.loadAutomataMaze(0, 7).gridAndGoals(0);
            case 58:
                return UpscaledMapGenerator.upscale(GraphImporter.loadStoredMaze("wc3_gardenofwar", "378-312_74-120"), 9, true);
            case 59:
                return TiledMapGenerator.mergeMapsDefault(new GridGraph[] {
                        GraphImporter.loadStoredMaze("wc3_gardenofwar"),
                        GraphImporter.loadStoredMaze("sc1_EbonLakes"),
                        GraphImporter.loadStoredMaze("wc3_gardenofwar"),
                        GraphImporter.loadStoredMaze("sc1_EbonLakes"),
                        GraphImporter.loadStoredMaze("wc3_gardenofwar"),
                        GraphImporter.loadStoredMaze("sc1_EbonLakes"),
                }, 3, 2);
            case 60: { // SEEDED
                float percentBlocked = 0.45f;   // chance of spawning a blocked tile is 1 in unblockedRatio.
                float resolution = 0.1f;              // (Larger -> bigger islands)
                int iterations = 5;                  // number of iterations for cellular automata
                boolean bordersAreBlocked = true;
                int seed = 5231;           // seed for the random.

                int sizeX = 3000;               // x-axis size of grid
                int sizeY = 3000;               // y-axis size of grid
                int sx = 5;                     // y-coordinate of start point
                int sy = 5;                     // x-coordinate of start point
                int ex = 19;                     // y-coordinate of goal point
                int ey = 5;                     // x-coordinate of goal point

                return AutomataGenerator.generateSeededDynamicCutoff(seed, sizeX, sizeY, percentBlocked, iterations, resolution, bordersAreBlocked, sx, sy, ex, ey);
            }
            default:
                return null;
        }
        

    }
    
    /**
     * Choose an algorithm.
     */
    static AlgoFunction setDefaultAlgoFunction() {
        int choice = 8; // adjust this to choose an algorithm
        
        switch (choice) {
            case 1 :
                algoFunction = AStar::new;
                break;
            case 2 :
                algoFunction = BreadthFirstSearch::new;
                break;
            case 3 :
                algoFunction = BreadthFirstSearch::postSmooth;
                break;
            case 4 :
                algoFunction = AStar::postSmooth;
                break;
            case 5 :
                algoFunction = AStar::dijkstra;
                break;
            case 6 :
                algoFunction = Anya::new;
                break;
            case 7 :
                algoFunction = VisibilityGraphAlgorithm::new;
                break;
            case 8 :
                algoFunction = BasicThetaStar::new;
                break;
            case 9 :
                algoFunction = BasicThetaStar::noHeuristic;
                break;
            case 10 :
                algoFunction = BasicThetaStar::postSmooth;
                break;
            case 11 :
                algoFunction = AcceleratedAStar::new;
                break;
            case 12 :
                //algoFunction = VisibilityGraphAlgorithm::graphReuse;
                algoFunction = VisibilityGraphAlgorithmOptimised::graphReuse;
                break;
            case 13 :
                algoFunction = AdjustmentThetaStar::new;
                break;
            case 14 :
                algoFunction = StrictThetaStar::new;
                break;
            case 15 :
                algoFunction = RecursiveStrictThetaStar::new;
                break;
            case 16 :
                algoFunction = BFSVisibilityGraph::graphReuse;
                break;
            case 17 :
                algoFunction = RestrictedVisibilityGraphAlgorithm::new;
                break;
            case 18 :
                algoFunction = StrictVisibilityGraphAlgorithm::new;
                break;
            case 19 :
                algoFunction = LazyThetaStar::new;
                break;
            case 20 :
                algoFunction = AStarOctileHeuristic::new;
                break;
            case 21 :
                algoFunction = AStarOctileHeuristic::postSmooth;
                break;
            case 22 :
                algoFunction = JumpPointSearch::new;
                break;
            case 23 :
                algoFunction = JumpPointSearch::postSmooth;
                break;
            case 24 :
                algoFunction = AStarStaticMemory::new;
                break;
            case 25 :
                algoFunction = StrictVisibilityGraphAlgorithmV2::new;
                break;
            case 26 :
                algoFunction = RecursiveThetaStar::new;
                break;
            case 27 :
                algoFunction = SparseVisibilityGraphAlgorithm::graphReuse;
                break;
            case 28 :
                algoFunction = IVGAlgorithm::new;
                break;
            case 29 :
                algoFunction = VertexAnya::new;
                break;
            case 30 :
                algoFunction = VertexAnyaNoExtents::new;
                break;
            case 31 :
                algoFunction = VisibilityScanSearchEager::new;
                break;
            case 32 :
                algoFunction = VisibilityScanSearchSemiEager::new;
                break;
            case 33 :
                algoFunction = VertexAnyaMarking::new;
                break;
            case 34 :
                algoFunction = VertexAnyaMarkingV2::new;
                break;
            case 35 :
                algoFunction = VertexAnyaMarkingV3::new;
                break;
            case 36 :
                algoFunction = SubgoalGraphsAlgorithm::new;
                break;
            case 37 :
                algoFunction = NLevelSubgoalGraphsAlgorithm::new;
                break;
            case 38 :
                algoFunction = AnyAngleSubgoalGraphsAlgorithm::new;
                break;
            case 39 :
                algoFunction = AnyAngleNLevelSubgoalGraphsAlgorithm::new;
                break;
            case 40 :
                algoFunction = StrictAnyAngleSubgoalGraphsAlgorithm::new;
                break;
            case 41 :
                algoFunction = RecursiveStrictAnyAngleSubgoalGraphsAlgorithm::new;
                break;
            case 42 :
                algoFunction = VertexNLevelSparseVisibilityGraphAlgorithm::graphReuse;
                break;
            case 43 :
                algoFunction = EdgeNLevelSparseVisibilityGraphAlgorithm::graphReuse;
                break;
            case 44 :
                algoFunction = EdgeNLevelSparseVisibilityGraphAlgorithm.withLevelLimit(1);
                break;
            case 45 :
                algoFunction = DirectedEdgeNLevelSparseVisibilityGraphAlgorithm::graphReuse;
                break;
        }
        
        return algoFunction;
    }
}
