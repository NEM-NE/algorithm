package main

import (
	"bufio"
	"fmt"
	"os"
)

var (
	writer  *bufio.Writer
	nums    []int
	visited []bool
	cnt     int
	s       int
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer = bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	var n int
	fmt.Fscanln(reader, &n, &s)

	for i := 0; i < n; i++ {
		var num int
		fmt.Fscan(reader, &num)
		nums = append(nums, num)
	}

	visited = make([]bool, len(nums))
	cnt = 0
	for i, v := range nums {
		visited[i] = true
		dfs(i, v)
		visited[i] = false
	}

	fmt.Fprintln(writer, cnt)

}

func dfs(idx, sum int) {
	if sum == s {
		cnt++
	}

	for i := idx + 1; i < len(nums); i++ {
		if !visited[i] {
			visited[i] = true
			dfs(i, sum+nums[i])
			visited[i] = false
		}
	}
}
