from snake import Snake
from ladder import Ladder

class Board:

	player_pos = {}
	def __init__(self, size=10):
		self.__size = size
		Board.map_snake = {i.get_start(): i.get_end() for i in Snake.snake_instances}
		Board.map_ladder = {i.get_start(): i.get_end() for i in Ladder.ladder_instances}


	@classmethod
	def set_size(self, sz):
		self.__size = sz

	@classmethod
	def get_size(self):
		return self.__size

	@classmethod
	def list_ladder(self):
		for i in Ladder.ladder_instances:
			print(f"Ladder: {i.get_start()} -> {i.get_end()}")


	@classmethod
	def list_snake(self):
		for i in Snake.snake_instances:
			print(f"Snake: {i.get_start()} -> {i.get_end()}")


	@classmethod
	def set_player_pos(self, pname, pos):
		# if pname not in Board.player_pos:
		Board.player_pos[pname] = pos


	@classmethod
	def get_player_pos(self, pname):
		return Board.player_pos.get(pname, 0)