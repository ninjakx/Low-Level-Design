package Entity

import (
	"fmt"
	"math/rand"
)

type Board struct {
	size int
	// coord for snakes
	snakes  []*snake
	ladders []*ladder
	// coord for ladders
}

func InitBoard(size, nSnakes, nLadders int) *Board {
	b := Board{
		size: size,
	}

	// we are stroring number (1->n)
	// string -> x+":"+y
	snakeLadderExist := make(map[string]bool)

	for i := 0; i < nSnakes; i++ {

		for {
			start := rand.Intn(b.GetLastPos()) + 1
			end := rand.Intn(b.GetLastPos()) + 1
			if start >= end || start == b.size {
				continue
			}
			_, ok := snakeLadderExist[fmt.Sprintf("%d:%d", start, end)]
			if !ok {
				b.snakes = append(b.snakes, InitSnake(start, end))
				snakeLadderExist[fmt.Sprintf("%d:%d", start, end)] = true
				break
			}
		}
	}
	// for _, val := range b.snakes {
	// 	fmt.Printf("--->%+v\n", val)
	// }

	for i := 0; i < nLadders; i++ {
		for {
			start := rand.Intn(b.GetLastPos()) + 1
			end := rand.Intn(b.GetLastPos()) + 1

			if start >= end || start == b.size {
				continue
			}
			_, ok := snakeLadderExist[fmt.Sprintf("%d:%d", start, end)]
			if !ok {
				b.ladders = append(b.ladders, InitLadder(start, end))
				snakeLadderExist[fmt.Sprintf("%d:%d", start, end)] = true
				break
			}
		}
	}
	return &b
}

// check if ladder is there and return the end pos
func (b *Board) isLadder(pos int) (bool, int) {
	for _, val := range b.ladders {
		if val.startPoint == pos {
			return true, val.endPoint
		}
	}
	return false, -1
}

// check if ladder is there and return the end pos
func (b *Board) isSnake(pos int) (bool, int) {
	for _, val := range b.snakes {
		if val.startPoint == pos {
			return true, val.endPoint
		}
	}
	return false, -1
}

func (b *Board) GetNewPos(pos int) int {
	if ok, finalPos := b.isLadder(pos); ok {
		fmt.Printf("Has ladder from %d to %d\n", pos, finalPos)
		return finalPos
	}
	if ok, finalPos := b.isSnake(pos); ok {
		fmt.Printf("has snake from %d to %d\n", pos, finalPos)
		return finalPos
	}
	return pos
}

func (b *Board) GetLastPos() int {
	return (b.size * b.size)
}
