//2). https://leetcode.com/problems/course-schedule/ 

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] deg = new int[numCourses];
        for(int[] p: prerequisites) {
            if(map.containsKey(p[1])) {
                map.get(p[1]).add(p[0]);
            }
            else {
                List<Integer> courses = new LinkedList<>();
                courses.add(p[0]);
                map.put(p[1], courses);
            }
            deg[p[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
            if(deg[i] == 0)
                queue.add(i);
        int count = 0;
        while(!queue.isEmpty()) {
            Integer node = queue.peek();
            queue.poll();
            count++;
            if(map.containsKey(node)) {
                for(Integer dependency: map.get(node)) {
                    deg[dependency]--;
                    if(deg[dependency] == 0)
                        queue.add(dependency);
                }
            }
        }
        return count == numCourses;
      }

      public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0},{0,1}};
        if(canFinish(numCourses, prerequisites))
            System.out.println("Finished Courses");
        else
            System.out.println("Unfinished Courses");
      }
}