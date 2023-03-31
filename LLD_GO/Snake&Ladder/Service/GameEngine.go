package Service

import (
	"fmt"
	"main/Entity"
)

type engine struct {
	board   *Entity.Board
	dice    *Entity.Dice
	players []*Entity.Player
}

func InitEngine(nSnakes, nLadders, size int) *engine {
	return &engine{
		board:   Entity.InitBoard(size, nSnakes, nLadders),
		dice:    Entity.InitDice(1, 6),
		players: []*Entity.Player{
			// Entity.InitPlayer("kriti"),
			// Entity.InitPlayer("lily"),
		},
	}
}

func (engine *engine) AddPlayer(name string) {
	p := Entity.InitPlayer(name)
	engine.players = append(engine.players, p)
}

func (engine *engine) Play() {
	if len(engine.players) == 0 {
		fmt.Printf("No player has joined the game")
	}

	// queue := list.New()
	// for _, pl := range engine.players {
	// 	queue.PushBack(pl)
	// }
	totalMoves := 0
	for {
		totalMoves++
		// curPlayer := queue.Front()
		// curPVal := curPlayer.Value
		// queue.Remove(curPlayer)
		// queue.PushBack(curPlayer)

		curPVal := engine.players[0]

		temp := engine.players[1:]
		temp = append(temp, curPVal)
		engine.players = temp

		roll := engine.dice.Roll()

		newpos := curPVal.PlayerCurPos() + roll
		finalPos := engine.board.GetNewPos(newpos)
		curPVal.SetPlayerPos(finalPos)

		if finalPos < engine.board.GetLastPos() {
			fmt.Printf("Player: %s, diceRoll: %d\n", curPVal.GetPlayerName(), roll)
			curPVal.PlayerCurInfo()
			continue
		}
		curPVal.PlayerCurInfo()
		curPVal.SetPlayerStatus(true)
		fmt.Printf("Total no of moves: %d\n", totalMoves)
		fmt.Printf("Player %s has won the game\n", curPVal.GetPlayerName())
		break
	}
	return
}
