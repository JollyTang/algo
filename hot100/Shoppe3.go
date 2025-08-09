package main

import (
	"fmt"
	"sort"
)
 
/**
 * Note: 类名、方法名、参数名已经指定，请勿修改
 *
 * 
 * 
 * @param gifts int整型 一维数组 
 * @param money int整型  
 * @return int整型
*/
func number_of_gifts(gifts []int, money int) int {
    // write code here
	fmt.Println(gifts,money)
    if len(gifts) == 0 {
        if money == 0 {
            return 0
        }
        return -1
    }
    
    if money == 0 {
        return 0
    }
    
    // 排序礼物价格
    sort.Ints(gifts)
    
    // 如果最小的礼物价格都大于money，直接返回-1
    if gifts[0] > money {
        return -1
    }
    
    // 使用切片来传递result，确保在递归中能正确更新
    result := []int{-1}
    
    dfs(gifts, money, 0, []int{}, 0, result)
    return result[0]
}

func dfs(gifts []int, money int, index int, path []int, sum int, result []int) {
    if sum > money {
        return
    }
    
    if sum == money {
        if len(path) > result[0] {
            result[0] = len(path)
        }
        return
    }
    
    for i := index; i < len(gifts); i++ {
        // 剪枝：如果当前sum加上当前礼物价格已经超过money，直接跳过
        if sum+gifts[i] > money {
            break
        }
        
        // 添加当前礼物
        path = append(path, gifts[i])
        sum += gifts[i]
        
        // 递归搜索
        dfs(gifts, money, i+1, path, sum, result)
        
        // 回溯
        sum -= gifts[i]
        path = path[:len(path)-1]
    }
}