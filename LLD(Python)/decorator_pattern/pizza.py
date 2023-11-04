from VegDelightPizzaBase import VegDelightPizzaBase
from FarmHousePizzaBase import FarmHousePizzaBase 
from ExtraCheeseTopping import ExtraCheeseTopping
from MushroomTopping import MushroomTopping

if __name__ == "__main__":
    farmhouse = FarmHousePizzaBase()
    print(farmhouse._getPrice())

    print("===========")
    print(ExtraCheeseTopping(farmhouse))
    print(MushroomTopping(farmhouse))
    print("===========")

    print(ExtraCheeseTopping(farmhouse)._getPrice())
    print(MushroomTopping(farmhouse)._getPrice())
    print(MushroomTopping(ExtraCheeseTopping(farmhouse))._getPrice())


