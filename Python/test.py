import time




# list = [[1, "Aadarsh", "Delhi", 8588098667], [37, "Deeksha", "Bhopal", 9165590773]]
# print(list)
# list[1].remove(1)
# print(list) 



# pwd = input("Enter your password : ")
# # print(pwd)
# upper = 0
# lower = 0
# for i in pwd : 
#     if (i.isupper) :
#         upper + 1
#     if (i.islower) :
#         lower + 1
# if (upper == 0) :
#     print("The password must have an upperCase letter")
# if (lower == 0) :
#     print("The password must have an lowerCase letter")







'''
    Multiple Inheritance
'''
# class Dealer1 :
#     available = ["i20", "Swift", "Fortuner", "Verna"]
#     def checkAvailablity(self, carName) :
#         if carName in self.available :
#             print(carName + " car is available at Dealer_1.")
#         else :
#             print(carName + " is not available at Dealer_1.")

# class Dealer2 :
#     available = ["i20", "Vitara", "Venue", "Ciaz", "Verna"]
#     def checkAvailablity(self, carName) :
#         if carName in self.available :
#             print(carName + " car is available at Dealer_2.")
#         else :
#             print(carName + " is not available at Dealer_2.")

# class Car(Dealer1, Dealer2) :
#     def carCheck(self, carName) :
#         Dealer1.checkAvailablity(self, carName)
#         Dealer2.checkAvailablity(self, carName)

# car1 = Car()
# car1.carCheck("Fortuner")



# '''
#     Multi-Level Inheritance
# '''
# class Vehicle :
#     def __init__(self, category) :
#         print("This is a " + category +" vehicle.")

# class Car(Vehicle) :
#     def __init__(self, category, brand, carName) :
#         Vehicle.__init__(self, category)
#         print("Brand : " + brand)
#         print("Car Name : " + carName)

# class Detail(Car) :
#     def __init__(self, category, brand, carName, fuel, power) :
#         Car.__init__(self, category, brand, carName)
#         print("Fuel Type : " + fuel)
#         print("Engine Power : " + power)

# # car1 = Car("SUV", "Toyota", "Fortuner")
# car1 = Detail("SUV", "Toyota", "Fortuner", "Petrol/Diesel", "250 bhp")
# car2 = Detail("HatchBack", "Suzuki", "Swift Dzire", "Petrol/Diesel/CNG", "80 bhp")







# class Test :
#     int = 1
#     str = "Aadarsh"

# def fun() :
#     return {obj.int, obj.str}

# obj = Test()
# print(fun())



# a=10
# def fun(a) :
#     global a
#     print(a)
#     print(a)
# # print(a)
# fun(20)



#### Binary Search

# list = [200, 10, 20, 80, 30, 60, 50, 110, 100, 130, 170]
# print(list)
# list.sort()
# print(list)

# listLen = len(list)
# print(listLen)
# midEle = int(listLen/2)
# print(midEle)

# def returnIndex(list) :
#     if(list[midEle] == 110) :
#         return midEle
#     elif (list[midEle] < 110) :
#         for i in range(midEle+1, listLen) :
#             if(list[i] == 110) :
#                 return i
#     elif (list[midEle] > 110) :
#         for i in range (0, midEle) :
#             if(list[i] == 110) :
#                 return i

# print(returnIndex(list))

# print(list.index("c"))





# def fact(k) :
#     if (k == 0) :
#         return 1
    
#     return (k * fact(k-1))

# # print(fcat(5))
# print("Factorial of %d! is : %d" % (5, fact(5)))




# userInput = float(input("Name : "))
# print(type(userInput))



# a = "Aadarsh"
# # str = ""
# for i in a :
#     a = i + a
#     print(a)



# dictionary = {"First Name" : "Aadarsh", "Last Name" : "Yadav"}
# for i in dictionary :
#     print(i)
#     print(dictionary.get(i))
# print(dictionary["First Name"] + " " + dictionary["Last Name"])



### Reverse String using loop

# a = "Aadarsh"
# str = ""
# for i in a :
#     str = i + str
# print(str)