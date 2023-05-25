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

list = [200, 10, 20, 80, 30, 60, 50, 110, 100, 130, 170]
print(list)
list.sort()
print(list)

listLen = len(list)
print(listLen)
midEle = int(listLen/2)
print(midEle)

def returnIndex(list) :
    if(list[midEle] == 110) :
        return midEle
    elif (list[midEle] < 110) :
        for i in range(midEle+1, listLen) :
            if(list[i] == 110) :
                return i
    elif (list[midEle] > 110) :
        for i in range (0, midEle) :
            if(list[i] == 110) :
                return i

print(returnIndex(list))

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