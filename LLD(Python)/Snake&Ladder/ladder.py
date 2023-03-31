class Ladder:
	ladder_instances = []
	def __init__(self, src_pos, dst_pos):
		self.__src_pos = src_pos
		self.__dst_pos = dst_pos
		Ladder.ladder_instances.append(self)

	def get_start(self):
		return self.__src_pos

	def get_end(self):
		return self.__dst_pos

	def get_coord(self):
		return (self.__src_pos, self.__dst_pos)