package Entity

type ladder struct {
	startPoint int
	endPoint   int
}

func InitLadder(startPoint, endPoint int) *ladder {
	return &ladder{
		startPoint: startPoint,
		endPoint:   endPoint,
	}
}
