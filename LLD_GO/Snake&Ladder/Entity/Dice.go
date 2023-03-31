package Entity

import (
	"math/rand"
	"time"
)

type Dice struct {
	maxval     int
	minval     int
	currentval int
}

func InitDice(minval, maxval int) *Dice {
	rand.Seed(time.Now().UnixNano())
	return &Dice{
		maxval:     maxval,
		minval:     minval,
		currentval: 0,
	}
}

func (dice *Dice) Roll() int {
	cur := rand.Intn(dice.maxval) + 1
	dice.currentval = cur
	return cur
}
