class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> startPoints = new HashSet<String>();
        Set<String> allCities = new HashSet<String>();
        for (List<String> path : paths) {
            startPoints.add(path.get(0));
            for (String city : path) {
                allCities.add(city);
            }
        }
        
        for (String city : allCities) {
            if (!startPoints.contains(city)) {
                return city;
            }
        }
        
        return "";
    }
}