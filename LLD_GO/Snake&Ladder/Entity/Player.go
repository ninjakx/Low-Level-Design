package Entity

import "fmt"

type Player struct {
	name       string
	curPos     int
	gameStatus bool // win or not
}

// create player
func InitPlayer(name string) *Player {
	return &Player{
		name:       name,
		curPos:     0,
		gameStatus: false,
	}
}
func (p *Player) GetPlayerName() string {
	return p.name
}
func (p *Player) PlayerCurInfo() {
	fmt.Printf("Player %s current pos: %d\n", p.name, p.curPos)
}
func (p *Player) PlayerCurPos() int {
	return p.curPos
}
func (p *Player) SetPlayerStatus(fl bool) {
	p.gameStatus = fl
}
func (p *Player) SetPlayerPos(pos int) {
	p.curPos = pos
}
