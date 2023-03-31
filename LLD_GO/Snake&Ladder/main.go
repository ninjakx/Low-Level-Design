package main

import engine "main/Service"

func main() {
	gameEngine := engine.InitEngine(15, 10, 10)
	gameEngine.AddPlayer("kriti")
	gameEngine.AddPlayer("lily")
	gameEngine.Play()
}
