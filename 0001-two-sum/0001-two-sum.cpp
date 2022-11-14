class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int, int> diffToIndex;
        for (int i = 0; i < nums.size(); i++) {
            int complement = target - nums[i];
            if (diffToIndex.count(complement)) {
                return {diffToIndex[complement], i};
            }
            
            diffToIndex[nums[i]] = i;
        }
        
        return {};
    }
};