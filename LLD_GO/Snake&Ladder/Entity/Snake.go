package Entity

type snake struct {
	startPoint int
	endPoint   int
}

func InitSnake(startPoint, endPoint int) (sn *snake) {
	return &snake{
		startPoint: startPoint,
		endPoint:   endPoint,
	}
}
