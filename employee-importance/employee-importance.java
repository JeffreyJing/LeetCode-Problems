/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Queue<Employee> toAdd = new LinkedList<Employee>();
        Map<Integer, Employee> idToPerson = new HashMap<Integer, Employee>();
        for (Employee person : employees) {
            if (person.id == id) {
                toAdd.add(person);
            }
            
            idToPerson.put(person.id, person);
        }
        
        int totalImportance = 0;
        while (!toAdd.isEmpty()) {
            Employee current = toAdd.remove();
            for (Integer subordinate : current.subordinates) {
                toAdd.add(idToPerson.get(subordinate));
            }
            
            totalImportance += current.importance;
        }
        
        return totalImportance;
    }
    
    
}