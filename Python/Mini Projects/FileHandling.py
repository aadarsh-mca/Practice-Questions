file2 = open("test2.txt", "w")

# file.write("Hello, Good Morning everyone !!!\n")
# file.write("My name is Aadarsh Yadav.\n")
# file.write("I am a student of Master of Computer Application (MCA)\n")

with open("test.txt", "r") as data :
    # line = data.readlines()
    # print(line)
    # for line_data in line :
    #     word = line_data.split()
    #     file2.write(str(word))
    file2.write(data.read())
    print(data.read())

file2.close()