from collections import deque
from players import Player
from dice import Dice
from snake import Snake
from ladder import Ladder
from board import Board

if __name__ == "__main__":

	#### config

	Ladder(2, 5)
	Ladder(1, 3)
	Ladder(22, 30)
	Ladder(11, 13)
	Ladder(20, 25)
	Ladder(7, 23)

	Snake(12, 1)
	Snake(28, 2)
	Snake(21, 18)
	Snake(15, 9)
	Snake(19, 6)

	Board(30)
	Board.set_size(30)
	print(f"Board Size is {Board.get_size()}")

	Player("kriti")
	Player("shubh")

	dice = Dice(1)

	queue = deque()
	for player in Player.player_list:
		queue.append(player)

	while(len(queue)!=0):
		cur_player = queue.popleft()


		dice_val = dice.get_rand()
		new_pos = Board.get_player_pos(cur_player) + dice_val

		if (Board.map_snake.get(new_pos,0)):
			print(f"{cur_player} got Snake bite on {new_pos} -> {Board.map_snake[new_pos]}")
			new_pos = Board.map_snake[new_pos]
		if (Board.map_ladder.get(new_pos,0)):
			print(f"{cur_player} got Ladder from {new_pos} to {Board.map_ladder[new_pos]}")
			new_pos = Board.map_ladder[new_pos]

		Board.set_player_pos(cur_player, new_pos)
		print(f"dice: {dice_val} => {cur_player} now pos is: {Board.get_player_pos(cur_player)}")

		if (Board.get_player_pos(cur_player)>=Board.get_size()):
			print(f"{cur_player} won this game")
			break

		queue.append(cur_player)