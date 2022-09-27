use std::collections::HashMap;

fn main() {
    assert_eq!(two_sum(vec![2, 7, 11, 15], 9), vec![0, 1]);
    assert_eq!(two_sum(vec![3, 2, 4], 6), vec![1, 2]);
    assert_eq!(two_sum(vec![3, 3], 6), vec![0, 1]);
}

pub fn two_sum_(nums: Vec<i32>, target: i32) -> Vec<i32> {
    let mut i = 0;
    loop {
        let a = &nums[i];
        for (j, b) in nums.iter().enumerate().skip(i + 1) {
            if a + b == target {
                return vec![i as i32, j as i32];
            }
        }
        i += 1;
    }
}

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

pub fn two_sum2(nums: Vec<i32>, target: i32) -> Vec<i32> {
    let len_ns = nums.len();
    let mut num_to_idx: HashMap<i32, usize> = HashMap::with_capacity(len_ns);
    for (idx, num) in nums.into_iter().enumerate() {
        let expected_sum = target - num;
        match num_to_idx.get(&expected_sum) {
            Some(&prev_idx) => {
                return vec![prev_idx as i32, idx as i32];
            }
            None => {
                num_to_idx.insert(num, idx);
            }
        }
    }
    unreachable!()
}
