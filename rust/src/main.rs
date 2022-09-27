use std::collections::HashMap;

fn main() {
    assert_eq!(two_sum(vec![2, 7, 11, 15], 9), vec![0, 1]);
    assert_eq!(two_sum(vec![3, 2, 4], 6), vec![1, 2]);
    assert_eq!(two_sum(vec![3, 3], 6), vec![0, 1]);
}

/**
# Two Sum
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
*/
pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
    let mut hashmap = HashMap::<i32, usize>::with_capacity(nums.len());
    for (i, e) in nums.into_iter().enumerate() {
        match hashmap.get(&(target - e)) {
            Some(j) => {
                return vec![*j as i32, i as i32];
            }
            None => {
                hashmap.insert(e, i);
            }
        }
    }
    unreachable!()
}
