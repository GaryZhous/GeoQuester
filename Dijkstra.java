/* this is the pseudo-implementation of our multi-destination Dijkstra's algorithm in java. This is only for learning purpose, please do not copy it straight away as it might result in a serious academic offense!
   copyright: Gary Zhou, 2024
*/
import java.util.*;

class PathNode implements Comparable<PathNode> {
    int idx;
    double cost;

    PathNode(int idx, double cost) {
        this.idx = idx;
        this.cost = cost;
    }

    @Override
    public int compareTo(PathNode other) {
        return Double.compare(this.cost, other.cost);
    }
}

class Element {
    double travelTime;
    List<Integer> path;
    int start;
    int destination;

    Element(double travelTime, List<Integer> path, int start, int destination) {
        this.travelTime = travelTime;
        this.path = path;
        this.start = start;
        this.destination = destination;
    }
}

public class RouteFinder {

    public static List<Element> findPathsToMultipleDestinations(float turnPenalty, int start, List<Integer> destinations, int numIntersections) {
        PriorityQueue<PathNode> pq = new PriorityQueue<>();
        double[] gCost = new double[numIntersections];
        Arrays.fill(gCost, Double.POSITIVE_INFINITY);
        int[] traveledIntersections = new int[numIntersections];
        Arrays.fill(traveledIntersections, -1);

        Set<Integer> remainingDestinations = new HashSet<>(destinations);
        List<Element> paths = new ArrayList<>();

        gCost[start] = 0.0;
        pq.add(new PathNode(start, 0.0));

        while (!pq.isEmpty()) {
            PathNode currentNode = pq.poll();
            int currentIdx = currentNode.idx;

            // This function should be implemented to fetch relevant street segments
            for (Integer currentSeg : findStreetSegmentsOfIntersection(currentIdx)) {
                StreetSegmentInfo segInfo = getStreetSegmentInfo(currentSeg);
                if (segInfo.oneWay && segInfo.from != currentIdx) continue;
                
                int nextIntersection = segInfo.from == currentIdx ? segInfo.to : segInfo.from;
                double totalGCost = gCost[currentIdx] + findStreetSegmentTravelTime(currentSeg);
                
                if (traveledIntersections[currentIdx] >= 0) {
                    StreetSegmentInfo lastSegInfo = getStreetSegmentInfo(traveledIntersections[currentIdx]);
                    if (lastSegInfo.streetID != segInfo.streetID) totalGCost += turnPenalty;
                }
                
                if (totalGCost < gCost[nextIntersection]) {
                    traveledIntersections[nextIntersection] = currentSeg;
                    gCost[nextIntersection] = totalGCost;
                    pq.add(new PathNode(nextIntersection, totalGCost));
                }
            }
        }

        for (int dest : destinations) {
            List<Integer> path = new ArrayList<>();
            int u = dest;
            while (u != start) {
                int current = traveledIntersections[u];
                path.add(current);
                StreetSegmentInfo segInfo = getStreetSegmentInfo(current);
                u = segInfo.from == u ? segInfo.to : segInfo.from;
            }
            Collections.reverse(path);
            double pathTravelTime = computePathTravelTime(turnPenalty, path); // Implement this function based on your specifics
            paths.add(new Element(pathTravelTime, path, start, dest));
        }

        return paths;
    }
}
