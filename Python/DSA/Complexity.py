import time
from Sorting import long_list
from Sorting import bubbleSort as bbsort
from Sorting import selectionSort as selectsort
from Sorting import insertionSort as insertsort

def for_loop_complexity() :
    startTime = time.time()
    
    count = 0
    for i in range(2**25) :
        count += i
    
    endTime = time.time()
    print("For Loop execution time : " + str(round((endTime-startTime), 4)))

def while_loop_complexity() :
    startTime = time.time()
    
    count = 0
    i = 0
    while (i < 2**25) :
        count += i
        i += 1

    endTime = time.time()
    print("While Loop execution time : " + str(round((endTime-startTime), 4)))

def bubble_sort_complexity() :
    startTime = time.time()
    
    bbsort(long_list)
    # print(bbsort(sortAlgo.long_list))

    endTime = time.time()
    print("Bubble Sort execution time : " + str(round((endTime-startTime), 4)))

def selection_sort_complexity() : 
    startTime = time.time()
    
    selectsort(long_list)
    # print(selectsort(long_list))

    endTime = time.time()
    print("Selection Sort execution time : " + str(round((endTime-startTime), 4)))

def insertion_sort_complexity() : 
    startTime = time.time()
    
    insertsort(long_list)
    # print(insertsort(long_list))

    endTime = time.time()
    print("Insertion Sort execution time : " + str(round((endTime-startTime), 4)))

for_loop_complexity()
print()
while_loop_complexity()
print()
bubble_sort_complexity()
print()
selection_sort_complexity()
print()
insertion_sort_complexity()