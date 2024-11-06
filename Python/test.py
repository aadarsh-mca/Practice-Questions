class Vehicle:
    def __init__(self, make, model):
        self.make = make
        self.model = model
    
    def start_engine(self):
        print(f"{self.make} {self.model}'s engine started.")

class Car(Vehicle):
    def __init__(self, make, model, number_of_doors):
        super().__init__(make, model)
        self.number_of_doors = number_of_doors
    
    def open_doors(self):
        print(f"Opening {self.number_of_doors} doors.")

class Motorcycle(Vehicle):
    def rev_engine(self):
        print(f"{self.make} {self.model} engine revving loudly!")

# Polymorphism in action
vehicles = [Car("Toyota", "Corolla", 4), Motorcycle("Harley-Davidson", "Sportster")]

for vehicle in vehicles:
    vehicle.start_engine()
    if isinstance(vehicle, Car):
        vehicle.open_doors()
    elif isinstance(vehicle, Motorcycle):
        vehicle.rev_engine()
