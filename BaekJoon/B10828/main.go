package main

import (
	"bufio"
	"fmt"
	"os"
)

var (
	writer *bufio.Writer
	stack  []int
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer = bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	var v int
	fmt.Fscanln(reader, &v)

	stack = []int{}
	for i := 0; i < v; i++ {
		var op string
		var num int
		fmt.Fscanln(reader, &op, &num)
		switch op {
		case "push":
			stack = append(stack, num)
		case "top":
			if len(stack) == 0 {
				fmt.Fprintln(writer, -1)
			} else {
				fmt.Fprintln(writer, stack[len(stack)-1])
			}
		case "pop":
			if len(stack) == 0 {
				fmt.Fprintln(writer, -1)
			} else {
				tail := stack[len(stack)-1]
				stack = stack[:len(stack)-1]

				fmt.Fprintln(writer, tail)
			}

		case "size":
			fmt.Fprintln(writer, len(stack))

		case "empty":
			if len(stack) == 0 {
				fmt.Fprintln(writer, 1)
			} else {
				fmt.Fprintln(writer, 0)
			}
		default:
			fmt.Println("Not Found op")
		}
	}
}
