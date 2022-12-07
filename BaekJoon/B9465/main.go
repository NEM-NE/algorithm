package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
)

var (
	writer *bufio.Writer
	reader *bufio.Scanner
	dp     [][]int
)

func main() {
	reader = bufio.NewScanner(os.Stdin)
	writer = bufio.NewWriter(os.Stdout)
	defer writer.Flush()
	reader.Split(bufio.ScanWords)

	loopCnt := nextInt()

	for i := 0; i < loopCnt; i++ {
		size := nextInt()
		list := getAry(size)

		cal(list)

		result := 0
		for j := 0; j < len(dp[0]); j++ {
			result = int(math.Max(float64(result), float64(dp[0][j])))
			result = int(math.Max(float64(result), float64(dp[1][j])))
		}

		fmt.Fprintln(writer, result)
	}

}

func nextInt() int {
	reader.Scan()
	num, _ := strconv.Atoi(reader.Text())
	return num
}

func cal(list [][]int) {
	if len(list[0]) == 1 {
		dp[0][0] = list[0][0]
		dp[1][0] = list[1][0]
	} else if len(list[0]) == 2 {
		dp[0][0] = list[0][0]
		dp[0][1] = list[0][1] + list[1][0]
		dp[1][0] = list[1][0]
		dp[1][1] = list[1][1] + list[0][0]
	} else {
		dp[0][0] = list[0][0]
		dp[0][1] = list[0][1] + list[1][0]
		dp[1][0] = list[1][0]
		dp[1][1] = list[1][1] + list[0][0]

		for i := 2; i < len(list[0]); i++ {
			dp[0][i] = list[0][i] + int(math.Max(float64(dp[1][i-1]), float64(dp[1][i-2])))
			dp[1][i] = list[1][i] + int(math.Max(float64(dp[0][i-1]), float64(dp[0][i-2])))
		}
	}
}

func getAry(size int) [][]int {
	list := make([][]int, 2)
	dp = make([][]int, 2)

	for i := 0; i < 2; i++ {
		dp[i] = make([]int, size)
		list[i] = make([]int, size)
		for j := 0; j < size; j++ {
			test := nextInt()
			list[i][j] = test
		}
	}
	return list
}
