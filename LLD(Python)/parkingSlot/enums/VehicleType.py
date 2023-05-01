from aenum import Enum, NoAlias
class VehicleType(Enum, setting=NoAlias):
    BIKE = 1
    CAR = 2
    TRUCK = 3
    BICYCLE = 4
