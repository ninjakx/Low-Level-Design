import uuid

class Player:

	num_players = 0
	player_list = []
	def __init__(self, player_name):
		self.__player_name = player_name
		self.__player_id = uuid.uuid4()
		Player.num_players += 1
		Player.player_list.append(player_name)
		print(f"Player {self.__player_name} joined the game")

	# getter for getting name
	def get_name(self):
		print(f"Player {self.__player_name} joined the game")

	def __str__(self):
		self.get_name()
		return (f"No. of player joined: {Player.num_players}")


