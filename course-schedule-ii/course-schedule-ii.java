class Solution {
    public int[] findOrder(int numCourses, int[][] prereqs) {
        Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
        int[] indegree = new int[numCourses];
        int[] topological = new int[numCourses];
        
        // create adjacency list of courses
        for (int i = 0; i < prereqs.length; i++) {
            int destination = prereqs[i][0];
            int source = prereqs[i][1];
            if (!adjList.containsKey(source)) {
                adjList.put(source, new ArrayList<Integer>());
            }
            
            adjList.get(source).add(destination);
            indegree[destination]++;
        }
        
        Queue<Integer> withoutPrereq = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                withoutPrereq.add(i);
            }
        }
        
        int index = 0;
        while (!withoutPrereq.isEmpty()) {
            int course = withoutPrereq.remove();
            topological[index] = course;
            index++;
            if (adjList.containsKey(course)) {
                for (Integer neighbor : adjList.get(course)) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0) {
                        withoutPrereq.add(neighbor);
                    }
                }
            }
        }
        
        if (index == numCourses) {
            return topological;
        }
        
        return new int[0];
    }
    
    private void printArray(int[] list) {
        System.out.print("array: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        
        System.out.println();
    }

}
