import random

class Dice:
	def __init__(self, num_dice):
		self.num_dice = num_dice

	def get_rand(self):
		return random.randint(1,6*self.num_dice)