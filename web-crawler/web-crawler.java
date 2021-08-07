/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    public List<String> crawl(String startURL, HtmlParser htmlParser) {
        List<String> searchResults = new ArrayList<String>();
        Set<String> visitedURLs = new HashSet<String>();
        List<String> toSearch = htmlParser.getUrls(startURL);
        toSearch.add(0, startURL);
        String hostName = getHostName(startURL);
        while (!toSearch.isEmpty()) {
            // print(toSearch);
            String currentURL = toSearch.remove(0);
            // System.out.println("currentURL = " + currentURL);
            // System.out.println("visitedURLs contains " + currentURL + ": " + visitedURLs.contains(currentURL));
            if (!visitedURLs.contains(currentURL)) {
                // System.out.println("currentURL hostname: " + getHostName(currentURL) + ", hostName = " + hostName);
                if (getHostName(currentURL).equals(hostName)) {
                    searchResults.add(currentURL);
                    List<String> newURLs = htmlParser.getUrls(currentURL);
                    for (String URL : newURLs) {
                        toSearch.add(URL);
                    }
                }

                visitedURLs.add(currentURL);
            }    
        }
        
        return searchResults;
    }
    
    private String getHostName(String startURL) {
        String[] splitURL = startURL.split("/");
        return splitURL[2];
    }
    
    private void print(List<String> URLs) {
        for (String URL : URLs) {
            System.out.print(URL + " ");
        }
        
        System.out.println();
    }
    
}