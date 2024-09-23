package binary_trees;

import java.util.*;


public class FindAllNodesAtDistanceK {
    public static ArrayList<Integer> KDistanceNodes(Node root, int target, int k) {
        Map<Node, Node> parentMap = new HashMap<>();
        Node targetNode = mapParents(root, parentMap, target);
        return getNodes(parentMap, targetNode, k);
    }

    public static ArrayList<Integer> getNodes(Map<Node, Node> parentMap, Node target, int k) {
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> nodes = new ArrayList<>();
        Set<Integer> vis = new HashSet<>();
        int dist = -1;

        q.add(target);
        vis.add(target.data);
        while (!q.isEmpty()) {
            int size = q.size();
            nodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node front = q.poll();
                nodes.add(front.data);
                if (front.left != null && !vis.contains(front.left.data)) {
                    q.add(front.left);
                    vis.add(front.left.data);
                }
                if (front.right != null && !vis.contains(front.right.data)) {
                    q.add(front.right);
                    vis.add(front.right.data);
                }
                Node parentNode = parentMap.get(front);
                if (parentNode != null && !vis.contains(parentNode.data)) {
                    q.add(parentNode);
                    vis.add(parentNode.data);
                }
            }
            dist++;
            if (dist == k) {
                break;
            }
        }
        Collections.sort(nodes);
        return nodes;
    }

    public static Node mapParents(Node root, Map<Node, Node> parentMap, int target) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node targetNode = new Node(-1);
        while (!q.isEmpty()) {
            Node front = q.poll();
            if (front.data == target) {
                targetNode = front;
            }
            if (front.left != null) {
                parentMap.put(front.left, front);
                q.add(front.left);
            }
            if (front.right != null) {
                parentMap.put(front.right, front);
                q.add(front.right);
            }
        }
        return targetNode;
    }
}
